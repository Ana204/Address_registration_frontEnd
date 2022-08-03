package br.com.addressregistration.model;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Users_model {

    private static final String TAG = "UsersModel";
    private Integer Id;
    private String Nome;
    private String Email;
    private String Telefone;
    private String NumeroCasa;
    private String Cep;


    public Users_model(String name, String email, String celular, String numeroCasa, String cep) {

        validateData(name, email, celular, numeroCasa, cep);

        this.Nome = name;
        this.Email = email;
        this.Telefone = celular;
        this.NumeroCasa = numeroCasa;
        this.Cep = cep;
    }



    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getNumeroCasa() {
        return NumeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        NumeroCasa = numeroCasa;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    //validação
    public void validateData(String name, String email, String celular, String numeroCasa, String cep){

                if (name.length() < 10)
                    throw new IllegalArgumentException("O campo nome deve conter no mínimo 10 caracteres");

                if(!email.isEmpty())
                    isValidadeEmailAddress(email);
                else
                    throw new IllegalArgumentException("Preencha o campo email");

                if (!celular.isEmpty())
                    isValidadeTelefone(celular);
                else
                    throw new IllegalArgumentException("Preencha o campo celular");

                if (numeroCasa.isEmpty())
                    throw new IllegalArgumentException("Preencha o campo com numero da casa");

                if (!cep.isEmpty())
                    isValidadeCep(cep);
                else
                    throw new IllegalArgumentException("Preencha o campo cep");

                throw new IllegalArgumentException("Usuario cadastrado com sucesso");
    }

    public void  isValidadeEmailAddress(String email){

        boolean isEmailValid = false;

        if (email != null && email.length() > 0){
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches())
                isEmailValid = true;
            else
                throw new IllegalArgumentException("Email invalido");
        }
    }

    public void isValidadeTelefone(String telefone){

        boolean isValidadeTelefone = false;

        if (telefone.length() > 0){
            String expression = "^\\([1-9]{2}\\)9[1-9]{4}\\-[0-9]{4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(telefone);
            if (matcher.matches())
                isValidadeTelefone = true;
            else
                throw new IllegalArgumentException("Telefone invalido");
        }
    }

    public void isValidadeCep(String cep){

        boolean isValidadeCep = false;

        if (cep.length() < 7){
            String expression = "^[0-9]{5}\\-[0-9]{3}$";
            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cep);

            if (matcher.matches())
                isValidadeCep = true;
            else
                throw new IllegalArgumentException("Cep invalido");
        }
    }

}
