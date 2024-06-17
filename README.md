## **BookingApp**

The task is to create a simple restaurant booking application in Java and implement the two user stories below.

**User Story 1**: As a customer I want to be able to request a booking at this restaurant.

**User Story 2**: As the restaurant owner I want to be able to see all bookings for a particular day.

Assume each booking has a customer name, table size, date and time. Assume time slots are for 2 hours.

Apart from the mentioned user stories above, an extra functionality is added:

**User Story 3:** As the restaurant owner I want to be able to see all existing bookings.

**Usage:**

***Start***:
Run `BookingApplication.java` main method. This will start the BookingApp in port 1717.

**Available operations**:

***Create new booking:***
**Request type:** POST
**URL**: http://localhost:1717/bookings/create
**Body example JSON**:
   
     {
        	"customerName":"Braldo Montiel",
        	"tableSize":6,
        	"bookingDateTime":"2023-10-01 20:00"
        }
   This operation check first if the requested booking is available, in case it is available, then a new booking is created. In case it is not, a message is returned to user asking to choose another available date/time for the booking.

***Get all bookings:***
**Request type:** GET
**URL**: http://localhost:1717/bookings

This operation returns all the bookings already requested. The response format is JSON

***Get all bookings from a specific date:***
**Request type:** GET
**URL**: http://localhost:1717/bookings/{date}
**Param**: date to get all the bookings in format "yyyy-MM-dd". 
Example: http://localhost:1717/bookings/2024-10-01

This operation returns all the bookings already requested in a specific date. The response format is JSON.

