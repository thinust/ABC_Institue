package model;

public class InvoiceReport {

    private String invoice;
    private String dateTime;
    private String pNo;
    private String pName;
    private String qty;
    private String payment;
    private String balance;

    public InvoiceReport(String invoice, String dateTime, String pNo, String pName, String qty, String payment, String balance) {
        this.invoice = invoice;
        this.dateTime = dateTime;
        this.pNo = pNo;
        this.pName = pName;
        this.qty = qty;
        this.payment = payment;
        this.balance = balance;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

}
