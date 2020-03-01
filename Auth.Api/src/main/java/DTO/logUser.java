package DTO;

public class logUser {

    public String nomeLog;
    public String senhaLog;

    public logUser(String nomeLog, String senhaLog) {
        this.nomeLog = nomeLog;
        this.senhaLog = senhaLog;
    }

    public String getNomeLog() {
        return nomeLog;
    }

    public void setNomeLog(String nomeLog) {
        this.nomeLog = nomeLog;
    }

    public String getSenhaLog() {
        return senhaLog;
    }

    public void setSenhaLog(String senhaLog) {
        this.senhaLog = senhaLog;
    }
}
