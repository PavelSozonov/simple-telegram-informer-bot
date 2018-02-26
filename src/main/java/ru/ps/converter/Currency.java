package ru.ps.converter;

import com.google.gson.annotations.SerializedName;

/**
 * @author Pavel Sozonov
 * @since 27.02.2018
 */
public class Currency {

    @SerializedName("15m")
    private String m15;

    @SerializedName("last")
    private String last;

    @SerializedName("buy")
    private String buy;

    @SerializedName("sell")
    private String sell;

    @SerializedName("symbol")
    private String symbol;

    public String getM15() {
        return m15;
    }

    public void setM15(String m15) {
        this.m15 = m15;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
