package com.example.InterfaceGrafica;

import fachada.Fachada;
import javafx.fxml.FXML;
import modelo.*;

public class TelaPrincipalController {
    private Fachada fachada;
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
