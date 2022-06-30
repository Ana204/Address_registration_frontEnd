package br.com.addressregistration.model;

public interface APICallback {

    void onSuccess(Endereco_model enderecoModel);

    //void onSuccess(String logradouro, String complemento, String bairro, String localidade, String uf);
    void onError(String error);
}
