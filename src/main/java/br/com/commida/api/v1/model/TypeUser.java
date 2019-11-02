package br.com.commida.api.v1.model;

public enum TypeUser {
    FACILITADOR("Facilitador"),
    PROFISSIONAL("Profissional");

    private String codigo;

    TypeUser(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
