package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "periodic-product", propOrder = {"interval", "lastChargedDate"})
public class PeriodicProduct extends Product {

    private Interval interval;

    @XmlElement(name = "last-charged-date")
    private Date lastChargedDate;

    public PeriodicProduct() {
    }

    public PeriodicProduct(Product product) {
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Date getLastChargedDate() {
        return lastChargedDate;
    }

    public void setLastChargedDate(Date lastChargedDate) {
        this.lastChargedDate = lastChargedDate;
    }

}
