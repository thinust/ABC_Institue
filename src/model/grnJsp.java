package model;

public class grnJsp {

    private String GRN;
    private String userType;
    private String pNo;
    private String pName;
    private String qty;
    private String pPrice;
    private String total;
    private String subtotal;

    public grnJsp(String GRN, String userType, String pNo, String pName, String qty, String pPrice, String total, String subtotal) {
        this.GRN = GRN;
        this.userType = userType;
        this.pNo = pNo;
        this.pName = pName;
        this.qty = qty;
        this.pPrice = pPrice;
        this.total = total;
        this.subtotal = subtotal;
    }

    public String getGRN() {
        return GRN;
    }

    public void setGRN(String GRN) {
        this.GRN = GRN;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

}
