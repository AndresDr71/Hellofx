package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private ListView<String> userListView;
    private ListView<String> chatListView;
    private TextField messageField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat App");

        AnchorPane root = new AnchorPane();

        // Usuarios
        userListView = new ListView<>();
        userListView.setPrefWidth(150);
        userListView.setPrefHeight(300);
        userListView.getItems().addAll("Usuario 1", "Usuario 2", "Usuario 3"); // Agrega usuarios de ejemplo
        AnchorPane.setTopAnchor(userListView, 10.0);
        AnchorPane.setRightAnchor(userListView, 10.0);
        root.getChildren().add(userListView);

        // Area de chat
        chatListView = new ListView<>();
        chatListView.setPrefSize(400, 300);
        AnchorPane.setTopAnchor(chatListView, 10.0);
        AnchorPane.setLeftAnchor(chatListView, 10.0);
        root.getChildren().add(chatListView);

        // Campo de mensaje
        messageField = new TextField();
        messageField.setPromptText("Escribe tu mensaje...");
        messageField.setPrefWidth(400);
        AnchorPane.setBottomAnchor(messageField, 10.0);
        AnchorPane.setLeftAnchor(messageField, 10.0);
        root.getChildren().add(messageField);

        // Botón de enviar
        Button sendButton = new Button("Enviar");
        sendButton.setOnAction(e -> sendMessage());
        AnchorPane.setBottomAnchor(sendButton, 10.0);
        AnchorPane.setRightAnchor(sendButton, 10.0);
        root.getChildren().add(sendButton);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            String selectedUser = userListView.getSelectionModel().getSelectedItem();
            if (selectedUser != null) {
                String chatMessage = "Tú: " + message;
                chatListView.getItems().add(chatMessage);
                messageField.clear();
                
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alerta");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecciona un usuario.");
                alert.showAndWait();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

