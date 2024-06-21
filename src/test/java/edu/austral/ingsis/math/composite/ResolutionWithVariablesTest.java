package edu.austral.ingsis.math.composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.composite.operaciones.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Function function1 = new Valor(1);
    final Function function2 = new Variable("x");
    final double result = new Suma(function1, function2).solve(new HashMap<>(Collections.singletonMap("x", 3.0)));
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Function function1 = new Valor(12);
    final Function function2 = new Variable("div");
    final Double result = new Division(function1, function2).solve(new HashMap<>(Collections.singletonMap("div", 4.0)));
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Function function1 = new Valor(9);
    final Function function2 = new Variable("x");
    final Function function3 = new Variable("y");
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    variables.put("y", 4.0);
    final Double result = new Multiplicacion(new Division(function1, function2), function3).solve(variables);
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Function function1 = new Valor(27);
    final Function function2 = new Variable("a");
    final Function function3 = new Variable("b");
    Map<String, Double> variables = new HashMap<>();
    variables.put("a", 9.0);
    variables.put ("b", 3.0);
    final Function result1 = new Division(function1, function2);
    final Double result = new Potencia(result1, function3).solve(variables);
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Function function1 = new Variable("z");
    final Function function2 = new Valor(1.0 / 2.0);
    Map<String, Double> variables = new HashMap<>();
    variables.put("z", 36.0);
    final Double result = new Potencia(function1, function2).solve(variables);
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Function function1 = new Variable("value");
    final Function function2 = new Valor(8.0);
    final double result = new Resta(new Modulo(function1), function2).solve(new HashMap<>(Collections.singletonMap("value", 8.0)));
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Function function1 = new Variable("value");
    final Function function2 = new Valor(8.0);
    final double result = new Resta(new Modulo(function1), function2).solve(new HashMap<>(Collections.singletonMap("value", 8.0)));
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Function function1 = new Valor(5);
    final Function function2 = new Variable("i");
    final Function function3 = new Valor(8);
    final double result = new Multiplicacion(new Resta(function1, function2), function3).solve(new HashMap<>(Collections.singletonMap("i", 2.0)));
    assertThat(result, equalTo(24d));
  }
}
