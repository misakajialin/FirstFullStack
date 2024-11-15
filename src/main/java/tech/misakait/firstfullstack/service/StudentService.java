package tech.misakait.firstfullstack.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import tech.misakait.firstfullstack.dto.StudentDTO;
import tech.misakait.firstfullstack.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    void addStudent(StudentDTO studentDTO);
    void editStudent(StudentDTO studentDTO) throws Exception;
    void deleteStudent(StudentDTO studentDTO) throws Exception;
    StudentDTO getStudentByJsonWithId(String userJson) throws JsonProcessingException;
    Map<String, List<Object>> queryStudent(String userJson) throws Exception;
}