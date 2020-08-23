package Converter.units.power;

import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class PowerController extends UnitController {
    @FXML
    private TextField horsePowerTextField;
    @FXML
    private TextField wattTextField;
    @FXML
    private TextField kilowattTextField;
    @FXML
    private TextField calPerSecTextField;
    @FXML
    private TextField kilocalPerSecTextField;
    @FXML
    private TextField btuPerHrTextField;
    @FXML
    private TextField btuPerSecTextField;

    private HashMap<TextField, PowerUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(horsePowerTextField, PowerUnit.HORSE_POWER);
            unitsTable.put(wattTextField, PowerUnit.WATT);
            unitsTable.put(kilowattTextField, PowerUnit.KILOWATT);
            unitsTable.put(kilocalPerSecTextField, PowerUnit.KILOCAL);
            unitsTable.put(calPerSecTextField, PowerUnit.CAL);
            unitsTable.put(btuPerHrTextField, PowerUnit.BTU_PER_HOUR);
            unitsTable.put(btuPerSecTextField, PowerUnit.BTU_PER_SECOND);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        PowerUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, PowerUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(PowerConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
