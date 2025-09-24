package com.quantumwebsystem.libraryapi.Exceptions;

public class RegraNegocio extends RuntimeException {

    private String campo;

    public RegraNegocio(String campo, String message) {
        super(message);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

}
