package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P03_jsonDataOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}

     */

    @Test
    public void test03() {

        JSONObject data = new JSONObject();
        data.put("bookingId", 1);
        data.put("body", "Merhaba");
        data.put("title", "Ahmet");


        System.out.println(data);
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
    public void test04(){
        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2018-01-01"); // icteki data
        innerData.put("checkout","2019-01-01"); // icteki data

        JSONObject data=new JSONObject();
        data.put( "firstname","Jim");
        data.put("additionalneeds","Breakfast");
        data.put("bookingdates",innerData);  // icteki datayi aldık  (innerData)
        data.put("totalprice",111);
        data.put("depositpaid",true);
        data.put( "lastname","Brown");
        System.out.println(data);


    }
}

