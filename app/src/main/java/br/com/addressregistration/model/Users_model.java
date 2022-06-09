package br.com.addressregistration.model;


public class Users_model {

    private Integer Id;
    private String Nome;
    private String Email;
    private String Telefone;
    private String Cep;

    public Users_model(String name, String email, String celular, String cep) {

        validateData(name, email, celular, cep);

        this.Nome = name;
        this.Email = email;
        this.Telefone = celular;
        Cep = cep;
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public void validateData(String name, String email, String celular, String cep){

            if (name.isEmpty()){
                throw new IllegalArgumentException("Preencha o campo nome");
            }
            else if(email.isEmpty()){
                throw new IllegalArgumentException("Preencha o campo email");
            }
            else if (celular.isEmpty()){
                throw new IllegalArgumentException("Preencha o campo celular");
            }
            else if (cep.isEmpty()){
                throw new IllegalArgumentException("Preencha o campo cep");
            }else {
                throw new IllegalArgumentException("Usuario cadastrado com sucesso !");
            }



    }
}
