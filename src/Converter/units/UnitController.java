package Converter.units;

import Converter.MainApp;
import javafx.event.Event;

public abstract class UnitController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void backToMenu(){
        this.mainApp.showMenu();
    }

    public abstract void enter(Event event);
}
