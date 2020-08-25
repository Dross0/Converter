package Converter.units.temperature;


import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;


public class TemperatureController extends UnitController {
    @FXML
    private TextField celsiusTextField;
    @FXML
    private TextField fahrenheitTextField;
    @FXML
    private TextField kelvinTextField;


    private HashMap<TextField, TemperatureUnit> unitsTable = new HashMap<>();

    @FXML
    public void initialize(){
        unitsTable.put(celsiusTextField, TemperatureUnit.CELSIUS);
        unitsTable.put(fahrenheitTextField, TemperatureUnit.FAHRENHEIT);
        unitsTable.put(kelvinTextField, TemperatureUnit.KELVIN);
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
        TemperatureUnit fromUnit = unitsTable.get(currentTextField);
        double value = 0;
        boolean isNumberFormatException = false;
        try {
            value = Double.parseDouble(currentTextField.getText());
        }
        catch (NumberFormatException ex){
            for (Map.Entry<TextField, TemperatureUnit> entry: unitsTable.entrySet()) {
                if (entry.getKey() != currentTextField) {
                    entry.getKey().setText("0.0");
                }
            }
            isNumberFormatException = true;
        }
        if (!isNumberFormatException) {
            for (Map.Entry<TextField, TemperatureUnit> entry : unitsTable.entrySet()) {
                if (entry.getKey() != currentTextField) {
                    entry.getKey().setText(Double.toString(TemperatureConverter.convert(value, fromUnit, entry.getValue())));
                }
            }
        }
    }
}
