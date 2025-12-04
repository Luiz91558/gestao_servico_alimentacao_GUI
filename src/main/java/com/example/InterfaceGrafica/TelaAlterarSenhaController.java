package com.example.InterfaceGrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Usuario;
import org.jetbrains.annotations.NotNull;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class TelaAlterarSenhaController {
    @FXML
    private TextField txtNovaSenha;
    private Usuario usuario;

    public void SetUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @FXML
    private void alterarSenha(@NotNull ActionEvent event) {
        usuario.setSenha(txtNovaSenha.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/InterfaceGrafica/TelaPrincipal.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TelaPrincipalController controller = loader.getController();
        controller.setUsuario(usuario);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
