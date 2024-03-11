package model;

public class grnReport {

    private String GRN;
    private String dateTime;
    private String pNo;
    private String pName;
    private String qty;
    private String pPrice;
    private String total;

    public grnReport(String GRN, String dateTime, String pNo, String pName, String qty, String pPrice, String total) {
        this.GRN = GRN;
        this.dateTime = dateTime;
        this.pNo = pNo;
        this.pName = pName;
        this.qty = qty;
        this.pPrice = pPrice;
        this.total = total;
    }

    public String getGRN() {
        return GRN;
    }

    public void setGRN(String GRN) {
        this.GRN = GRN;
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

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
