import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EncryptionApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        //create a menu, add it to the main pane -> everything else is stored within the gridpane
        Pane mainPane = new Pane();
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItemLoad = new MenuItem("Load");
        MenuItem menuItemSave = new MenuItem("Save");
        MenuItem menuItemExit = new MenuItem("Exit");
        menuFile.getItems().addAll(menuItemLoad, menuItemSave, menuItemExit);
        menuBar.getChildren().addAll(menuFile);
        mainPane.getChildren().add(menuBar);


        // Create a gridPane and set its properties
        GridPane gridPane = new GridPane();
        //adding it to the main pane (with the menu)
        mainPane.getChildren().add(gridPane);
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
        Button btClear = new Button("Clear");
        TextField txtShift = new TextField();
        txtShift.setMaxWidth(80);
        txtShift.setPromptText("Shift: 1 - 26");
        Button btDecrypt = new Button("Decrypt");
        flowPane.getChildren().addAll(btEncrypt, txtShift, btClear, btDecrypt);

        // Placing the flowpane and nodes in the gridPane
        gridPane.add(new Label("Input Text:"), 0, 0);
        TextArea txtInput = new TextArea();
        txtInput.setPromptText("Input text here");
        gridPane.add(txtInput, 0, 1);
        gridPane.add(flowPane, 0, 2);
        gridPane.add(new Label("Output Text"), 0, 3);
        TextArea txtOutput = new TextArea();
        txtOutput.setPromptText("Output text here");
        txtOutput.setEditable(false); //make it so users can't type into the output box, but can copy it
        gridPane.add(txtOutput, 0, 4);

        // Create a scene of the GridPane and place it in the stage
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("CPT 236 Encryption Application"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //create event handlers
        //TODO: save and load the shift value in addition to the input
        menuItemLoad.setOnMouseClicked(e -> {
            //do loading file here
            //input method (from example code in chapter 17.4)
            String selectedFile = getSelectedFile();
            if(!selectedFile.isBlank())
            {
                FileInputStream file = new FileInputStream(selectedFile);
                int text;
                while((text = file.read()) != -1)
                {
                    txtInput.setText(txtInput.getText() + text);
                }
                file.close();
            }  
        });
        menuItemSave.setOnMouseClicked(e -> {
            //do saving file here
            String selectedFile = getSelectedFile();
            if(!selectedFile.isBlank())
            {
                FileOutputStream file = new FileOutputStream(selectedFile);
                String text = txtInput.getText();
                file.write(text);
                file.close();
            }
        });
        menuItemExit.setOnMouseClicked(e -> {
            System.exit();
        });

        btEncrypt.setOnMouseClicked(e -> {
            int shift = getShift(txtShift.getText()); //this returns 1 if the text wasn't a number within 1-26
            //get the input text
            String textToEncrypt = txtInput.getText();
            EncryptString encryptedText = new EncryptString(textToEncrypt);
            // This method allows for specific shifts or random shifts if no integer is given
            String output = encryptedText.encryptStringRandom(encryptedText.getString(), shift);
            txtOutput.setText(output);
        });
        btClear.setOnMouseClicked(e -> txtInput.clear());
        btDecrypt.setOnMouseClicked(e -> {
            int shift = getShift(txtShift.getText()); //this returns 1 if the text wasn't a number within 1-26
            String textToDecrypt = txtInput.getText();
            EncryptString decryptedText = new EncryptString(textToDecrypt);
            String output = decryptedText.decryptStringRandom(decryptedText.getString(), shift);
            txtOutput.setText(output);
        });
        btclear.setOnMouseClicked(new )
    }
    private boolean checkIfValid(String shiftText)
    {
        boolean isValid = false;
        try{
            int shiftValue = Integer.parseInt(shiftText);
            if(shiftValue > 0 && shiftValue <= 26)
            {
                isValid = true;
            }
            else{
                displayAlert("RANGE");
            }
        }
        catch(NumberFormatException e){
            isValid = false;
            //make sure the shift isn't the default blank value
            if(!(shiftText.isBlank())) {
                displayAlert("LETTER");
            }
        }
        return isValid;
    }

    private void displayAlert(String value) {
        //create alert and explain the problem
        Alert alert = new Alert(Alert.AlertType.WARNING);
        switch(value)
        {
            case "RANGE":
                alert.setTitle("Check Shift Value");
                alert.setHeaderText("Shift Not Within 1 - 26");
                alert.setContentText("Verify that the shift value is a number greater than zero and less than 27.");
                alert.showAndWait();
                break;
            case "LETTER":
                alert.setTitle("Check Shift Value");
                alert.setHeaderText("Shift Is Not a Number");
                alert.setContentText("Your shift is not a number. Verify that the shift value is a number greater than zero and less than 27.");
                alert.showAndWait();
                break;
            case "FILE":
                alert.setTitle("Check File Selected");
                alert.setHeaderText("File Not Selected Properly");
                alert.setContentText("File selection instructions.");//TODO: add file instructions
                alert.showAndWait();
                break;
            default:
                alert.setTitle("Check Shift Value");
                alert.setHeaderText("Shift Not Within 1 - 26");
                alert.setContentText("Verify that the shift value is a number greater than zero and less than 27.");
                alert.showAndWait();
                break;
        } 
    }


    private int getShift(String shiftText)  //always calls checkIfValid
    {
        int shift = 1;
        if(checkIfValid(shiftText))
        {
            try{
                shift = Integer.parseInt(shiftText);
            }
            catch(NumberFormatException e){

            }
        }
        return shift;
    }

    private String getSelectedFile()
    {
        //https://stackoverflow.com/questions/40255039/how-to-choose-file-in-java/40255184
        String selectedFile = "";
        try
        {
            JFileChooser file = new JFileChooser();
            FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(
                "Text Files Only", "txt");
            chooser.setFileFilter(txtFilter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile().getAbsolutePath());
            }
        }
        catch(Exception e)
        {
            displayAlert("FILE");
        }
        return selectedFile;
    }
}