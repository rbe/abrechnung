package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoice", propOrder = {"id", "customer", "products"})
public class Invoice implements Serializable, Comparable<Invoice> {

    @XmlAttribute
    private String id;

    private Customer customer;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<Product> products;

    public Invoice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        if (null == products) {
            products = new LinkedList<>();
        }
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getNetForTaxRate(Double taxRate) {
        double price = 0.0d;
        for (Product p : products) {
            if (p.getTaxRate().equals(taxRate)) {
                price += p.getPrice();
            }
        }
        return price;
    }

    public double getTaxForTaxRate(Double taxRate) {
        double tax = 0.0d;
        for (Product p : products) {
            if (p.getTaxRate().equals(taxRate)) {
                tax += p.getPrice() * p.getTaxRate();
            }
        }
        return tax / 100;
    }

    public double getTotalGrossPriceForTaxRate(Double taxRate) {
        return getNetForTaxRate(taxRate) + getTaxForTaxRate(taxRate);
    }

    public double getTotalGrossPriceForAllTaxRates() {
        double total = 0.0d;
        for (Product product : this.products) {
            total += product.getGrossPrice();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;

        Invoice invoice = (Invoice) o;

        if (customer != null ? !customer.equals(invoice.customer) : invoice.customer != null) return false;
        if (id != null ? !id.equals(invoice.id) : invoice.id != null) return false;
        if (products != null ? !products.equals(invoice.products) : invoice.products != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Invoice o) {
        return this.equals(o) ? 0 : 1;
    }

}
