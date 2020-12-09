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

  boolean infix;

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

  CalcController(ViewInterface newView) {
    view = newView;
    newView.addCalcObserver(this::calculate);
    newView.menu();
  }

}
