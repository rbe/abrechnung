package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {"id", "firstname", "lastname", "dateOfBirth", "address1", "address2", "zipcode", "city", "country", "periodicProducts"})
public class Customer implements Serializable, Comparable<Customer> {

    @XmlAttribute
    private String id;

    private String firstname;

    private String lastname;

    @XmlElement(name = "date-of-birth")
    private Date dateOfBirth;

    private String address1;

    private String address2;

    private String zipcode;

    private String city;

    private String country;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private Set<PeriodicProduct> periodicProducts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Set<PeriodicProduct> getPeriodicProducts() {
        if (null == periodicProducts) {
            periodicProducts = new TreeSet<>();
        }
        return periodicProducts;
    }

    public void setPeriodicProducts(Set<PeriodicProduct> periodicProducts) {
        this.periodicProducts = periodicProducts;
    }

    @Override
    public String toString() {
        return String.format("%s{id='%s', firstname='%s', lastname='%s', dateOfBirth='%s', zipcode='%s', city='%s', country='%s'}", super.toString(), id, firstname, lastname, dateOfBirth, zipcode, city, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (dateOfBirth != null ? !dateOfBirth.equals(customer.dateOfBirth) : customer.dateOfBirth != null)
            return false;
        if (firstname != null ? !firstname.equals(customer.firstname) : customer.firstname != null) return false;
        if (lastname != null ? !lastname.equals(customer.lastname) : customer.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Customer o) {
        return this.equals(o) ? 0 : 1;
    }

}
