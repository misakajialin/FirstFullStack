package tech.misakait.firstfullstack.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.misakait.firstfullstack.dto.StudentDTO;
import tech.misakait.firstfullstack.mapper.StudentICDTOMapper;
import tech.misakait.firstfullstack.mapper.StudentMapper;
import tech.misakait.firstfullstack.pojo.Student;
import tech.misakait.firstfullstack.service.StudentService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentICDTOMapper studentICDTOMapper;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = StudentICDTOMapper.INSTANCE.studentDTOToStudent(studentDTO);
        studentMapper.insert(student);
    }

    @Override
    public void editStudent(StudentDTO studentDTO) throws Exception {
        Student student = StudentICDTOMapper.INSTANCE.studentDTOToStudent(studentDTO);
        if (studentMapper.selectById(student.getId()) == null) {
            throw new Exception("Student not found");
        }
        studentMapper.updateById(student);
    }

    @Override
    public void deleteStudent(StudentDTO studentDTO) throws Exception {
        Student student = StudentICDTOMapper.INSTANCE.studentDTOToStudent(studentDTO);
        if (studentMapper.selectById(student.getId()) == null) {
            throw new Exception("Student not found");
        }
        studentMapper.deleteById(student);
    }

    @Override
    public StudentDTO getStudentByJsonWithId(String userJson) throws JsonProcessingException {
        JsonNode root = mapper.readTree(userJson);
        JsonNode idNode = root.path("id");
        int id = idNode.asInt();
        Student student = studentMapper.selectById(id);
        if (student == null) {
            return null;
        }
        return StudentICDTOMapper.INSTANCE.studentToStudentDTO(student);
    }

    @Override
    public Map<String, List<Object>> queryStudent(String userJson) throws JsonProcessingException {
        JsonNode root = mapper.readTree(userJson);
        JsonNode idNode = root.path("id");
        int id = idNode.asInt();
        List<Student> students = studentMapper.findStudentsById(id);

        if (students.isEmpty()) {
            return null;
        }
        //按照id进行升序排行
        students.sort(Comparator.comparingInt(Student::getId));

        Map<String, List<Object>> response = new HashMap<>();
        response.put("id", students.stream().map(Student::getId).collect(Collectors.toList()));
        response.put("name", students.stream().map(Student::getName).collect(Collectors.toList()));
        response.put("age", students.stream().map(Student::getAge).collect(Collectors.toList()));
        return response;
    }
}
