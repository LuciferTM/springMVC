package example.mybatis.basetest;

import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.User;
import org.apache.ibatis.session.SqlSession;

public class SelectTest {

    public static void main(String[] args) throws Exception {
        // 获得Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();
        // 根据id查询User对象
        User user = session.selectOne("example.mapper.UserMapper.selectUser",2);
        System.out.println(user);
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }

}