package eu.artofcoding.abrechnung.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("."));
        String fxml = "ComplexApplication/ComplexApplication.fxml";
        Parent rootNode = (Parent) fxmlLoader.load(Main.class.getResourceAsStream(fxml));
        MainController mainController = fxmlLoader.getController();
        mainController.setStage(stage);
        //
        Scene scene = new Scene(rootNode, 1024, 700);
        scene.getStylesheets().add(Main.class.getResource("ComplexApplication/ComplexApplication.css").toExternalForm());
        stage.setTitle("art of coding Abrechnung");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
