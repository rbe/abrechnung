package eu.artofcoding.abrechnung.model.jaxb;

import eu.artofcoding.abrechnung.model.JAXBHelper;
import eu.artofcoding.abrechnung.model.JAXBTestHelper;
import eu.artofcoding.abrechnung.model.jaxb.Customer;
import eu.artofcoding.abrechnung.model.jaxb.Model;
import eu.artofcoding.abrechnung.model.jaxb.Product;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelJAXBTest {

    @Test
    public void test1ModelSerialize() throws JAXBException, FileNotFoundException {
        Model model = Model.getInstance();
        model.getCustomerModel().getCustomer().add(JAXBTestHelper.getCustomer());
        model.getProductModel().getProduct().add(JAXBTestHelper.getProductTaxRate7());
        model.getProductModel().getProduct().add(JAXBTestHelper.getProductTaxRate19());
        model.getProductModel().getProduct().add(JAXBTestHelper.getPeriodicProductTaxRate19());
        model.getInvoiceModel().getInvoice().add(JAXBTestHelper.getInvoice());
        JAXBHelper.serialize(model, JAXBTestHelper.PATH_MODEL);
    }

    @Test
    public void test2ModelDeserialize() throws JAXBException, FileNotFoundException {
        Model model = JAXBHelper.deserialize(Model.class, JAXBTestHelper.PATH_MODEL);
        Iterator<Customer> customerIterator = model.getCustomerModel().getCustomer().iterator();
        Customer customer = customerIterator.next();
        assertThat(customer.getId(), is("CUST-1"));
        Iterator<Product> productIterator = model.getProductModel().getProduct().iterator();
        Product product1 = productIterator.next();
        assertThat(product1.getId(), is("12345"));
        Product product2 = productIterator.next();
        assertThat(product2.getId(), is("67890"));
    }

}
