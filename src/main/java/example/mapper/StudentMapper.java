package example.mapper;

import example.pojo.mybatis.Student;

public interface StudentMapper {
    // 根据id查询学生信息
    Student selectStudentById(Integer id);

}
