package uk.ac.rhul.cs2800;

/**
 * Methods the view can implement.
 * 
 * @author Philip
 *
 */
public interface ViewInterface {
  
  /**
   * Gets the entered expression.
   * 
   * @return expression
   */
  String getExpression();
  
  /**
   * Displays the answer in the GUI.
   * 
   * @param ans result of expression
   */
  void setAnswer(float ans);
  
  /**
   * Adds observer when calculation is needed.
   * 
   * @param f observer
   */
  void addCalcObserver(Observer f);
  
  /**
   * Adds Type observer when calculator type is changed.
   * 
   * @param f observer
   */
  void addReverseObserver(Observer f);
  
  /**
   * Adds Type observer when calculator type is changed.
   * 
   * @param f observer
   */
  void addInfixObserver(Observer f);
  
  /**
   * Activates buttons.
   */
  void menu();
  
}
