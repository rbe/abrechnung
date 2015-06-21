package eu.artofcoding.abrechnung.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private Stage stage;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Button showCustomerButton;

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            //scene.getStylesheets().add(Main.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }

    @FXML
    public void initialize() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void showCustomerButtonPressed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("."));
        String fxml = "ComplexApplication/CustomerPane.fxml";
        Parent page = FXMLLoader.load(Main.class.getResource(fxml));
        contentPane.getChildren().add(page);
        CustomerController customerController = fxmlLoader.getController();
        if (null != customerController) {
            customerController.setStage(stage);
        } else {
            System.out.println("No controller");
        }
    }

}
