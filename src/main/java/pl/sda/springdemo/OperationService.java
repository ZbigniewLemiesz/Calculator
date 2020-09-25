package pl.sda.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationService {
    OperationRepository operationRepository;


    @Autowired
    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void addOperation(OperationDTO operationDTO) {
        operationRepository.save(Operation.createNewFromOperationDTO(operationDTO));
    }

    public List<OperationDTO> findOperations(){
        return operationRepository.findAll().
                stream().
                map(OperationDTO::fromOperation).
                collect(Collectors.toList());
    }

}
