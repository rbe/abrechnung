package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {"id", "name", "description", "taxRate", "price"})
@XmlSeeAlso({PeriodicProduct.class})
public class Product implements Serializable, Comparable<Product> {

    @XmlAttribute
    private String id;

    private String name;

    private String description;

    private Double taxRate;

    private Double price;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getGrossPrice() {
        return price + ((price * taxRate) / 100);
    }

    @Override
    public String toString() {
        return String.format("%s{id='%s', description='%s', name='%s', taxRate=%s, price=%s}", super.toString(), id, description, name, taxRate, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Product o) {
        return this.equals(o) ? 0 : 1;
    }

}
