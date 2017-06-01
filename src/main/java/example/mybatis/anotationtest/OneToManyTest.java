package example.mybatis.anotationtest;


import example.anotation_mapper.ClassMapper;
import example.mybatis.util.TestSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import example.pojo.mybatis.Class;
public class OneToManyTest {
    public static void main(String[] args) throws Exception {

        // 获取Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();
        // 获取ClazzMapper实例
        ClassMapper cm = session.getMapper(ClassMapper.class);
        // 根据id查询Clazz对象
        Class clazz = cm.selectClassWithId(1);
        // 查看查询到的Clazz对象
        System.out.println(clazz.getId() + " "+ clazz.getCode());
        // 查看关联的学生集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句
        clazz.getStudents().forEach(student->System.out.println(student));
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }
}
