package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Where all the JavaFX magic happens.
 * 
 * @author Philip
 *
 */
public class MyView extends Application implements ViewInterface {

  @FXML
  private TextField expressionBox;

  @FXML
  private Label experssionTitle;

  @FXML
  private Label resultTitle;

  @FXML
  private Label resultLabel;

  @FXML
  private RadioButton revButton;

  @FXML
  private RadioButton infixButton;

  @FXML
  private Button calculateButton;
  
  private static volatile MyView instance = null;
  
  @FXML
  void initialize() {
    instance = this;
  }
  
  /**
   * Returns the instance of MyView class.
   * 
   * @return instance of MyView class
   */
  public static synchronized MyView getInstance() {
    if (instance == null) {
      new Thread(() ->  Application.launch(MyView.class)).start();
      while (instance == null) {}
    } 
    return instance;
  }
  
  /**
   * Starts the javafx.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("myView.fxml"));
    Scene scene = new Scene(root, 300, 150);
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();

  }
  
  /**
   * Activates the buttons.
   */
  public void menu() {
    revButton.setDisable(false);
    infixButton.setDisable(false);
    calculateButton.setDisable(false);
  }

  /**
   * Gets expression entered.
   */
  @FXML
  public String getExpression() {
    return expressionBox.getText();
    // answer = cm.evaluate(expression);
  }

  /**
   * Displays the answer.
   */
  public void setAnswer(float ans) {
    resultLabel.setText(String.valueOf(ans));
  }

  /**
   * Adds a calculator observer.
   * 
   * @param f Observer
   */
  public void addCalcObserver(Observer f) {
    calculateButton.setOnAction(event -> f.notifyObservers());
  }
  
  /**
   * Adds a calculator type observer.
   * 
   * @param f Observer
   */
  public void addReverseObserver(Observer f) {
    revButton.setOnAction(event -> f.notifyObservers());
    //revButton.setOnAction(event -> infixButton.setSelected(false));
  }
  
  /**
   * Adds a calculator type observer.
   * 
   * @param f Observer
   */
  public void addInfixObserver(Observer f) {
    infixButton.setOnAction(evetn -> f.notifyObservers());
    //infixButton.setOnAction(event -> revButton.setSelected(false));
  }
  




}
