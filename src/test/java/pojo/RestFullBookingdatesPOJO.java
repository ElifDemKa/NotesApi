package pojo;

public class RestFullBookingdatesPOJO {
    /*
    bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        }
     */

    //1-Tüm variable'lar private olarak oluşturulur
    private String checkin;
    private String checkout;

    //2-bu variable'lar için getter ve setter metotları oluşturulur


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //3-Bu vaiable'ları parametre olarak alan parametreli constructor oluşturulur

    public RestFullBookingdatesPOJO(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //4-Parametresiz bir constructor oluşturulur

    public RestFullBookingdatesPOJO() {
    }

    //5-toString metodu uygulanır

    @Override
    public String toString() {
        return "Bookingdates Bilgileri" +"\n"+
                "Checkin Tarihi: " + checkin + '\n' +
                "Checkout Tarihi:" + checkout ;
    }
}