package edu.austral.ingsis.math.composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.composite.operaciones.*;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Function function1 = new Valor(1);
    final Function function2 = new Valor(6);
    final Function result = new Suma(function1, function2);
    assertThat(result.solve(null), equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Function function1 = new Valor(12);
    final Function function2 = new Valor(2);
    final Function result = new Division(function1, function2);
    assertThat(result.solve(null), equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Function function1 = new Valor(9);
    final Function function2 = new Valor(2);
    final Function function3 = new Valor(3);
    final Function function4 = new Division(function1, function2);
    final Function result = new Multiplicacion(function4, function3);
    assertThat(result.solve(null), equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Function function1 = new Valor(27);
    final Function function2 = new Valor(6);
    final Function function3 = new Division(function1, function2);
    final Function funcion4 = new Valor(2);
    final Function result = new Potencia(function3, funcion4);
    assertThat(result.solve(null), equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Function function1 = new Valor(36);
    final Function function2 = new Valor(0.5);
    final Function result = new Potencia(function1, function2);
    assertThat(result.solve(null), equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Function function1 = new Valor(136);
    final Function result = new Modulo(function1);
    assertThat(result.solve(null), equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Function function1 = new Valor(-136);
    final Function result = new Modulo(function1);
    assertThat(result.solve(null), equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Function function1 = new Valor(5);
    final Function function3 = new Resta(function1, function1);
    final Function function4 = new Valor(8);
    final Function result = new Multiplicacion(function3, function4);
    assertThat(result.solve(null), equalTo(0d));
  }
}
