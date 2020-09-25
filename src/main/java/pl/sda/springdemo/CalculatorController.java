package pl.sda.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;
    private OperationService operationService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService, OperationService operationService) {
        this.calculatorService = calculatorService;
        this.operationService = operationService;
    }

    @RequestMapping("/calculator")
    String calculateForm() {
        return "CalculatorForm";
    }

    @RequestMapping("/calculate")
    String calculate(String inputValue, Model model) {
        BigDecimal result = calculatorService.calculate(inputValue);
        model.addAttribute("result", result);
        model.addAttribute("inputValue", inputValue);
        operationService.addOperation(new OperationDTO(inputValue, result));
        return "CalculatorForm";
    }

    @RequestMapping("/list")
    String listOperations(Model model){
        List<OperationDTO> listOperations = operationService.findOperations();
        model.addAttribute("operationsList", listOperations);
        return "ListOperationsForm";
    }




    @ResponseBody // tak oznaczona metoda może zwracać JSONa
    @RequestMapping("/somethingInJson")
    public InputValueWrapper json() {
        return new InputValueWrapper();
    }
}
