package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Function {
    double solve(Map<String, Double> variables);
    String printValue();
    List<String> getVariables(List<String> list);
}
