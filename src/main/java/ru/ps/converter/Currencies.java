package ru.ps.converter;

import com.google.gson.annotations.SerializedName;

/**
 * @author Pavel Sozonov
 * @since 27.02.2018
 */
public class Currencies {

    @SerializedName("RUB")
    private Currency rub;

    public Currency getRub() {
        return rub;
    }

    public void setRub(Currency rub) {
        this.rub = rub;
    }
}
