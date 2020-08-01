package pl.sda.springdemo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculatorService {
    BigDecimal calculate(String input){
        Pattern pattern = Pattern.compile("^([0-9\\s]+)([+-\\/*])([0-9\\s]+)$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            String all = matcher.group(0);
            String firstNumber = matcher.group(1);
            String sign = matcher.group(2);
            String secondNumber = matcher.group(3);
            Integer number1 = Integer.valueOf(firstNumber);
            Integer number2 = Integer.valueOf(secondNumber);
            BigDecimal result = BigDecimal.valueOf(number1+number2);
            return result;

        }
        return BigDecimal.ZERO;
    }
}
