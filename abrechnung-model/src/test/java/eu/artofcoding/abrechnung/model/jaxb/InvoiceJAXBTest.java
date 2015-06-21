package eu.artofcoding.abrechnung.model.jaxb;

import eu.artofcoding.abrechnung.model.JAXBHelper;
import eu.artofcoding.abrechnung.model.JAXBTestHelper;
import eu.artofcoding.abrechnung.model.jaxb.Invoice;
import eu.artofcoding.abrechnung.model.jaxb.InvoiceModel;
import eu.artofcoding.abrechnung.model.jaxb.Model;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceJAXBTest {

    @Test
    public void test1InvoiceSerialize() throws JAXBException, FileNotFoundException {
        InvoiceModel invoiceModel = Model.getInstance().getInvoiceModel();
        invoiceModel.getInvoice().add(JAXBTestHelper.getInvoice());
        JAXBHelper.serialize(invoiceModel, JAXBTestHelper.PATH_INVOICE_MODEL);
    }

    @Test
    public void test2InvoiceDeserialize() throws JAXBException, FileNotFoundException {
        InvoiceModel invoiceModel = JAXBHelper.deserialize(InvoiceModel.class, JAXBTestHelper.PATH_INVOICE_MODEL);
        Iterator<Invoice> iterator = invoiceModel.getInvoice().iterator();
        Invoice invoice = iterator.next();
        assertThat(invoice.getId(), is("INV-1"));
        assertThat(invoice.getNetForTaxRate(7.0), is(10.0));
        assertThat(invoice.getTaxForTaxRate(7.0), is(0.7));
        assertThat(invoice.getNetForTaxRate(19.0), is(200.0));
        assertThat(invoice.getTaxForTaxRate(19.0), is(38.0));
        assertThat(invoice.getTotalGrossPriceForAllTaxRates(), is(248.7));
    }

}
