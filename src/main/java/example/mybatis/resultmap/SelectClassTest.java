package example.mybatis.resultmap;

import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Class;
import example.pojo.mybatis.Student;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class SelectClassTest {

    public static void main(String[] args) throws Exception {
        // 获得Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();
        // 查询TB_CLAZZ表所有数据返回List集合,集合中的每个元素都是一个Clazz对象
        List<Class> class_list
                = session.selectList("example.mapper.UserMapper.selectClass");
        // 遍历List集合，打印每一个Clazz对象和该Clazz关联的所有Student对象
        for(Class clazz : class_list){
            System.out.println(clazz);
            List<Student> student_list = clazz.getStudents();
            for(Student stu : student_list){
                System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getSex() + " " + stu.getAge());
            }
        }
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }

}
