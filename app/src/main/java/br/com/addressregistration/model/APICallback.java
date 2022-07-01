package br.com.addressregistration.model;

public interface APICallback {

    void onSuccess(Endereco_model enderecoModel);
    void onError(String error);
}
