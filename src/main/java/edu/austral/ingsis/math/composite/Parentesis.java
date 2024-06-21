package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.Function;
import java.util.List;
import java.util.Map;

public class Parentesis implements Function {

  Function a;

  public Parentesis(Function a) {
    this.a = a;
  }

  @Override
  public double solve(Map<String, Double> variables) {
    return a.solve(variables);
  }

  @Override
  public String printValue() {
    return "(" + a.printValue() + ")";
  }

  @Override
  public List<String> getVariables(List<String> list) {
    return a.getVariables(list);
  }
}
