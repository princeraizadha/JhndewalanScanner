package com.jhandewalan.scanner.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningBeans {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("devoteeId")
    @Expose
    private String devoteeId;
    @SerializedName("booking_date")
    @Expose
    private String bookingDate;
    @SerializedName("no_of_person")
    @Expose
    private String noOfPerson;
    @SerializedName("senior")
    @Expose
    private String senior;
    @SerializedName("ladies")
    @Expose
    private String ladies;
    @SerializedName("children")
    @Expose
    private String children;
    @SerializedName("inactive")
    @Expose
    private String inactive;
    @SerializedName("cancelled")
    @Expose
    private String cancelled;
    @SerializedName("qrcode")
    @Expose
    private String qrcode;
    @SerializedName("scanned_at")
    @Expose
    private String scannedAt;
    @SerializedName("scanned_by")
    @Expose
    private String scannedBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("slot_id")
    @Expose
    private String slotId;
    @SerializedName("ticket")
    @Expose
    private String ticket;
    @SerializedName("availability_id")
    @Expose
    private String availabilityId;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("batch_no")
    @Expose
    private String batchNo;
    @SerializedName("sevadar_id")
    @Expose
    private String sevadarId;
    @SerializedName("isSevadar")
    @Expose
    private Boolean isSevadar;
    @SerializedName("sevadar_name")
    @Expose
    private String sevadarName;

    public OpeningBeans(String id, String bookingDate, String createdAt, String updatedAt, String batchNo, String sevadarId, Boolean isSevadar, String sevadarName) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.batchNo = batchNo;
        this.sevadarId = sevadarId;
        this.isSevadar = isSevadar;
        this.sevadarName = sevadarName;

    }

    public OpeningBeans(String id, String devoteeId, String bookingDate, String noOfPerson, String senior, String ladies, String children, String inactive, String cancelled, String qrcode, String scannedAt, String scannedBy, String createdAt, String updatedAt, String slotId, String ticket, String availabilityId, String fname, String phone, String email, String name) {
        this.id = id;
        this.devoteeId = devoteeId;
        this.bookingDate = bookingDate;
        this.noOfPerson = noOfPerson;
        this.senior = senior;
        this.ladies = ladies;
        this.children = children;
        this.inactive = inactive;
        this.cancelled = cancelled;
        this.qrcode = qrcode;
        this.scannedAt = scannedAt;
        this.scannedBy = scannedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.slotId = slotId;
        this.ticket = ticket;
        this.availabilityId = availabilityId;
        this.fname = fname;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevoteeId() {
        return devoteeId;
    }

    public void setDevoteeId(String devoteeId) {
        this.devoteeId = devoteeId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(String noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getLadies() {
        return ladies;
    }

    public void setLadies(String ladies) {
        this.ladies = ladies;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getScannedAt() {
        return scannedAt;
    }

    public void setScannedAt(String scannedAt) {
        this.scannedAt = scannedAt;
    }

    public String getScannedBy() {
        return scannedBy;
    }

    public void setScannedBy(String scannedBy) {
        this.scannedBy = scannedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(String availabilityId) {
        this.availabilityId = availabilityId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSevadarId() {
        return sevadarId;
    }

    public void setSevadarId(String sevadarId) {
        this.sevadarId = sevadarId;
    }

    public Boolean getIsSevadar() {
        return isSevadar;
    }

    public void setIsSevadar(Boolean isSevadar) {
        this.isSevadar = isSevadar;
    }
    public String getSevadarName() {
        return sevadarName;
    }

    public void setSevadarName(String sevadarName) {
        this.sevadarName = sevadarName;
    }
}