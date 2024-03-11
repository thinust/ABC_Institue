package model;

public class invoiceJsp {

    private String bNo;
    private String bName;
    private String value;
    private String invNo;
    private String total;
    private String uName;
    private String barcode;
    private String qty;
    private String subTotal;
    private String payment;
    private String balance;
    private String noItems;

    public invoiceJsp(String bNo, String bName, String value, String invNo, String total, String uName, String barcode, String qty, String subTotal, String payment, String balance, String noItems) {
        this.bNo = bNo;
        this.bName = bName;
        this.value = value;
        this.invNo = invNo;
        this.total = total;
        this.uName = uName;
        this.barcode = barcode;
        this.qty = qty;
        this.subTotal = subTotal;
        this.payment = payment;
        this.balance = balance;
        this.noItems = noItems;
    }

    public String getbNo() {
        return bNo;
    }

    public void setbNo(String bNo) {
        this.bNo = bNo;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
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

    public String getNoItems() {
        return noItems;
    }

    public void setNoItems(String noItems) {
        this.noItems = noItems;
    }
    
    

}
