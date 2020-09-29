package pl.sda.springdemo;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class CalculatorService {

    BiFunction<Integer, Integer, BigDecimal> adder = (a, b) -> BigDecimal.valueOf(a + b);
    BiFunction<Integer, Integer, BigDecimal> subtractor = (a, b) -> BigDecimal.valueOf(a - b);
    BiFunction<Integer, Integer, BigDecimal> multiplier = (a, b) -> BigDecimal.valueOf(a * b);
    BiFunction<Integer, Integer, BigDecimal> divider = (a, b) -> BigDecimal.valueOf(a / b);

    Map<String, BiFunction<Integer, Integer, BigDecimal>> functionMap = populateMap();

    private Map<String, BiFunction<Integer, Integer, BigDecimal>> populateMap() {
        Map<String, BiFunction<Integer, Integer, BigDecimal>> result = new HashMap<>();
        result.put("+", adder);
        result.put("-", subtractor);
        result.put("*", multiplier);
        result.put("/", divider);
        return result;
    }

    BigDecimal calculate(String input) {
        Pattern pattern = Pattern.compile("^([0-9\\s]+)([+-/*])([0-9\\s]+)$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
//            String all = matcher.group(0);
            String firstNumber = matcher.group(1).trim();
            String sign = matcher.group(2);
            String secondNumber = matcher.group(3).trim();
            Integer number1 = Integer.valueOf(firstNumber);
            Integer number2 = Integer.valueOf(secondNumber);
            return functionMap.get(sign).apply(number1, number2);
        }
        return BigDecimal.ZERO;
    }
}
