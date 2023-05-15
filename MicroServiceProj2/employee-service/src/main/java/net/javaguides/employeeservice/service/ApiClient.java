package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081" ,value = "DEPARTMENT-SERVICE")
public interface ApiClient {

    //Build get department restApi
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);


   // public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode);
//    {
//        DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
//        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
//    }
}
