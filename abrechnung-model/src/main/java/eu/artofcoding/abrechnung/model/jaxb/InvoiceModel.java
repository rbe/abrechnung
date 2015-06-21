package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "invoices", namespace = "eu.artofcoding.abrechnung.model.jaxb")
public class InvoiceModel implements Serializable {

    private Set<Invoice> invoice;

    public InvoiceModel() {
    }

    public Set<Invoice> getInvoice() {
        if (null == invoice) {
            invoice = new TreeSet<>();
        }
        return invoice;
    }

    public void setInvoice(Set<Invoice> invoice) {
        this.invoice = invoice;
    }

}
