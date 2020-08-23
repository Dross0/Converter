package Converter.units.angle;

import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class AngleController extends UnitController {
    @FXML
    private TextField circleTextField;
    @FXML
    private TextField radianTextField;
    @FXML
    private TextField degreeTextField;
    @FXML
    private TextField gradianTextField;
    @FXML
    private TextField minuteTextField;
    @FXML
    private TextField secondTextField;

    private HashMap<TextField, AngleUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(circleTextField, AngleUnit.CIRCLE);
            unitsTable.put(degreeTextField, AngleUnit.DEGREE);
            unitsTable.put(radianTextField, AngleUnit.RADIAN);
            unitsTable.put(gradianTextField, AngleUnit.GRADIAN);
            unitsTable.put(minuteTextField, AngleUnit.MINUTE);
            unitsTable.put(secondTextField, AngleUnit.SECOND);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        AngleUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, AngleUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(AngleConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
