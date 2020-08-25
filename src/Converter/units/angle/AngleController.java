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

    private HashMap<TextField, AngleUnit> unitsTable = new HashMap<>();

    @FXML
    public void initialize(){
        unitsTable.put(circleTextField, AngleUnit.CIRCLE);
        unitsTable.put(degreeTextField, AngleUnit.DEGREE);
        unitsTable.put(radianTextField, AngleUnit.RADIAN);
        unitsTable.put(gradianTextField, AngleUnit.GRADIAN);
        unitsTable.put(minuteTextField, AngleUnit.MINUTE);
        unitsTable.put(secondTextField, AngleUnit.SECOND);
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
        AngleUnit fromUnit = unitsTable.get(currentTextField);
        double value = 0;
        try {
            value = Double.parseDouble(currentTextField.getText());
        }
        catch (NumberFormatException ignored){}
        for (Map.Entry<TextField, AngleUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(AngleConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
