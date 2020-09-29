package pl.sda.springdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @MockBean
    private OperationService operationService;


    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/calculator"))
                .andExpect(status().isOk())
                .andExpect(view().name("CalculatorForm"));
    }

    @Test
    public void calculate() throws Exception {
        mockMvc.perform(get("/calculate"))
                .andExpect(status().isOk())
                .andExpect(view().name("CalculatorForm"));
    }

    @Test
    public void  listOperations() throws Exception {
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ListOperationsForm"));
    }

}