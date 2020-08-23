package Converter.units.weight;


import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class WeightController extends UnitController {
    @FXML
    private TextField kilogramTextField;
    @FXML
    private TextField gramTextField;
    @FXML
    private TextField poundTextField;
    @FXML
    private TextField ounceTextField;
    @FXML
    private TextField milligramTextField;
    @FXML
    private TextField shortTonTextField;
    @FXML
    private TextField tonTextField;
    @FXML
    private TextField longTonTextField;
    @FXML
    private TextField microgramTextField;

    private HashMap<TextField, WeightUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(kilogramTextField, WeightUnit.KILOGRAM);
            unitsTable.put(gramTextField, WeightUnit.GRAM);
            unitsTable.put(milligramTextField, WeightUnit.MILLIGRAM);
            unitsTable.put(microgramTextField, WeightUnit.MICROGRAM);
            unitsTable.put(ounceTextField, WeightUnit.OUNCE);
            unitsTable.put(poundTextField, WeightUnit.POUND);
            unitsTable.put(tonTextField, WeightUnit.TON);
            unitsTable.put(shortTonTextField, WeightUnit.SHORT_TON);
            unitsTable.put(longTonTextField, WeightUnit.LONG_TON);
        }
    }



    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        WeightUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, WeightUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(WeightConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
