package tech.misakait.firstfullstack.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.misakait.firstfullstack.dto.StudentDTO;
import tech.misakait.firstfullstack.pojo.Student;

@Mapper
public interface StudentICDTOMapper {
    StudentICDTOMapper INSTANCE = Mappers.getMapper(StudentICDTOMapper.class);
    StudentDTO studentToStudentDTO(Student student);
    Student studentDTOToStudent(StudentDTO studentDTO);
}