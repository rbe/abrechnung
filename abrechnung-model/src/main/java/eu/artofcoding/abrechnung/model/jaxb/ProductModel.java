package eu.artofcoding.abrechnung.model.jaxb;

import com.google.common.collect.Iterables;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "products", namespace = "eu.artofcoding.abrechnung.model.jaxb")
public class ProductModel/*<T extends Product>*/ implements Serializable {

    /*@XmlElements({
            @XmlElement(name = "product", type = Product.class),
            @XmlElement(name = "periodic-product", type = PeriodicProduct.class)
    })*/
    private Set<Product> product;

    public ProductModel() {
    }

    public Set<Product> getProduct() {
        if (null == product) {
            product = new TreeSet<>();
        }
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Set<PeriodicProduct> getPeriodicProducts() {
        Set< PeriodicProduct > periodicProducts = new TreeSet<>();
        Iterable<PeriodicProduct> filter = Iterables.filter(product, PeriodicProduct.class);
        for (PeriodicProduct periodicProduct : filter) {
            periodicProducts.add(periodicProduct);
        }
        return periodicProducts;
    }

}
