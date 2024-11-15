package tech.misakait.firstfullstack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
public class DeleteStudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/delete_student")
    public ResponseEntity<Map<String, String>> deleteStudent(@RequestBody String userJson) throws JsonMappingException, JsonProcessingException {
        StudentDTO studentDTO = studentService.getStudentByJsonWithId(userJson);
        Map<String, String> response = new HashMap<>();
        try{
            studentService.deleteStudent(studentDTO);
            response.put("message", "Student deleted");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Student not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }
}
