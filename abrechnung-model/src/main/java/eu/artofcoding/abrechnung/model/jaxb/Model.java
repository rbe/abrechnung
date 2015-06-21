package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "abrechnung", namespace = "eu.artofcoding.abrechnung.model.jaxb")
public class Model {

    private transient static final Model INSTANCE = new Model();

    @XmlElement(name = "customers")
    private CustomerModel customerModel;

    @XmlElement(name = "products")
    private ProductModel productModel;

    @XmlElement(name = "invoices")
    private InvoiceModel invoiceModel;

    public Model() {
    }

    public static Model getInstance() {
        return INSTANCE;
    }

    public CustomerModel getCustomerModel() {
        if (null == customerModel) {
            customerModel = new CustomerModel();
        }
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public ProductModel getProductModel() {
        if (null == productModel) {
            productModel = new ProductModel();
        }
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public InvoiceModel getInvoiceModel() {
        if (null == invoiceModel) {
            invoiceModel = new InvoiceModel();
        }
        return invoiceModel;
    }

    public void setInvoiceModel(InvoiceModel invoiceModel) {
        this.invoiceModel = invoiceModel;
    }

}
