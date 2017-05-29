package example.mybatis.basetest;


import example.mybatis.util.TestSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class DeleteTest {
    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = TestSqlSessionFactory.getSqlSession();
        sqlSession.delete("example.mapper.UserMapper.deleteUser", 1);
        sqlSession.commit();
        sqlSession.close();
    }
}
