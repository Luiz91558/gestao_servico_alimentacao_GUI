package com.example.InterfaceGrafica;
import exceptions.LoginOuDicaSenhaIncorretoException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;
import org.jetbrains.annotations.NotNull;
import fachada.Fachada;
import javafx.event.ActionEvent;

import java.io.IOException;

public class TelaRecuperarSenhaController {
    @FXML
    private TextField txtLoginRecSenha;
    @FXML
    private TextField txtDicaSenha;
    @FXML
    public void validarRecuperacaoDeSenha(@NotNull ActionEvent event) throws IOException {
        String login = txtLoginRecSenha.getText();
        String dicaSenha = txtDicaSenha.getText();
        try {
            Usuario usuario = Fachada.getInstace().recuperarSenha(login, dicaSenha);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/InterfaceGrafica/AlterarSenha.fxml"));
            Parent root = loader.load();
            TelaAlterarSenhaController controller = loader.getController();
            controller.SetUsuario(usuario);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (LoginOuDicaSenhaIncorretoException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void voltar(@NotNull ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/InterfaceGrafica/TelaInicial.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
