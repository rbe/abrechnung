package eu.artofcoding.abrechnung.model.jaxb;

import eu.artofcoding.abrechnung.model.JAXBHelper;
import eu.artofcoding.abrechnung.model.JAXBTestHelper;
import eu.artofcoding.abrechnung.model.jaxb.Customer;
import eu.artofcoding.abrechnung.model.jaxb.CustomerModel;
import eu.artofcoding.abrechnung.model.jaxb.Model;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerJAXBTest {

    @Test
    public void test1CustomerSerialize() throws JAXBException, FileNotFoundException {
        Customer customer = JAXBTestHelper.getCustomer();
        CustomerModel customerModel = Model.getInstance().getCustomerModel();
        customerModel.getCustomer().add(customer);
        JAXBHelper.serialize(customerModel, JAXBTestHelper.PATH_CUSTOMER_MODEL);
    }

    @Test
    public void test2CustomerDeserialize() throws JAXBException, FileNotFoundException {
        CustomerModel customerModel = JAXBHelper.deserialize(CustomerModel.class, JAXBTestHelper.PATH_CUSTOMER_MODEL);
        Customer customer = customerModel.getCustomer().iterator().next();
        assertThat(customer.getId(), is("CUST-1"));
        assertThat(customer.getFirstname(), is("Manni"));
        assertThat(customer.getLastname(), is("Monster"));
        assertThat(customer.getAddress1(), is("Address 1"));
        assertThat(customer.getAddress2(), is("Address 2"));
        assertThat(customer.getZipcode(), is("12345"));
        assertThat(customer.getCity(), is("Hamburg"));
    }

}
