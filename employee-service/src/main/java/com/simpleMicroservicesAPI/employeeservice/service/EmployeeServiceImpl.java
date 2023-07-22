package com.simpleMicroservicesAPI.employeeservice.service;

import com.simpleMicroservicesAPI.employeeservice.Exception.EmailAlreadyExistsException;
import com.simpleMicroservicesAPI.employeeservice.Mapper.AutoEmployeeMapper;
import com.simpleMicroservicesAPI.employeeservice.Repository.EmployeeRepository;
import com.simpleMicroservicesAPI.employeeservice.dto.ApiResponseDTO;
import com.simpleMicroservicesAPI.employeeservice.dto.DepartmentDTO;
import com.simpleMicroservicesAPI.employeeservice.dto.EmployeeDTO;
import com.simpleMicroservicesAPI.employeeservice.dto.OrganizationDTO;
import com.simpleMicroservicesAPI.employeeservice.entity.Employee;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,WebClient webClient) {
        this.employeeRepository = employeeRepository;
        this.webClient = webClient;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee savedEmployee = new Employee(
            employeeDTO.getId(),
            employeeDTO.getFirstName(),
            employeeDTO.getLastName(),
            employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode(),
                employeeDTO.getOrganizationCode()
        );
        Optional<Employee> checkEmail = Optional.ofNullable(employeeRepository.findByEmail(employeeDTO.getEmail()));
        if(checkEmail.isPresent()) {
            throw new EmailAlreadyExistsException("The User with email : " + employeeDTO.getEmail() + "Already exists");
        }
//        Employee savedEmployee = AutoEmployeeMapper.MAPPER.mapEmployee(employeeDTO);
        System.out.println("EmPP : "+ savedEmployee.getDepartmentCode());
        Employee employee = employeeRepository.save(savedEmployee);
        EmployeeDTO employeeDTO1 = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );
//        System.out.println("Emppppp:  "+ employee.getDepartmentCode());
//        EmployeeDTO employeeDTO1 = AutoEmployeeMapper.MAPPER.mapEmployeeDTO(employee);
        return employeeDTO1;
    }

    @CircuitBreaker(name = "${spring.application.name}" ,fallbackMethod = "getDefaultFallBackMessage")
    @Override
    public ApiResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//          employee.getId(),
//          employee.getFirstName(),
//          employee.getLastName(),
//          employee.getEmail()
//        );
//        ResponseEntity<DepartmentDTO> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/department/code/"+employee.getDepartmentCode(), DepartmentDTO.class);

        DepartmentDTO departmentDTO =  webClient.get()
                .uri("http://localhost:8080/api/department/code/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();
        System.out.println("Emppp Code :" + employee.getOrganizationCode());
        OrganizationDTO organizationDTO =  webClient.get()
                .uri("http://localhost:8989/api/organization/code/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDTO.class)
                .block();
//        DepartmentDTO departmentDTO = responseEntity.getBody();
        EmployeeDTO employeeDTO = AutoEmployeeMapper.MAPPER.mapEmployeeDTO(employee);
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        apiResponseDTO.setOrganizationDTO(organizationDTO);
        return apiResponseDTO;
    }

    public ApiResponseDTO getDefaultFallBackMessage(Long employeeId , Exception e){
        Employee employee = employeeRepository.findById(employeeId).get();
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//          employee.getId(),
//          employee.getFirstName(),
//          employee.getLastName(),
//          employee.getEmail()
//        );
//        ResponseEntity<DepartmentDTO> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/department/code/"+employee.getDepartmentCode(), DepartmentDTO.class);

//        DepartmentDTO departmentDTO =  webClient.get()
//                .uri("http://localhost:8080/api/department/code/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();
//        DepartmentDTO departmentDTO = responseEntity.getBody();
//        EmployeeDTO employeeDTO = AutoEmployeeMapper.MAPPER.mapEmployeeDTO(employee);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentCode("04");
        departmentDTO.setDepartmentName("ECE");
        departmentDTO.setDepartmentDescription("Electronics & Communication enginnering");
        departmentDTO.setId(employeeId);
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
        EmployeeDTO employeeDTO = AutoEmployeeMapper.MAPPER.mapEmployeeDTO(employee);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;
    }
}
