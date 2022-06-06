package br.com.addressregistration.model;

public class Users_model {

    private Integer Id;
    private String Nome;
    private String Email;
    private Integer Telefone;
    private Integer Cep;

    public Users_model(String name, String email) {
        this.Nome = name;
        this.Email = email;
//        this.Telefone = celular;
//        Cep = cep;
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

    public Integer getTelefone() {
        return Telefone;
    }

    public void setTelefone(Integer telefone) {
        this.Telefone = telefone;
    }

    public Integer getCep() {
        return Cep;
    }

    public void setCep(Integer cep) {
        Cep = cep;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }
}
