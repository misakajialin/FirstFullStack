package tech.misakait.firstfullstack.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.misakait.firstfullstack.pojo.Student;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT * FROM student WHERE id LIKE CONCAT('%', #{id}, '%')")
    List<Student> findStudentsById(int id);

}
