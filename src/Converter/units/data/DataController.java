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

    private HashMap<TextField, DataUnit> unitsTable = new HashMap<>();


    @FXML
    public void initialize(){
        unitsTable.put(bitTextField, DataUnit.BIT);
        unitsTable.put(kilobitTextField, DataUnit.KILOBIT);
        unitsTable.put(megabitTextField, DataUnit.MEGABIT);
        unitsTable.put(gigabitTextField, DataUnit.GIGABIT);
        unitsTable.put(byteTextField, DataUnit.BYTE);
        unitsTable.put(kilobyteTextField, DataUnit.KILOBYTE);
        unitsTable.put(megabyteTextField, DataUnit.MEGABYTE);
        unitsTable.put(gigabyteTextField, DataUnit.GIGABYTE);
        unitsTable.put(terabyteTextField, DataUnit.TERABYTE);
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
        DataUnit fromUnit = unitsTable.get(currentTextField);
        double value = 0;
        try {
            value = Double.parseDouble(currentTextField.getText());
        }
        catch (NumberFormatException ignored){}
        for (Map.Entry<TextField, DataUnit> entry: unitsTable.entrySet()){
            if (entry.getKey() != currentTextField){
                entry.getKey().setText(Double.toString(DataConverter.convert(value, fromUnit, entry.getValue())));
            }
        }
    }
}
