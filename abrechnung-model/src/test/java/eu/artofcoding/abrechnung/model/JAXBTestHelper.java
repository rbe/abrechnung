package eu.artofcoding.abrechnung.model;

import eu.artofcoding.abrechnung.model.jaxb.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class JAXBTestHelper {

    public static final Path PATH_CUSTOMER_MODEL = Paths.get("target/customer.xml");

    public static final Path PATH_PRODUCT_MODEL = Paths.get("target/product.xml");

    public static final Path PATH_INVOICE_MODEL = Paths.get("target/invoice.xml");

    public static final Path PATH_MODEL = Paths.get("target/model.xml");

    public static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId("CUST-1");
        customer.setFirstname("Manni");
        customer.setLastname("Monster");
        customer.setDateOfBirth(new Date());
        customer.setAddress1("Address 1");
        customer.setAddress2("Address 2");
        customer.setZipcode("12345");
        customer.setCity("Hamburg");
        customer.getPeriodicProducts().add(getPeriodicProductTaxRate19());
        return customer;
    }

    public static Product getProductTaxRate7() {
        Product product = new Product();
        product.setId("12345");
        product.setName("Product 1");
        product.setDescription("Description");
        product.setPrice(10.0);
        product.setTaxRate(7.0);
        return product;
    }

    public static Product getProductTaxRate19() {
        Product product = new Product();
        product.setId("67890");
        product.setName("Product 2");
        product.setDescription("Description");
        product.setPrice(100.0);
        product.setTaxRate(19.0);
        return product;
    }

    public static PeriodicProduct getPeriodicProductTaxRate19() {
        PeriodicProduct product = new PeriodicProduct();
        product.setId("67891");
        product.setName("Product 3");
        product.setDescription("Description");
        product.setPrice(100.0);
        product.setTaxRate(19.0);
        product.setInterval(new Interval(1, "daily"));
        product.setLastChargedDate(new Date());
        return product;
    }

    public static Invoice getInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId("INV-1");
        invoice.setCustomer(getCustomer());
        invoice.getProducts().add(getProductTaxRate7());
        invoice.getProducts().add(getProductTaxRate19());
        invoice.getProducts().add(getPeriodicProductTaxRate19());
        return invoice;
    }

}
