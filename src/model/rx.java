/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thinuka
 */
public class rx {

    private String invNo;
    private String sName;
    private String sNo;
    private String subject;
    private String value;
    private String total;
    private String barcode;
    private String month;

    public rx(String invNo, String sName, String sNo, String subject, String value, String total, String barcode, String month) {
        this.invNo = invNo;
        this.sName = sName;
        this.sNo = sNo;
        this.subject = subject;
        this.value = value;
        this.total = total;
        this.barcode = barcode;
        this.month = month;
    }

    public String getinvNo() {
        return getInvNo();
    }

    public void setinvNo(String invNo) {
        this.setInvNo(invNo);
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

}
