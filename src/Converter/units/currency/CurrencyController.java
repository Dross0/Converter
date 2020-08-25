package Converter.units.currency;

import Converter.units.UnitController;
import Converter.units.volume.VolumeConverter;
import Converter.units.volume.VolumeUnit;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class CurrencyController extends UnitController {
    @FXML
    private Label lastUpdateDateLabel;
    @FXML
    private TextField DKKTextField;
    @FXML
    private TextField INRTextField;
    @FXML
    private TextField CADTextField;
    @FXML
    private TextField KGSTextField;
    @FXML
    private TextField CNYTextField;
    @FXML
    private TextField MDLTextField;
    @FXML
    private TextField NOKTextField;
    @FXML
    private TextField PLNTextField;
    @FXML
    private TextField RONTextField;
    @FXML
    private TextField XDRTextField;
    @FXML
    private TextField SGDTextField;
    @FXML
    private TextField TJSTextField;
    @FXML
    private TextField TRYTextField;
    @FXML
    private TextField TMTTextField;
    @FXML
    private TextField UZSTextField;
    @FXML
    private TextField CZKTextField;
    @FXML
    private TextField SEKTextField;
    @FXML
    private TextField CHFTextField;
    @FXML
    private TextField ZARTextField;
    @FXML
    private TextField KRWTextField;
    @FXML
    private TextField JPYTextField;
    @FXML
    private TextField RUBTextField;
    @FXML
    private TextField USDTextField;
    @FXML
    private TextField EURTextField;
    @FXML
    private TextField KZTTextField;
    @FXML
    private TextField UAHTextField;
    @FXML
    private TextField GBPTextField;
    @FXML
    private TextField AUDTextField;
    @FXML
    private TextField BYNTextField;
    @FXML
    private TextField AZNTextField;
    @FXML
    private TextField AMDTextField;
    @FXML
    private TextField BGNTextField;
    @FXML
    private TextField BRLTextField;
    @FXML
    private TextField HUFTextField;
    @FXML
    private TextField HKDTextField;

    private HashMap<TextField, CurrencyUnit> unitsTable = new HashMap<>();

    private final int CONVERT_ERROR_CODE = -1;

    @FXML
    public void initialize(){
            unitsTable.put(RUBTextField, CurrencyUnit.RUB);
            unitsTable.put(USDTextField, CurrencyUnit.USD);
            unitsTable.put(EURTextField, CurrencyUnit.EUR);
            unitsTable.put(BYNTextField, CurrencyUnit.BYN);
            unitsTable.put(UAHTextField, CurrencyUnit.UAH);
            unitsTable.put(AZNTextField, CurrencyUnit.AZN);
            unitsTable.put(AMDTextField, CurrencyUnit.AMD);
            unitsTable.put(BGNTextField, CurrencyUnit.BGN);
            unitsTable.put(BRLTextField, CurrencyUnit.BRL);
            unitsTable.put(HUFTextField, CurrencyUnit.HUF);
            unitsTable.put(GBPTextField, CurrencyUnit.GBP);
            unitsTable.put(HKDTextField, CurrencyUnit.HKD);
            unitsTable.put(KZTTextField, CurrencyUnit.KZT);
            unitsTable.put(AUDTextField, CurrencyUnit.AUD);
            unitsTable.put(DKKTextField, CurrencyUnit.DKK);
            unitsTable.put(INRTextField, CurrencyUnit.INR);
            unitsTable.put(CADTextField, CurrencyUnit.CAD);
            unitsTable.put(KGSTextField, CurrencyUnit.KGS);
            unitsTable.put(CNYTextField, CurrencyUnit.CNY);
            unitsTable.put(MDLTextField, CurrencyUnit.MDL);
            unitsTable.put(NOKTextField, CurrencyUnit.NOK);
            unitsTable.put(PLNTextField, CurrencyUnit.PLN);
            unitsTable.put(RONTextField, CurrencyUnit.RON);
            unitsTable.put(XDRTextField, CurrencyUnit.XDR);
            unitsTable.put(SGDTextField, CurrencyUnit.SGD);
            unitsTable.put(TJSTextField, CurrencyUnit.TJS);
            unitsTable.put(TRYTextField, CurrencyUnit.TRY);
            unitsTable.put(TMTTextField, CurrencyUnit.TMT);
            unitsTable.put(UZSTextField, CurrencyUnit.UZS);
            unitsTable.put(CZKTextField, CurrencyUnit.CZK);
            unitsTable.put(SEKTextField, CurrencyUnit.SEK);
            unitsTable.put(CHFTextField, CurrencyUnit.CHF);
            unitsTable.put(ZARTextField, CurrencyUnit.ZAR);
            unitsTable.put(KRWTextField, CurrencyUnit.KRW);
            unitsTable.put(JPYTextField, CurrencyUnit.JPY);
            fillDefaultTextFields();
    }

    private void fillDefaultTextFields(){
        for (TextField textField: unitsTable.keySet()){
            textField.setText("0.0");
        }
    }

    @FXML
    public void enter(Event event){
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        CurrencyUnit fromUnit = unitsTable.get(currentTextField);
        double value = 0;
        try {
            value = Double.parseDouble(currentTextField.getText());
        }
        catch (NumberFormatException ex){
            printError(currentTextField, "0.0");
            return;
        }
        boolean isError = false;
        for (Map.Entry<TextField, CurrencyUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                double convertedValue = CurrencyConverter.convert(value, fromUnit, entry.getValue());
                if (convertedValue == CONVERT_ERROR_CODE){
                    isError = true;
                    printError(currentTextField, "Ошибка в получении курсов валют");
                    break;
                }
                entry.getKey().setText(Double.toString(convertedValue));
            }
        }
        if (!isError){
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            lastUpdateDateLabel.setText(format.format(CurrencyConverter.getLastUpdateDate()));
        }
    }

    private void printError(TextField currentTextField, String message){
        for (Map.Entry<TextField, CurrencyUnit> entry: unitsTable.entrySet()) {
            if (entry.getKey() != currentTextField) {
                entry.getKey().setText(message);
            }
        }
    }
}
