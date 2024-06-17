package com.braldo.bookingapp.controller;

import com.braldo.bookingapp.model.Booking;
import com.braldo.bookingapp.util.JsonUtils;
import io.muserver.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.braldo.bookingapp.service.BookingService;

public class BookingController {
    private static final BookingService bookingService = new BookingService();

    public static void createBookingHandler(MuRequest req, MuResponse res, Map<String, String> params) throws Exception {
        Booking booking = JsonUtils.fromJson(req.readBodyAsString(), Booking.class);
        if(bookingService.isBookingAvailable(booking)) {
            bookingService.addBooking(booking);
            res.status(201);
            res.write("Booking created");
        }
        else{
            res.status(409);
            res.write("The booking time is already occupied, please choose another date/time for your booking");
        }
    }

    public static void getBookingsForDateHandler(MuRequest req, MuResponse res, Map<String, String> params) throws ParseException {
        String date = params.get("date");
        if (date == null) {
            res.status(400);
            res.write("Date query parameter is required");
            return;
        }
        List<Booking> bookings = bookingService.getBookingsForDate(date);
        res.status(200);
        res.contentType("application/json");
        res.write(JsonUtils.toJson(bookings));
    }

    public static void getAllBookingsHandler (MuRequest req, MuResponse res, Map<String, String> params) throws ParseException {
        List<Booking> allBookings = bookingService.getAllBookings();
        res.status(200);
        res.contentType("application/json");
        res.write(JsonUtils.toJson(allBookings));
    }
}
