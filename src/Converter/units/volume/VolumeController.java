package Converter.units.volume;

import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class VolumeController extends UnitController {
    @FXML
    private TextField millilitreTextField;
    @FXML
    private TextField litreTextField;
    @FXML
    private TextField cubicMillimeterTextField;
    @FXML
    private TextField cubicCentimeterTextField;
    @FXML
    private TextField cubicMeterTextField;
    @FXML
    private TextField cubicInchTextField;
    @FXML
    private TextField cubicFootTextField;
    @FXML
    private TextField cubicYardTextField;
    @FXML
    private TextField gallonUSATextField;
    @FXML
    private TextField gallonUKTextField;
    @FXML
    private TextField fluidOunceTextField;
    @FXML
    private TextField pintTextField;
    @FXML
    private TextField quartTextField;
    @FXML
    private TextField teaspoonTextField;
    @FXML
    private TextField tablespoonTextField;

    private HashMap<TextField, VolumeUnit> unitsTable = new HashMap<>();

    @FXML
    public void initialize(){
        unitsTable.put(millilitreTextField, VolumeUnit.MILLILITRE);
        unitsTable.put(litreTextField, VolumeUnit.LITRE);
        unitsTable.put(cubicMillimeterTextField, VolumeUnit.CUBIC_MILLIMETER);
        unitsTable.put(cubicCentimeterTextField, VolumeUnit.CUBIC_CENTIMETER);
        unitsTable.put(cubicMeterTextField, VolumeUnit.CUBIC_METER);
        unitsTable.put(gallonUSATextField, VolumeUnit.GALLON_USA);
        unitsTable.put(gallonUKTextField, VolumeUnit.GALLON_UK);
        unitsTable.put(teaspoonTextField, VolumeUnit.TEASPOON);
        unitsTable.put(tablespoonTextField, VolumeUnit.TABLESPOON);
        unitsTable.put(fluidOunceTextField, VolumeUnit.FLUID_OUNCE);
        unitsTable.put(cubicInchTextField, VolumeUnit.CUBIC_INCH);
        unitsTable.put(cubicYardTextField, VolumeUnit.CUBIC_YARD);
        unitsTable.put(cubicFootTextField, VolumeUnit.CUBIC_FOOT);
        unitsTable.put(pintTextField, VolumeUnit.PINT);
        unitsTable.put(quartTextField, VolumeUnit.QUART);
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
        VolumeUnit fromUnit = unitsTable.get(currentTextField);
        double value = 0;
        try {
            value = Double.parseDouble(currentTextField.getText());
        }
        catch (NumberFormatException ignored){}
        for (Map.Entry<TextField, VolumeUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(VolumeConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
