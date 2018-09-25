
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Assignment #4
 *
 * @author Elias Afzalzada
 */
public class ListGUI extends Application {

    final private String backgroundColor = "89C4C5";
    final private int windowSizeX = 500;
    final private int windowSizeY = 350;
    final private int titleXPos = 220;
    final private int labelXPos = 20;
    final private int labelYPos = 40;
    final private int fieldXPos = 100;
    final private int fieldYPos = 40;
    final private int textAreaXPos = 10;
    final private int textAreaYPos = 250;
    final private int textPrefWidth = 490;
    final private int textPrefHeight = 100;
    final private int choiceBoxXPos = 310;
    final private int choiceBoxYPos = 40;
    final private int choiceBoxPrefWidth = 150;
    final private int choiceBoxPrefHeight = 20;
    final private int buttonXPos = 270;
    final private int buttonYPos = 200;
    final private int buttonGap = 120;
    final private int buttonPrefWidth = 100;
    final private int buttonPrefHeight = 20;
    private AddressList list = new AddressList();

    @Override
    public void start(Stage primaryStage) {

        //Labels, Buttons, and Text I/O setup
        Label title = new Label("Phone Book");
        Label nameL = new Label("Name");
        Label telL = new Label("Telephone");
        Label emailL = new Label("Email");
        Label addressL = new Label("Address");
        Label dobL = new Label("D.O.B.");
        Button enterButton = new Button("Enter");
        Button clearButton = new Button("Clear");
        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "isEmpty", "addToFront", "addToBack", "toString", "reverseToString",
                "reverse", "sizeOf", "phoneNumberByName", "emailByName",
                "nameByPhoneNumber", "dobByName"));
        TextField nameField = new TextField(null);
        TextField telField = new TextField(null);
        TextField emailField = new TextField(null);
        TextField addressField = new TextField(null);
        TextField dobField = new TextField(null);
        TextArea outputTextArea = new TextArea();

        //Label Fonts, Sizing, and Alignment
        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        nameL.setFont(Font.font("Verdana", 14));
        telL.setFont(Font.font("Verdana", 14));
        emailL.setFont(Font.font("Verdana", 14));
        addressL.setFont(Font.font("Verdana", 14));
        dobL.setFont(Font.font("Verdana", 14));
        title.setLayoutX(titleXPos);
        nameL.setLayoutX(labelXPos);
        nameL.setLayoutY(labelYPos);
        telL.setLayoutX(labelXPos);
        telL.setLayoutY(labelYPos * 2);
        emailL.setLayoutX(labelXPos);
        emailL.setLayoutY(labelYPos * 3);
        addressL.setLayoutX(labelXPos);
        addressL.setLayoutY(labelYPos * 4);
        dobL.setLayoutX(labelXPos);
        dobL.setLayoutY(labelYPos * 5);

        //Text Field Sizing/Alignment
        nameField.setLayoutX(fieldXPos);
        nameField.setLayoutY(fieldYPos);
        telField.setLayoutX(fieldXPos);
        telField.setLayoutY(fieldYPos * 2);
        emailField.setLayoutX(fieldXPos);
        emailField.setLayoutY(fieldYPos * 3);
        addressField.setLayoutX(fieldXPos);
        addressField.setLayoutY(fieldYPos * 4);
        dobField.setLayoutX(fieldXPos);
        dobField.setLayoutY(fieldYPos * 5);

        //Text Area Sizing/Alignment
        outputTextArea.setLayoutX(textAreaXPos);
        outputTextArea.setLayoutY(textAreaYPos);
        outputTextArea.setPrefWidth(textPrefWidth);
        outputTextArea.setPrefHeight(textPrefHeight);

        //Button Sizing/Alignment   
        choiceBox.setPrefSize(choiceBoxPrefWidth, choiceBoxPrefHeight);
        clearButton.setPrefSize(buttonPrefWidth, buttonPrefHeight);
        enterButton.setPrefSize(buttonPrefWidth, buttonPrefHeight);
        choiceBox.setLayoutX(choiceBoxXPos);
        choiceBox.setLayoutY(choiceBoxYPos);
        clearButton.setLayoutX(buttonXPos);
        clearButton.setLayoutY(buttonYPos);
        enterButton.setLayoutX(buttonXPos + buttonGap);
        enterButton.setLayoutY(buttonYPos);

        //Pane and Scene setup
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #" + backgroundColor);
        pane.getChildren().addAll(title, nameL, telL, emailL, addressL, dobL,
                nameField, telField, emailField, addressField, dobField,
                clearButton, enterButton, choiceBox, outputTextArea);

        //Frame setup
        primaryStage.setTitle("Assignment 4");
        primaryStage.setScene(new Scene(pane, windowSizeX, windowSizeY));
        primaryStage.setResizable(false);
        primaryStage.show();

        //ClearButton clears Fields
        clearButton.setOnAction((event) -> {
            choiceBox.setValue(null);
            nameField.setText(null);
            telField.setText(null);
            emailField.setText(null);
            addressField.setText(null);
            dobField.setText(null);
            outputTextArea.setText(null);
        });

        //enterButton takes input and executes methods
        enterButton.setOnAction((event) -> {
            String boxVal = (String) choiceBox.getValue();
            if (boxVal != null) {
                switch (boxVal) {
                    case "isEmpty":
                        outputTextArea.setText(String.valueOf(list.isEmpty()));
                        break;
                    case "addToFront":
                        if (nameField.getText() != null
                                && telField.getText() != null
                                && emailField.getText() != null
                                && addressField.getText() != null
                                && dobField.getText() != null) {
                            list.addToFront(nameField.getText(), telField.getText(),
                                    emailField.getText(), addressField.getText(),
                                    dobField.getText());
                            outputTextArea.setText("Added to front");
                            nameField.setText(null);
                            telField.setText(null);
                            emailField.setText(null);
                            addressField.setText(null);
                            dobField.setText(null);
                        }
                        break;
                    case "addToBack":
                        if (nameField.getText() != null
                                && telField.getText() != null
                                && emailField.getText() != null
                                && addressField.getText() != null
                                && dobField.getText() != null) {
                            list.addToBack(nameField.getText(), telField.getText(),
                                    emailField.getText(), addressField.getText(),
                                    dobField.getText());
                            outputTextArea.setText("Added to back");
                            nameField.setText(null);
                            telField.setText(null);
                            emailField.setText(null);
                            addressField.setText(null);
                            dobField.setText(null);
                        }
                        break;
                    case "toString":
                        outputTextArea.setText(list.toString());
                        break;
                    case "reverseToString":
                        outputTextArea.setText(list.reverseToString());
                        break;
                    case "reverse":
                        if (!list.isEmpty()) {
                            list.reverse();
                            outputTextArea.setText("List reversed");
                        }
                        break;
                    case "sizeOf":
                        outputTextArea.setText("Size of list: " + String.valueOf(list.sizeOf()));
                        break;
                    case "phoneNumberByName":
                        outputTextArea.setText(list.phoneNumberByName(nameField.getText()));
                        break;
                    case "emailByName":
                        outputTextArea.setText(list.emailByName(nameField.getText()));
                        break;
                    case "nameByPhoneNumber":
                        outputTextArea.setText(list.nameByPhoneNumber(telField.getText()));
                        break;
                    case "dobByName":
                        outputTextArea.setText(list.dobByName(nameField.getText()));
                        break;
                    default:
                        outputTextArea.setText(String.valueOf(list.isEmpty()));
                        break;
                }
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
