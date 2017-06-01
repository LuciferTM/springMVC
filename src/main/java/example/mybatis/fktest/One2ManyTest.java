package example.mybatis.fktest;


import example.mapper.ClassMapper;
import example.mapper.StudentMapper;
import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Student;
import example.pojo.mybatis.Class;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class One2ManyTest {
    public static void main(String[] args) throws Exception {
        SqlSession session = TestSqlSessionFactory.getSqlSession();

        One2ManyTest t = new One2ManyTest();

//        t.testSelectClazzById(session);
		t.testSelectStudentById(session);

        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }

    // 测试一对多，查询班级Clazz（一）的时候级联查询学生Student（多）
    public void testSelectClazzById(SqlSession session){
        // 获得ClazzMapper接口的代理对象
        ClassMapper cm = session.getMapper(ClassMapper.class);
        // 调用selectClazzById方法
        Class clazz = cm.selectClassWithId(1);
        // 查看查询到的clazz对象信息
        System.out.println(clazz.getId() + " "+ clazz.getCode());
        // 查看clazz对象关联的学生信息
        List<Student> students = clazz.getStudents();
        for(Student stu : students){
            System.out.println(stu);
        }
    }

    // 测试多对一，查询学生Student（多）的时候级联查询 班级Clazz（一）
    public void testSelectStudentById(SqlSession session){
        // 获得StudentMapper接口的代理对象
        StudentMapper sm = session.getMapper(StudentMapper.class);
        // 调用selectStudentById方法
        Student stu = sm.selectStudentById(1);
        // 查看查询到的Student对象信息
        System.out.println(stu);
        // 查看Student对象关联的班级信息
        System.out.println(stu.getClass());
    }
}
