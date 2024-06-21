package edu.austral.ingsis.math.composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.composite.operaciones.*;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1.0 + 6.0";
    final Function function1 = new Valor(1);
    final Function function2 = new Valor(6);
    final String result = new Suma(function1, function2).printValue();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12.0 / 2.0";
    final Function function1 = new Valor(12);
    final Function function2 = new Valor(2);
    final String result = new Division(function1, function2).printValue();
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final Function function1 = new Valor(9);
    final Function function2 = new Valor(2);
    final Function function3 = new Valor(3);
    final String expected = "(9.0 / 2.0) * 3.0";
    final String result =
        new Multiplicacion(new Parentesis(new Division(function1, function2)), function3)
            .printValue();
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27.0 / 6.0) ^ 2.0";
    final Function function1 = new Valor(27);
    final Function function2 = new Valor(6);
    final Function function3 = new Valor(2);
    final String result =
        new Potencia(new Parentesis(new Division(function1, function2)), function3).printValue();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8.0";
    final Function function1 = new Valor(8);
    final String result = new Resta(new Modulo(new Variable("value")), function1).printValue();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8.0";
    final Function function1 = new Valor(8);
    final String result = new Resta(new Modulo(new Variable("value")), function1).printValue();
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5.0 - i) * 8.0";
    final Function function1 = new Valor(5);
    final Function function2 = new Variable("i");
    final Function function3 = new Valor(8);
    final String result =
        new Multiplicacion(new Parentesis(new Resta(function1, function2)), function3).printValue();
    assertThat(result, equalTo(expected));
  }
}
