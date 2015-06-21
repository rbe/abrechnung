package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers", namespace = "eu.artofcoding.abrechnung.model.jaxb")
public class CustomerModel implements Serializable {

    @XmlElement(name = "customer")
    private Set<Customer> customer;

    public CustomerModel() {
    }

    public Set<Customer> getCustomer() {
        if (null == customer) {
            customer = new TreeSet<>();
        }
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

}
