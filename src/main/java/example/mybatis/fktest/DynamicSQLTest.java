package example.mybatis.fktest;

import example.mapper.EmployeeMapper;
import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicSQLTest {
    public static void main(String[] args) throws Exception {

        SqlSession session = TestSqlSessionFactory.getSqlSession();

        DynamicSQLTest t = new DynamicSQLTest();


		//t.testSelectEmployeeByIdLike(session);

		//t.testSelectEmployeeByLoginLike(session);

//		t.testSelectEmployeeChoose(session);


//		t.testSelectEmployeeLike(session);

//		t.testUpdateEmployeeIfNecessary(session);

//		t.testSelectEmployeeIn(session);

      t.testSelectEmployeeLikeName(session);

        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }
    // 测试<select id="selectEmployeeByIdLike" ...>
    public void testSelectEmployeeByIdLike(SqlSession session){
        // 获得EmployeeMapper接口的代理对象
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        // 创建一个HashMap存储参数
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置id属性
        params.put("id", 1);
        // 调用EmployeeMapper接口的selectEmployeeByIdLike方法
        List<Employee> list = em.selectEmployeeByIdLike(params);
        // 查看返回结果
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeByLoginLike(SqlSession session){
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置loginname和password属性
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeByLoginLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeChoose(SqlSession session){
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置id属性
		params.put("id", 2);
		params.put("loginname", "jack");
		params.put("password", "123456");
        List<Employee> list = em.selectEmployeeChoose(params);
        list.forEach(employee -> System.out.println(employee));
    }


    public void testSelectEmployeeLike(SqlSession session){
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置state属性和id属性
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testUpdateEmployeeIfNecessary(SqlSession session){
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        Employee employee = em.selectEmployeeWithId(2);
        // 设置需要修改的属性
        employee.setLoginname("mary");
        employee.setPassword("123");
        employee.setName("玛丽");
        em.updateEmployeeIfNecessary(employee);
    }

    public void testSelectEmployeeIn(SqlSession session){
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        // 创建List集合
        List<Integer> ids = new ArrayList<Integer>();
        // 往List集合中添加两个测试数据
        ids.add(1);
        ids.add(2);
        List<Employee> list = em.selectEmployeeIn(ids);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeLikeName(SqlSession session){
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        // 设置模糊查询的参数
        employee.setName("a");
        List<Employee> list = em.selectEmployeeLikeName(employee);
        list.forEach(result -> System.out.println(result));
    }

}
