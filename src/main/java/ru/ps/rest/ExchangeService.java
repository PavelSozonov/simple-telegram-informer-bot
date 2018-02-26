package ru.ps.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.ps.converter.Currencies;

/**
 * @author Pavel Sozonov
 * @since 27.02.2018
 */
public interface ExchangeService {
    @GET("ticker")
    Call<Currencies> listCurrency();
}
