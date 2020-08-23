package Converter.units.energy;


import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class EnergyController extends UnitController {
    @FXML
    private TextField caloriesTextField;
    @FXML
    private TextField kilocaloriesTextField;
    @FXML
    private TextField jouleTextField;
    @FXML
    private TextField kilojouleTextField;
    @FXML
    private TextField kilowattPerHourTextField;
    @FXML
    private TextField ergTextField;
    @FXML
    private TextField btuTextField;


    private HashMap<TextField, EnergyUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(caloriesTextField, EnergyUnit.CALORIES);
            unitsTable.put(kilocaloriesTextField, EnergyUnit.KILOCALORIES);
            unitsTable.put(jouleTextField, EnergyUnit.JOULE);
            unitsTable.put(kilojouleTextField, EnergyUnit.KILOJOULE);
            unitsTable.put(kilowattPerHourTextField, EnergyUnit.KILOWATT_PER_HOUR);
            unitsTable.put(ergTextField, EnergyUnit.ERG);
            unitsTable.put(btuTextField, EnergyUnit.BTU);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        EnergyUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, EnergyUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(EnergyConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
