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

import java.util.HashMap;
import java.util.Map;

/**
 * @author misakait
 */
@RestController
public class EditStudentController {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private StudentService studentService;

    @PostMapping("/api/edit_student")
    public ResponseEntity<String> editStudent(@RequestBody String userJson) throws JsonMappingException, JsonProcessingException {
        StudentDTO studentDTO = mapper.readValue(userJson, StudentDTO.class);
        Map<String, Object> response = new HashMap<>();
        try{
            studentService.editStudent(studentDTO);
            return new ResponseEntity<>(userJson, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("success", false);
            String jsonResponse = mapper.writeValueAsString(response);
            return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
        }
    }
}
