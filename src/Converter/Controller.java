package Converter;

import Converter.units.UnitController;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;


public class Controller {
    @FXML
    private Button currencyButton;
    @FXML
    private Button angleButton;
    @FXML
    private Button volumeButton;
    @FXML
    private Button squareButton;
    @FXML
    private Button temperatureButton;
    @FXML
    private Button lengthButton;
    @FXML
    private Button weightButton;
    @FXML
    private Button speedButton;
    @FXML
    private Button timeButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button energyButton;
    @FXML
    private Button dataButton;

    private HashMap<Button, URL> referenceToConverterView;
    private MainApp mainApp;

    public void init(){
        if (referenceToConverterView == null){
            referenceToConverterView = new HashMap<>();
            referenceToConverterView.put(temperatureButton, Controller.class.getResource("units/temperature/temperature.fxml"));
            referenceToConverterView.put(lengthButton, Controller.class.getResource("units/length/length.fxml"));
            referenceToConverterView.put(weightButton, Controller.class.getResource("units/weight/weight.fxml"));
            referenceToConverterView.put(speedButton, Controller.class.getResource("units/speed/speed.fxml"));
            referenceToConverterView.put(timeButton, Controller.class.getResource("units/time/time.fxml"));
            referenceToConverterView.put(powerButton, Controller.class.getResource("units/power/power.fxml"));
            referenceToConverterView.put(energyButton, Controller.class.getResource("units/energy/energy.fxml"));
            referenceToConverterView.put(dataButton, Controller.class.getResource("units/data/data.fxml"));
            referenceToConverterView.put(squareButton, Controller.class.getResource("units/square/square.fxml"));
            referenceToConverterView.put(volumeButton, Controller.class.getResource("units/volume/volume.fxml"));
            referenceToConverterView.put(angleButton, Controller.class.getResource("units/angle/angle.fxml"));
            referenceToConverterView.put(currencyButton, Controller.class.getResource("units/currency/currency.fxml"));
        }
    }

    @FXML
    public void switchColor(Event event){
        init();
        EventTarget eventTarget = event.getTarget();
        if (referenceToConverterView.containsKey(eventTarget)){
            Button button = (Button) eventTarget;
            button.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

        }
    }


    @FXML
    public void showConverter(Event event) {
        init();
        EventTarget eventTarget = event.getTarget();
        for (Button button: referenceToConverterView.keySet()){
            if (button.equals(eventTarget)){
                Scene scene = loadScene(referenceToConverterView.get(button));
                this.mainApp.getStage().setScene(scene);
            }
        }
    }

    private Scene loadScene(URL url) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        try{
            Parent root = loader.load();
            UnitController controller = loader.getController();
            controller.setMainApp(this.mainApp);
            return new Scene(root);
        }catch (IOException ignored){}
        return null;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
