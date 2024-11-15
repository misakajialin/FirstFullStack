package tech.misakait.firstfullstack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.misakait.firstfullstack.service.StudentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author misakait
 */
@RestController
public class QueryStudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/api/query_student")
    public ResponseEntity<?> queryStudent(@RequestBody String userJson) throws Exception {
        Map<String, List<Object>> students =  studentService.queryStudent(userJson);
        if (students== null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Student not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}