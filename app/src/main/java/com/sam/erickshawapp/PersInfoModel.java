package com.sam.erickshawapp;

public class PersInfoModel {
    String Name,FatherName,DateofBirth,Gender,MailId,MobileNo,AdharNo,PanNumber,CurrentAddress,WhatsappNumber,Pincode,Category;

    public PersInfoModel(String name, String fatherName, String dateofBirth, String gender, String mailId, String mobileNo, String adharNo, String panNumber, String currentAddress, String whatsappNumber, String pincode, String category) {
        Name = name;
        FatherName = fatherName;
        DateofBirth = dateofBirth;
        Gender = gender;
        MailId = mailId;
        MobileNo = mobileNo;
        AdharNo = adharNo;
        PanNumber = panNumber;
        CurrentAddress = currentAddress;
        WhatsappNumber = whatsappNumber;
        Pincode = pincode;
        Category = category;
    }

    public PersInfoModel() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMailId() {
        return MailId;
    }

    public void setMailId(String mailId) {
        MailId = mailId;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAdharNo() {
        return AdharNo;
    }

    public void setAdharNo(String adharNo) {
        AdharNo = adharNo;
    }

    public String getPanNumber() {
        return PanNumber;
    }

    public void setPanNumber(String panNumber) {
        PanNumber = panNumber;
    }

    public String getCurrentAddress() {
        return CurrentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        CurrentAddress = currentAddress;
    }

    public String getWhatsappNumber() {
        return WhatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        WhatsappNumber = whatsappNumber;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
