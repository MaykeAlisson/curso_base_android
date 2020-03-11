package br.com.arcom.consumindorest.api;

import br.com.arcom.consumindorest.model.HgFinance;
import retrofit2.Call;

public interface HgFinanceServer {

    Call<HgFinance> recuperarDados();

}
