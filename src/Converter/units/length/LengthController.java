package Converter.units.length;

import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class LengthController extends UnitController {
    @FXML
    private TextField footTextField;
    @FXML
    private TextField mileTextField;
    @FXML
    private TextField inchTextField;
    @FXML
    private TextField yardTextField;
    @FXML
    private TextField fathomTextField;
    @FXML
    private TextField nauticalMileTextField;
    @FXML
    private TextField centimeterTextField;
    @FXML
    private TextField meterTextField;
    @FXML
    private TextField decimeterTextField;
    @FXML
    private TextField millimeterTextField;
    @FXML
    private TextField kilometerTextField;


    private HashMap<TextField, LengthUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(meterTextField, LengthUnit.METER);
            unitsTable.put(centimeterTextField, LengthUnit.CENTIMETER);
            unitsTable.put(decimeterTextField, LengthUnit.DECIMETER);
            unitsTable.put(kilometerTextField, LengthUnit.KILOMETER);
            unitsTable.put(millimeterTextField, LengthUnit.MILLIMETER);
            unitsTable.put(fathomTextField, LengthUnit.FATHOM_USA);
            unitsTable.put(nauticalMileTextField, LengthUnit.NAUTICAL_MILE);
            unitsTable.put(inchTextField, LengthUnit.INCH);
            unitsTable.put(yardTextField, LengthUnit.YARD);
            unitsTable.put(mileTextField, LengthUnit.MILE);
            unitsTable.put(footTextField, LengthUnit.FOOT);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        LengthUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, LengthUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(LengthConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
