package pojo;

public class RestFullExpBodyPOJO {
 /*
        {
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}
  */

    private int bookingid;
    private RestFullReqBodjPOJO booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public RestFullReqBodjPOJO getBooking() {
        return booking;
    }

    public void setBooking(RestFullReqBodjPOJO booking) {
        this.booking = booking;
    }

    public RestFullExpBodyPOJO(int bookingid, RestFullReqBodjPOJO booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public RestFullExpBodyPOJO() {
    }

    @Override
    public String toString() {
        return "restFullExpBodyPOJO{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
