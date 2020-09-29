package pl.sda.springdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService;


    @BeforeEach
    void setCalculatorService() {
        calculatorService = new CalculatorService();
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void shouldReturnsResult(String inputValue, BigDecimal expectedResult) {
        assertEquals(expectedResult, calculatorService.calculate(inputValue));
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of("2  + 2", BigDecimal.valueOf(4)),
                Arguments.of("2222  -2", BigDecimal.valueOf(2220)),
                Arguments.of(" 2  * 3", BigDecimal.valueOf(6)),
                Arguments.of(" 122   / 2 ", BigDecimal.valueOf(61)),
                Arguments.of("12/4", BigDecimal.valueOf(3))

        );
    }


}