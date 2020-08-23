package Converter.units.square;


import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class SquareController extends UnitController {
    @FXML
    private TextField squareMillimeterTextField;
    @FXML
    private TextField squareCentimeterTextField;
    @FXML
    private TextField squareDecimeterTextField;
    @FXML
    private TextField squareMeterTextField;
    @FXML
    private TextField squareKilometerTextField;
    @FXML
    private TextField squareInchTextField;
    @FXML
    private TextField squareFootTextField;
    @FXML
    private TextField squareYardTextField;
    @FXML
    private TextField squareMileTextField;
    @FXML
    private TextField acreTextField;
    @FXML
    private TextField areTextField;
    @FXML
    private TextField hectareTextField;
    @FXML
    private TextField squareMicrometerTextField;

    private HashMap<TextField, SquareUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(squareMillimeterTextField, SquareUnit.SQUARE_MILLIMETER);
            unitsTable.put(squareCentimeterTextField, SquareUnit.SQUARE_CENTIMETER);
            unitsTable.put(squareDecimeterTextField, SquareUnit.SQUARE_DECIMETER);
            unitsTable.put(squareMeterTextField, SquareUnit.SQUARE_METER);
            unitsTable.put(squareKilometerTextField, SquareUnit.SQUARE_KILOMETER);
            unitsTable.put(squareInchTextField, SquareUnit.SQUARE_INCH);
            unitsTable.put(squareYardTextField, SquareUnit.SQUARE_YARD);
            unitsTable.put(squareFootTextField, SquareUnit.SQUARE_FOOT);
            unitsTable.put(squareMileTextField, SquareUnit.SQUARE_MILE);
            unitsTable.put(acreTextField, SquareUnit.ACRE);
            unitsTable.put(areTextField, SquareUnit.ARE);
            unitsTable.put(hectareTextField, SquareUnit.HECTARE);
            unitsTable.put(squareMicrometerTextField, SquareUnit.SQUARE_MICROMETER);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        SquareUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, SquareUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(SquareConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
