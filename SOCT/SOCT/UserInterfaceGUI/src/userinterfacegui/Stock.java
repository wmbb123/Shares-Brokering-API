/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfacegui;

/**
 *
 * @author William Becker
 */
public class Stock {

    public Stock(String symbol, String name, String currency, double close, String ExName, String ExCurr, double markChange) {
        this.symbol = symbol;
        this.name = name;
        this.currency = currency;
        this.markChange = markChange;
        this.close = close;
        this.ExName = ExName;
        this.ExCurr = ExCurr;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
    
    public String getExName() {
        return ExName;
    }

    public void setExName(String ExName) {
        this.ExName = ExName;
    } 
    
    public String getExCurr() {
        return ExCurr;
    }

    public void setExCurr(String ExCurr) {
        this.ExCurr = ExCurr;
    }    

    public double getmarkChange() {
        return markChange;
    }

    public void setmarkChange(double markChange) {
        this.markChange = markChange;
    }
    
    private String symbol;
    private String name;
    private String currency;
    private double close;
    private String ExName;
    private String ExCurr;
    private double markChange;
}
