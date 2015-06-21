package eu.artofcoding.abrechnung.javafx;

import eu.artofcoding.abrechnung.model.JAXBHelper;
import eu.artofcoding.abrechnung.model.jaxb.Model;
import eu.artofcoding.abrechnung.model.jaxb.Customer;
import eu.artofcoding.abrechnung.model.jaxb.CustomerModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    private Stage stage;

    @FXML
    private Button hereWeGoButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(this + ": initialize");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void hereWeGo() throws JAXBException, FileNotFoundException {
        CustomerModel customerModel = Model.getInstance().getCustomerModel();
        Customer customer = new Customer();
        customer.setFirstname("Ralf");
        customer.setLastname("Bensmann");
        customerModel.getCustomer().add(customer);
        JAXBHelper.serialize(customerModel, Paths.get("customers.xml"));
    }

}
