package userinterfacegui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException; 
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author William Becker
 */
public class SharesAPI {
        public static void main(String[] args) {
        // TODO code application logic here
        String wsURL = "http://localhost:8080/Share/webresources/pathTwo";
        String wsURL2 = "http://localhost:8080/CurConvRS/webresources/curCodes";
        
        try {
            //I. setup the URL to call the REST API (web service API)
            String urlString = wsURL;
            String urlString2 = wsURL2;            
            URL url = new URL(urlString);
            URL url2 = new URL(urlString2);            
            //II. Connect to the REST API 
            HttpURLConnection connURL = (HttpURLConnection) url.openConnection();
            HttpURLConnection connURL2 = (HttpURLConnection) url2.openConnection();            
            connURL.setRequestMethod("GET");           
            System.out.println("\nREST API call: " + connURL+ "\n");
            connURL.connect();
            connURL2.setRequestMethod("GET");           
            System.out.println("\nREST API call: " + connURL2+ "\n");
            connURL2.connect();
            //Attach a stream to the REST API connection to retrieve the service response
            BufferedReader ins = new BufferedReader(new InputStreamReader(connURL.getInputStream()));
            BufferedReader ins2 = new BufferedReader(new InputStreamReader(connURL2.getInputStream()));
            String inString;
            String inString2;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();            
            while ((inString = ins.readLine()) != null)  {
               sb.append(inString);
            }
            while ((inString2 = ins2.readLine()) != null)  {
               sb2.append(inString2);
            }
           ins.close();
           connURL.disconnect();
           ins2.close();
           connURL2.disconnect();           
           //call the XMLparse to process the REST API XML response
           System.out.println("\nfrom JSON PARSE\n"+ jsonParse(sb.toString()));

        } 
        catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } 
        catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
    }

    private static String jsonParse(String RESTresponse) throws IOException{
        
        JSONObject json = new JSONObject(RESTresponse);
        final String companyName = "Name";
        final String price = "Price";
        final String code = "Code";

        return json.toString();
    }
}
