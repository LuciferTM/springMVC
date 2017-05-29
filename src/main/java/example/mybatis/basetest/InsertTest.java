package example.mybatis.basetest;


import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.User;
import org.apache.ibatis.session.SqlSession;

public class InsertTest {
    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = TestSqlSessionFactory.getSqlSession();
        User user = new User("mike","男",28);
        sqlSession.insert("example.mapper.UserMapper.saveUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
