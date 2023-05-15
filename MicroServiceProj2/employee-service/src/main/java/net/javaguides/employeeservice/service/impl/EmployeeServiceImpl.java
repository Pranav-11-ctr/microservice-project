package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.ApiClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;


    private WebClient webClient;


    //it is constructor injection of open feign client
    //private ApiClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {



//        Employee employee=new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail(),
//                employeeDto.getDepartmentCode());

        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);


//        Employee saveEmployee=employeeRepository.save(employee);
//
//        EmployeeDto savedEmployeeDto =new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
        //return savedEmployeeDto;
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {

        Employee employee=employeeRepository.findById(employeeId).get();

//This is RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity =restTemplate.getForEntity("http://localhost:8081/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//
//        DepartmentDto departmentDto=responseEntity.getBody();

        //Now Using webClient

        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8081/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8085/api/organizations/"+ employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        /*OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8085/api/organizations/"+ employee.getDepartmentCode())
                .retrieve()
                .bodyToMomo(OrganizationDto.class)
                .block();*/


        //Now Using open feign client
      // DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());




//        EmployeeDto employeeDto=new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );

        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }
}
