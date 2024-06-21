package edu.austral.ingsis.math.composite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.austral.ingsis.math.composite.operaciones.*;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = new Suma(new Valor(1), new Valor(6)).getVariables(new ArrayList<>());

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result = new Division(new Valor(12), new Variable("div")).getVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result = new Multiplicacion(new Division(new Valor(9), new Variable("x")), new Variable("y")).getVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result = new Potencia(new Division(new Valor(27), new Variable("a")), new Variable("b")).getVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result = new Potencia(new Variable("z"), new Division(new Valor(1), new Valor(2))).getVariables(new ArrayList<>()   );

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result = new Resta(new Variable("value"), new Valor(8)).getVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result = new Multiplicacion(new Resta(new Valor(5), new Variable("i")), new Valor(8)).getVariables(new ArrayList<>());

    assertThat(result, containsInAnyOrder("i"));
  }
}
