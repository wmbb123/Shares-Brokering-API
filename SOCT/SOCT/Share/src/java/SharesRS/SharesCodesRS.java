/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharesRS;

import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;
import java.util.Date;
import java.io.File;  
import java.io.FileWriter;  


/**
 * REST Web Service
 *
 * @author William Becker
 */
@Path("pathTwo")
public class SharesCodesRS {
    public static FileWriter sharesFile;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SharesCodesRS
     */
    public SharesCodesRS() {
    }

    /**
     * Retrieves representation of an instance of SharesRS.SharesCodesRS
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces("application/json")
    public String getJson() throws IOException {

        JSONArray share = new JSONArray();

        Date currentTime = Calendar.getInstance().getTime();
       
        for (ExRate exr : ExRate.values()) {
            JSONObject job = new JSONObject();
            job.put("name", exr.curName());
            job.put("code", exr.name());
            job.put("rate", exr.rateInGBP());            
            job.put("amount", exr.sharesamount());

            share.put(job);
        }

        JSONObject rootJobj = new JSONObject();
        
        rootJobj.put("sharesMain", share);
        
        FileWriter sharesFile = new FileWriter("F:\\SOCT\\data.txt");
        try
        {
           sharesFile.write(rootJobj.toString());
           System.err.println("\nJSON object" + rootJobj);
        }
        catch (IOException IO){
            IO.printStackTrace();
        }
        finally{
            sharesFile.flush();
            sharesFile.close();       
           return rootJobj.toString();
        }
    }

    /**
     * PUT method for updating or creating an instance of SharesCodesRS
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    public enum ExRate {
        AAPL ("Apple Inc", 159.54, 1000),
        DELL ("Dell Technologies Inc", 50.74, 1000),
        MCD ("McDonald's Corp", 219.71, 1000),
        COKE ("Coca-Cola Consolidated Inc", 465.21, 1000),
        MSFT ("Microsoft Corporation", 284.54, 1000),       
        AMZN ("Amazon.com, Inc.", 3144.78, 1000),
        GOOGL ("Alphabet Inc.", 2676.78, 1000),
        TSCO ("Tractor Supply Company", 277.40, 1000);
        
        private final double rateInGBP;
        private final int sharesamount;
        private final String curName;
        ExRate(String curName,double rateInGBP, int sharesamount) {
            this.rateInGBP = rateInGBP;
            this.curName = curName;
            this.sharesamount = sharesamount;
            
        }
        double rateInGBP()   { return rateInGBP; }
        String curName()   { return curName; }
        int sharesamount()   { return sharesamount; }
    }
    
}