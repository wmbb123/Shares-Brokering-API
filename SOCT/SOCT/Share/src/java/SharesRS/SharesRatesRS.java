/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharesRS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.QueryParam;
import java.util.Calendar;

/**
 * REST Web Service
 *
 * @author William Becker
 */
@Path("pathOne")
public class SharesRatesRS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SharesRatesRS
     */
    public SharesRatesRS() {
    }

    /**
     * Retrieves representation of an instance of SharesRS.SharesRatesRS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getText(@QueryParam("fromCur")String fromCur, 
                           @QueryParam("toCur")String toCur) {
        
        double cRate=0.0;        
        
        try {
            double rate1 = ExRate.valueOf(fromCur).rateInGBP;
            double rate2 = ExRate.valueOf(toCur).rateInGBP;
            cRate = rate1/rate2;
        }
        catch (IllegalArgumentException iae) {
            System.err.println(iae.toString());
        }
        
        String pattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        String now = simpleDateFormat.format(new Date());
        String stampedExRate = cRate + " @ " + now;
        
        return stampedExRate;
    }

    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
    
        
    public enum ExRate {
        AAPL ("Apple Inc", 159.54),
        COKE ("Coca-Cola Consolidated Inc", 465.21),
        MSFT ("Microsoft Corporation", 284.54),
        MCD ("McDonald's Corp", 219.71);

        
        private final double rateInGBP;
        private final String curName;
        ExRate(String curName,double rateInGBP) {
            this.rateInGBP = rateInGBP;
            this.curName = curName;
        }
        double rateInGBP()   { return rateInGBP; }
        String curName()   { return curName; }
    }
}
