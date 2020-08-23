package Converter.units.time;


import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class TimeController extends UnitController {
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField weekTextField;
    @FXML
    private TextField dayTextField;
    @FXML
    private TextField hourTextField;
    @FXML
    private TextField minuteTextField;
    @FXML
    private TextField secondTextField;
    @FXML
    private TextField millisecondTextField;
    @FXML
    private TextField microsecondTextField;
    @FXML
    private TextField nanosecondTextField;

    private HashMap<TextField, TimeUnit> unitsTable;

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(nanosecondTextField, TimeUnit.NANOSECOND);
            unitsTable.put(microsecondTextField, TimeUnit.MICROSECOND);
            unitsTable.put(millisecondTextField, TimeUnit.MILLISECOND);
            unitsTable.put(secondTextField, TimeUnit.SECOND);
            unitsTable.put(minuteTextField, TimeUnit.MINUTE);
            unitsTable.put(hourTextField, TimeUnit.HOUR);
            unitsTable.put(dayTextField, TimeUnit.DAY);
            unitsTable.put(weekTextField, TimeUnit.WEEK);
            unitsTable.put(monthTextField, TimeUnit.MONTH);
            unitsTable.put(yearTextField, TimeUnit.YEAR);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        TimeUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, TimeUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(TimeConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
