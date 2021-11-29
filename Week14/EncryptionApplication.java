import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Locale;

public class EncryptionApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a gridPane and set its properties
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);

        // Create a FlowPane and set its properties
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setHgap(5);

        // Create buttons and adding to the flowpane
        Button btEncrypt = new Button("Encrypt");
        //flowPane.add(btEncrypt);
        Button btClear = new Button("Clear");
        //flowPane.add(btClear);
        Button btDecrypt = new Button("Decrypt");
        //flowPane.add(btDecrypt);
        //The book's way of adding nodes to a flowpane
        flowPane.getChildren().addAll(btEncrypt, btClear, btDecrypt);

        // Placing the flowpane and nodes in the gridPane
        gridPane.add(new Label("Input Text:"), 0, 0);
        TextArea txtInput = new TextArea();
        gridPane.add(txtInput, 0, 1);
        gridPane.add(flowPane, 0, 2);
        gridPane.add(new Label("Output Text"), 0, 3);
        TextArea txtOutput = new TextArea();
        gridPane.add(txtOutput, 0, 4);

        // Create a scene of the GridPane and place it in the stage
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("CPT 236 Encryption Application"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //create event handlers
        btEncrypt.setOnMouseClicked(e -> {
            String textToEncrypt = txtInput.getText();
            EncryptString encryptedText = new EncryptString(textToEncrypt);
            txtOutput.setText(encryptedText.encryptString());});
        btClear.setOnMouseClicked(e -> {
            txtInput.clear();});
        btDecrypt.setOnMouseClicked(e -> {
            String textToDecrypt = txtInput.getText();
            EncryptString decryptedText = new EncryptString(textToDecrypt);
            txtOutput.setText(decryptedText.decryptString());});
    }

}