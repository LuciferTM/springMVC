package example.mybatis.resultmap;


import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectStudentTest {
    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = TestSqlSessionFactory.getSqlSession();
        List<Student> student_list = sqlSession.selectList("example.mapper.UserMapper.selectStudent");
        for(Student st: student_list){
            System.out.println(st);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
