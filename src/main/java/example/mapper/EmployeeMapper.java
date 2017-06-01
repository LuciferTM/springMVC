package example.mapper;


import example.pojo.mybatis.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    Employee selectEmployeeWithId(int id);

    List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeByLoginLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeChoose(HashMap<String, Object> params);

    List<Employee> selectEmployeeLike(HashMap<String, Object> params);

    void updateEmployeeIfNecessary(Employee employee);

    List<Employee> selectEmployeeIn(List<Integer> ids);

    List<Employee> selectEmployeeLikeName(Employee employee);
}
