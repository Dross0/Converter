package Converter.units.currency;

import Converter.IConverter;
import Converter.units.currency.exceptions.ClientConnectionException;
import Converter.units.currency.exceptions.ConnectionException;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class CurrencyConverter implements IConverter {
    private static RatesUpdateController ratesUpdateController;
    private static int ERROR_CODE = -1;

    static {
        try {
            ratesUpdateController = new RatesUpdateController(new FileInputStream("cfg/API_config.properties"));
        } catch (IOException e) {
            ratesUpdateController = null;
        }
    }

    public static Date getLastUpdateDate() {
        if (ratesUpdateController != null) {
            return ratesUpdateController.getLastUpdateTime();
        }
        return null;
    }

    public static double convert(double value, CurrencyUnit fromUnit, CurrencyUnit toUnit){
        if (ratesUpdateController == null){
            return ERROR_CODE;
        }
        try {
            ratesUpdateController.update();
        } catch (ConnectionException | ClientConnectionException e) {
            return ERROR_CODE;
        }
        HashMap<CurrencyUnit, Double> rates = ratesUpdateController.getRates();
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
