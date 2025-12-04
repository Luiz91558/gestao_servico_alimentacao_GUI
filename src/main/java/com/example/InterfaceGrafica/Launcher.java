package com.example.InterfaceGrafica;

import enums.TipoUsuario;
import exceptions.IDExistenteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import modelo.Fornecedor;
import modelo.Usuario;

import java.util.Objects;
import fachada.Fachada;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o FXML da tela inicial
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/InterfaceGrafica/TelaInicial.fxml")));

        // Cria a cena inicial
        Scene scene = new Scene(root);

        // Configura o Stage (janela principal)
        primaryStage.setTitle("Sistema de Gerenciamento de Estoque");
        primaryStage.setScene(scene);
        primaryStage.show(); // mostra a janela
    }
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstace();
        Fornecedor fornecedor = new Fornecedor("123", "Paulo", "123456789", "(81)985067123", "paulomorais@gmail.com");
        try {
            fachada.adicionarUsuario(new Usuario("123", "Luiz", "Luiz91558", "Estrela", "Sol", TipoUsuario.Administrador));
            fachada.adicionarUsuario(new Usuario("124", "Antonio", "Antonio5674", "Uvas", "videira", TipoUsuario.Gerente));
            fachada.adicionarUsuario(new Usuario("125", "Ana", "Ana1234", "Salvador", "Cristo", TipoUsuario.Colaborador));
            fachada.adicionarFornecedor(fornecedor);
        } catch (IDExistenteException e) {
            System.out.println(e.getMessage());
        }
        launch(args);
    }
}
