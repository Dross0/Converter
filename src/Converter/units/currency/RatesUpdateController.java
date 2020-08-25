package Converter.units.currency;

import Converter.units.currency.exceptions.ClientConnectionException;
import Converter.units.currency.exceptions.ConnectionException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RatesUpdateController {
    private HashMap<CurrencyUnit, Double> rates;
    private String QUERY;
    private String jsonString;
    private Date lastUpdateTime;
    private int MINUTES_BETWEEN_UPDATE;
    private HashMap<CurrencyUnit, Currency> currencyMap;
    private boolean FATAL_ERROR = false;

    public RatesUpdateController(FileInputStream cfgFile) throws IOException {
        Properties properties = new Properties();
        properties.load(cfgFile);
        this.QUERY = properties.getProperty("URL");
        this.MINUTES_BETWEEN_UPDATE = Integer.parseInt(properties.get("MINUTES_BETWEEN_REQUESTS").toString());
        this.rates = new HashMap<>();
        this.currencyMap = new HashMap<>();
        lastUpdateTime = new Date();
        lastUpdateTime.setTime(0);  // Set date for first request
    }

    private Currency parseCurrency(JsonObject currencyObject){
        String charCode = currencyObject.get("CharCode").toString();
        int nominal = currencyObject.getAsJsonPrimitive("Nominal").getAsInt();
        double value = currencyObject.getAsJsonPrimitive("Value").getAsDouble();
        return new Currency(charCode, nominal, value);
    }

    private void parse(){
        Object obj = JsonParser.parseString(jsonString);
        JsonObject jsonObject = (JsonObject) obj;
        JsonObject currencyList = jsonObject.getAsJsonObject("Valute");
        CurrencyUnit [] currencyUnits = CurrencyUnit.values();
        for (CurrencyUnit currencyUnit: currencyUnits){
            if (currencyUnit == CurrencyUnit.RUB){
                continue;
            }
            JsonObject currencyObject = currencyList.getAsJsonObject(currencyUnit.getCharCode());
            Currency currency = this.parseCurrency(currencyObject);
            currencyMap.put(currencyUnit, currency);
        }
    }

    private void getJsonData() throws ConnectionException, ClientConnectionException {
        HttpURLConnection connection = null;
        StringBuilder jsonSB = new StringBuilder();
        try{
            connection = (HttpURLConnection) new URL(this.QUERY).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null){
                    jsonSB.append(line);
                    jsonSB.append("\n");
                }
            }
            else{
                int code = connection.getResponseCode();
                if (code >= 400 && code <= 499){
                    throw new ClientConnectionException("Client error code");
                }
                throw new ConnectionException("Wrong status");
            }
        }
        catch (ClientConnectionException ex){
            throw ex;
        }
        catch (Exception ex){
            throw new ConnectionException(ex.getMessage());
        }
        finally {
            if (connection != null){
                connection.disconnect();
            }
        }
        this.jsonString = jsonSB.toString();
        lastUpdateTime = new Date();
    }

    public void update() throws ConnectionException, ClientConnectionException {
        if (FATAL_ERROR){
            throw new ClientConnectionException("Client fatal error");
        }
        Date currentDate = new Date();
        if (getMinutesBetweenDates(lastUpdateTime, currentDate) < MINUTES_BETWEEN_UPDATE){
            return;
        }
        try {
            getJsonData();
            parse();
        } catch (ConnectionException ex) {
            if (rates.size() > 0){
                return;     // Use old data if cant connect
            }
            throw ex;
        }
        catch (ClientConnectionException ex){
            this.FATAL_ERROR = true;
        }
        rates.put(CurrencyUnit.RUB, 1.0);
        for (Map.Entry<CurrencyUnit, Currency> currencyEntry: currencyMap.entrySet()){
            int nominal = currencyEntry.getValue().getNominal();
            double value = currencyEntry.getValue().getValue();
            rates.put(currencyEntry.getKey(), value / nominal);
        }
    }

    public HashMap<CurrencyUnit, Double> getRates() {
        return rates;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    private int getMinutesBetweenDates(Date date1, Date date2){
        long milliseconds = Math.abs(date2.getTime() - date1.getTime());
        return (int) (milliseconds / (1000 * 60));
    }
}
