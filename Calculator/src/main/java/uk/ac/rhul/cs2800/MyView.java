package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Where all the JavaFX magic happens.
 * 
 * @author Philip
 *
 */
public class MyView {

  @FXML
  private Button mainButton;

  @FXML
  private Label newlabel;
  
  @FXML
  private TextField expressionBox;

  @FXML
  private Label experssionTitle;

  @FXML
  private Label resultTitle;

  @FXML
  private Label resultLabel;

  private int toggle = 0;

  /**
   * Changes the contents of the label each time the button is pressed.
   * 
   * @param event when the button is pressed
   */
  @FXML
  void isPressed(ActionEvent event) {
    //newlabel.setText("Label is pressed");
    
    if (toggle == 0) {
      newlabel.setText("Label ON");
      toggle++;
    } else {
      newlabel.setText("Label OFF");
      toggle--;
    }
    
    /*
    String text;
    text = (toggle < 1) ? "Label is now ON" : "Label is now OFF";
    newlabel.setText(text);
    */
  }
  
  @FXML
  void expressionEntered(ActionEvent event) {
    String expres = expressionBox.getText();
    resultLabel.setText(expres);
  }



}
