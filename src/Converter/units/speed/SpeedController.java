package Converter.units.speed;


import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class SpeedController extends UnitController {
    @FXML
    private TextField kilometerPerHourTextField;
    @FXML
    private TextField meterPerSecondTextField;
    @FXML
    private TextField milePerHourTextField;
    @FXML
    private TextField footPerSecondTextField;
    @FXML
    private TextField knotTextField;
    @FXML
    private TextField speedOfLightTextField;
    @FXML
    private TextField machTextField;

    private HashMap<TextField, SpeedUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(kilometerPerHourTextField, SpeedUnit.KILOMETER_PER_HOUR);
            unitsTable.put(meterPerSecondTextField, SpeedUnit.METER_PER_SECOND);
            unitsTable.put(milePerHourTextField, SpeedUnit.MILE_PER_HOUR);
            unitsTable.put(knotTextField, SpeedUnit.KNOT);
            unitsTable.put(speedOfLightTextField, SpeedUnit.SPEED_OF_LIGHT);
            unitsTable.put(machTextField, SpeedUnit.MACH);
            unitsTable.put(footPerSecondTextField, SpeedUnit.FOOT_PER_SECOND);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        SpeedUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, SpeedUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(SpeedConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
