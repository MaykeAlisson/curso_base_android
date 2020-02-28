package br.com.arcom.consumindorest.api;

import br.com.arcom.consumindorest.model.Cep;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CepService {

    @GET("38414356/json/")
    Call<Cep> recuperarCep();

}
