package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P03_jsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}

     */

    @Test
    public void jsonObje01() {

        JSONObject ilkJsonObje = new JSONObject();
        ilkJsonObje.put("userId", 1);
        ilkJsonObje.put("body", "Merhaba");
        ilkJsonObje.put("title", "Ahmet");


        System.out.println(ilkJsonObje);
        System.out.println();


    }



     /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
     "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates": {
             "checkin":"2018-01-01",      not: içinde baska bir data var
             "checkout":"2019-01-01"
	},
      "totalprice":111,
      "depositpaid":true,
      "lastname":"Brown"
    }
      NOT !! :  Bu gibi iç içe veri bulunduran datalarla çalışırken önce en içerdekinden başlanır
  */

    @Test
    public void jsonObje02(){
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2018-01-01"); // icteki data
        bookingDates.put("checkout","2019-01-01"); // icteki data

        JSONObject outerJson=new JSONObject();
        outerJson.put( "firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",bookingDates);  // icteki datayi aldık  (innerData)
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put( "lastname","Brown");
        System.out.println("Booking Json Objemiz: "+ outerJson);


    }
}

