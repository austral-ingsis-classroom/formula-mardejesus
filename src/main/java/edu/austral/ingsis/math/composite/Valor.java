package edu.austral.ingsis.math.composite;
import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;

public class Valor implements Function {

    double valor;

    public Valor(double valor){
        this.valor = valor;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return valor;
    }

    @Override
    public String printValue() {
        return Double.toString(valor);
    }

    @Override
    public List<String> getVariables(List<String> list) {
        return list;
    }
}