package edu.austral.ingsis.math.composite.operaciones;

import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;

public class Suma implements Operacion {

    Function functionRight;
    Function functionLeft;

    public Suma(Function functionRight, Function functionLeft) {
        this.functionRight = functionRight;
        this.functionLeft = functionLeft;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return functionLeft.solve(variables) + functionRight.solve(variables);
    }

    @Override
    public String printValue() {
        return functionRight.printValue() + " + " + functionLeft.printValue();
    }

    @Override
    public List<String> getVariables(List<String> list) {
        functionRight.getVariables(list);
        functionLeft.getVariables(list);
        return list;
    }
}