import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

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
        TextArea txtInput = new TextArea("Input text here");
        gridPane.add(txtInput, 0, 1);
        gridPane.add(flowPane, 0, 2);
        gridPane.add(new Label("Output Text"), 0, 3);
        TextArea txtOutput = new TextArea("Output text here");
        txtOutput.setEditable(false); //make it so users can't type into the output box, but can copy it
        gridPane.add(txtOutput, 0, 4);

        // Create a scene of the GridPane and place it in the stage
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("CPT 236 Encryption Application"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //create event handlers
        btEncrypt.setOnMouseClicked(e -> {
            //get the input text
            String textToEncrypt = txtInput.getText();
            //using the static method to encrypt the string so that we don't have to create an object
            String encryptedText = EncryptString.encryptString(textToEncrypt);
            txtOutput.setText(encryptedText);
        });
        btClear.setOnMouseClicked(e -> txtInput.clear());
        btDecrypt.setOnMouseClicked(e -> {
            String textToDecrypt = txtInput.getText();
            //using the static method to decrypt the string so that we don't have to create an object
            String decryptedText = EncryptString.decryptString(textToDecrypt);
            txtOutput.setText(decryptedText);
        });
    }

}