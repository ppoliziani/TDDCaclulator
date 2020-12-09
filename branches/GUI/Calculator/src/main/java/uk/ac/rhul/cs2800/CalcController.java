package uk.ac.rhul.cs2800;


/**
 * Controller for the calculator.
 * 
 * @author Philip
 *
 */
public class CalcController {

  ViewInterface view;

  CalcModel model = new CalcModel();

  /**
   * Handles calculation.
   */
  void calculate() {
    System.out.println("CALC");
    try {
      String expression = view.getExpression();
      float ans = model.evaluate(expression);
      view.setAnswer(ans);
    } catch (InvalidExpressionException | BadTypeException e) {
      e.printStackTrace();
    }
  }

  void reverseType() {
    model.setInfix(false);
  }

  void infixType() {
    model.setInfix(true);
  }

  CalcController(ViewInterface newView) {
    view = newView;
    newView.addCalcObserver(this::calculate);
    newView.addReverseObserver(this::reverseType);
    newView.addInfixObserver(this::infixType);
    newView.menu();
  }

}
