package eu.artofcoding.abrechnung.model.jaxb;

import eu.artofcoding.abrechnung.model.JAXBHelper;
import eu.artofcoding.abrechnung.model.JAXBTestHelper;
import eu.artofcoding.abrechnung.model.jaxb.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductJAXBTest {

    @Test
    public void test1ProductSerialize() throws JAXBException, FileNotFoundException {
        ProductModel productModel = Model.getInstance().getProductModel();
        productModel.getProduct().add(JAXBTestHelper.getProductTaxRate7());
        productModel.getProduct().add(JAXBTestHelper.getProductTaxRate19());
        productModel.getProduct().add(JAXBTestHelper.getPeriodicProductTaxRate19());
        JAXBHelper.serialize(productModel, JAXBTestHelper.PATH_PRODUCT_MODEL);
    }

    @Test
    public void test2ProductDeserialize() throws JAXBException, FileNotFoundException {
        ProductModel productModel = JAXBHelper.deserialize(ProductModel.class, JAXBTestHelper.PATH_PRODUCT_MODEL);
        Iterator<Product> iterator = productModel.getProduct().iterator();
        Product product7 = iterator.next();
        assertThat(product7.getId(), is("12345"));
        assertThat(product7.getName(), is("Product 1"));
        Product product19 = iterator.next();
        assertThat(product19.getId(), is("67890"));
        assertThat(product19.getName(), is("Product 2"));
        PeriodicProduct periodicProduct1 = (PeriodicProduct) iterator.next();
        assertThat(periodicProduct1.getId(), is("67891"));
        //
        Set<PeriodicProduct> periodicProducts = productModel.getPeriodicProducts();
        for (PeriodicProduct periodicProduct : periodicProducts) {
            System.out.println(periodicProduct);
        }
    }

}
