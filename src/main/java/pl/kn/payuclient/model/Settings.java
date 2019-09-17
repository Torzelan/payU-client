package pl.kn.payuclient.model;

public class Settings {

    private Boolean invoiceDisabled = false;

    public String getInvoiceDisabled() {
        return invoiceDisabled.toString();
    }

    public void setInvoiceDisabled(Boolean invoiceDisabled) {
        this.invoiceDisabled = invoiceDisabled;
    }
}
