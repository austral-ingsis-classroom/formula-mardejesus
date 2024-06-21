package edu.austral.ingsis.math.composite.operaciones;

import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;

public class Division implements Operacion{

    private final Function a;
    private final Function b;

    public Division(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        double aResult = a.solve(variables);
        double bResult = b.solve(variables);
        return aResult / bResult;
    }

    @Override
    public String printValue() {
        return a.printValue() + " / " + b.printValue();
    }

    @Override
    public List<String> getVariables(List<String> list) {
        a.getVariables(list);
        b.getVariables(list);
        return list;
    }
}