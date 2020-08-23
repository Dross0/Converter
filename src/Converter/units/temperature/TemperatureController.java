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


    private HashMap<TextField, TemperatureUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(celsiusTextField, TemperatureUnit.CELSIUS);
            unitsTable.put(fahrenheitTextField, TemperatureUnit.FAHRENHEIT);
            unitsTable.put(kelvinTextField, TemperatureUnit.KELVIN);
        }
    }


    @FXML
     public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        TemperatureUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, TemperatureUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(TemperatureConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
