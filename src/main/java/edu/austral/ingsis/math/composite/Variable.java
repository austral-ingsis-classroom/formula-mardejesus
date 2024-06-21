package edu.austral.ingsis.math.composite;
import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;

public class Variable implements Function {

    private final String nombre;

    public Variable(String nombre){
        this.nombre = nombre;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return variables.get(nombre);
    }

    @Override
    public String printValue() {
        return nombre;
    }
    @Override
    public List<String> getVariables(List<String> list) {
        list.add(nombre);
        return list;    }

}