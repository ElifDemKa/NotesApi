package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JPHDatas {
    public static int basariliStatusCode=200;
    public static String ContenType="application/json; charset=utf-8";
    public static String connectionHeader="keep-alive";


    public static JSONObject expDataOlustur(){
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");



        return expBody;
    }

    public static JSONObject expDataOlusturParametreli(int userId,int id,String title,String body){

        JSONObject expBody=new JSONObject();
        expBody.put("userId",userId);
        expBody.put("id",id);
        expBody.put("title",title);
        expBody.put("body",body);

        return expBody;

    }
    public static JSONObject expDataOlusturScanner(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Gerekli Bilgileri Giriniz!");
        System.out.print("userId: ");
        int userId=scanner.nextInt();
        System.out.print("id: ");
        int id=scanner.nextInt();
        System.out.print("title: ");
        String title=scanner.nextLine();
        System.out.print("body: ");
        String body=scanner.nextLine();


        JSONObject expBody=new JSONObject();
        expBody.put("userId",userId);
        expBody.put("id",id);
        expBody.put("title",title);
        expBody.put("body",body);

        return expBody;

    }


/*
       {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }


 */

    public static JSONObject jSONDataOlustur(){
        JSONObject jSonData=new JSONObject();
        jSonData.put("userId",3);
        jSonData.put("id",22);
        jSonData.put("title","Ahmet");
        jSonData.put("body","Merhaba");

        return jSonData;
    }

    public static JSONObject jSONDataOlusturPli(int userId,int id,String title,String body){
        JSONObject jSonData=new JSONObject();
        jSonData.put("userId",userId);
        jSonData.put("id",id);
        jSonData.put("title",title);
        jSonData.put("body",body);

        return jSonData;
    }

    public static Map<String,Object> MAPDataOlustur(){
        Map<String,Object> reqMAP=new HashMap<>();
        reqMAP.put("userId",10.0);
        reqMAP.put("title","Ahmet");
        reqMAP.put("body","Merhaba");
        reqMAP.put("id",70.0);

        return reqMAP;
    }

    public static Map<String,Object> MapDataOlustur2(String title,String body,double userId,double id){
        Map<String,Object> reqMAP=new HashMap<>();

        reqMAP.put("title",title);
        reqMAP.put("body",body);
        reqMAP.put("userId",userId);
        reqMAP.put("id",id);

        return reqMAP;
    }


}