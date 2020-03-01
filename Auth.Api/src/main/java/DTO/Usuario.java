package DTO;

public class Usuario {

    public Usuario(String senhaUser, String nomeUser) {
        this.nomeUser = nomeUser;
        this.senhaUser = senhaUser;
    }

    public String nomeUser;
    public String sobreUser;
    public String emailUser;
    public int numberPhone;
    public String senhaUser;
    public String dateUser;
    //PF/PJ


    public String getNomeUser() {
        return nomeUser;
    }

    public String getSobreUser() {
        return sobreUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public String getDateUser() {
        return dateUser;
    }

    public Usuario(String nomeUser, String sobreUser, String emailUser, int numberPhone, String senhaUser, String dateUser) {
        this.nomeUser = nomeUser;
        this.sobreUser = sobreUser;
        this.emailUser = emailUser;
        this.numberPhone = numberPhone;
        this.senhaUser = senhaUser;
        this.dateUser = dateUser;
    }
}
