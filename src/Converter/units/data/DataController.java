package Converter.units.data;


import Converter.MainApp;
import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class DataController extends UnitController {
    @FXML
    private TextField bitTextField;
    @FXML
    private TextField kilobitTextField;
    @FXML
    private TextField megabitTextField;
    @FXML
    private TextField gigabitTextField;
    @FXML
    private TextField byteTextField;
    @FXML
    private TextField kilobyteTextField;
    @FXML
    private TextField megabyteTextField;
    @FXML
    private TextField gigabyteTextField;
    @FXML
    private TextField terabyteTextField;

    private HashMap<TextField, DataUnit> unitsTable;
    

    public void init(){
        if (unitsTable == null) {
            unitsTable = new HashMap<>();
            unitsTable.put(bitTextField, DataUnit.BIT);
            unitsTable.put(kilobitTextField, DataUnit.KILOBIT);
            unitsTable.put(megabitTextField, DataUnit.MEGABIT);
            unitsTable.put(gigabitTextField, DataUnit.GIGABIT);
            unitsTable.put(byteTextField, DataUnit.BYTE);
            unitsTable.put(kilobyteTextField, DataUnit.KILOBYTE);
            unitsTable.put(megabyteTextField, DataUnit.MEGABYTE);
            unitsTable.put(gigabyteTextField, DataUnit.GIGABYTE);
            unitsTable.put(terabyteTextField, DataUnit.TERABYTE);
        }
    }


    @FXML
    public void enter(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        TextField currentTextField = (TextField) eventTarget;
        DataUnit fromUnit = unitsTable.get(currentTextField);
        double value = Double.parseDouble(currentTextField.getText());
        for (Map.Entry<TextField, DataUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(DataConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
