package ru.ps.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ps.rest.ExchangeService;

import java.io.IOException;

/**
 * @author Pavel Sozonov
 * @since 27.02.2018
 */
public class Converter {

    private static final Logger log = LoggerFactory.getLogger(Converter.class);

    public static Double btcToRub(double btc) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://blockchain.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ExchangeService service = retrofit.create(ExchangeService.class);
        Call<Currencies> currencies = service.listCurrency();

        Double result = null;
        try {
            Response<Currencies> response = currencies.execute();
            if (response.body() != null && response.body().getRub() != null) {
                result = Double.parseDouble(response.body().getRub().getLast()) * btc;
            }
        } catch (IOException e) {
            log.error("Currency request error, null will be returned", e);
        }
        return result;
    }
}
