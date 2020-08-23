package Converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Stage primaryStage;
    private Scene menuScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("mainMenu.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setMainApp(this);
        this.menuScene = new Scene(root);
        this.primaryStage.setScene(this.menuScene);
        this.primaryStage.show();
    }

    public Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showMenu() {
        this.primaryStage.setScene(this.menuScene);
    }
}
