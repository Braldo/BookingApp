package com.braldo.bookingapp.controller;

import com.braldo.bookingapp.model.Booking;
import com.braldo.bookingapp.service.BookingService;
import com.braldo.bookingapp.util.JsonUtils;
import io.muserver.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class BookingApplication {
    private static final BookingService bookingService = new BookingService();

    public static void main(String[] args) {

        /*try {
            testDates();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }*/

        int port = 1717;

        MuServer server = MuServerBuilder.httpServer()
                .withHttpPort(port)
                .addHandler(Method.POST, "/bookings/create", BookingController::createBookingHandler)
                .addHandler(Method.GET, "/bookings/{date}", BookingController::getBookingsForDateHandler)
                .addHandler(Method.GET, "/bookings", BookingController::getAllBookingsHandler)
                .start();

        System.out.println("Server started at " + server.uri());
    }

    public static void testDates() throws IOException {

        Booking booking =
                new Booking("Matt Prior", 5,
                        LocalDateTime.of(2023, 10, 1, 19, 0));

        String json = JsonUtils.toJson(booking);
        System.out.println("Serialized book: " + json);

        Booking newBooking = JsonUtils.fromJson(json, Booking.class);
        System.out.println("Deserialized book: " + newBooking);

    }

}

