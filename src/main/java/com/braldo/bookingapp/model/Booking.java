package com.braldo.bookingapp.model;

import java.util.Date;
import java.time.LocalDateTime;

public class Booking {
    private String customerName;
    private int tableSize;
    private LocalDateTime bookingDateTime;

    public Booking(String customerName, int tableSize, LocalDateTime bookingDateTime) {
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.bookingDateTime = bookingDateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTableSize() {
        return tableSize;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }
}
