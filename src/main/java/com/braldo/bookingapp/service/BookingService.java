package com.braldo.bookingapp.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.braldo.bookingapp.model.Booking;

public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingsForDate(String bookingDateString) throws ParseException {
        LocalDate bookingDateToSearch = LocalDate.parse(bookingDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return this.bookings.stream()
                .filter(b -> bookingDateToSearch.equals(b.getBookingDateTime().toLocalDate()))
                .toList();
    }

    public List<Booking> getAllBookings(){
        return this.bookings;
    }

    public boolean isBookingAvailable(Booking booking){
        List<Booking> filteredBookings = this.bookings.stream()
                .filter(b -> isBookingInRange(booking.getBookingDateTime(), b.getBookingDateTime(), b.getBookingDateTime().plusHours(2)))
                .toList();

        return filteredBookings.isEmpty();
    }

    private static boolean isBookingInRange(LocalDateTime bookingTime, LocalDateTime start, LocalDateTime end) {
        return (bookingTime.isEqual(start) || bookingTime.isAfter(start)) &&
                (bookingTime.isBefore(end));
    }
}
