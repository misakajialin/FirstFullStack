package tech.misakait.firstfullstack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.misakait.firstfullstack.dto.StudentDTO;
import tech.misakait.firstfullstack.service.StudentService;

@RestController
public class AddStudentController {

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private StudentService studentService;

    @PostMapping("/api/add_student")
    public ResponseEntity<String> addStudent(@RequestBody String userJson) throws JsonMappingException, JsonProcessingException {
        StudentDTO studentDTO = mapper.readValue(userJson, StudentDTO.class);
        studentService.addStudent(studentDTO);
        return new ResponseEntity<>(userJson, HttpStatus.CREATED);

    }
}
