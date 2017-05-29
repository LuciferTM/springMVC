package example.mybatis.basetest;

import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.User;
import org.apache.ibatis.session.SqlSession;

public class UpdateTest {

    public static void main(String[] args) throws Exception {
        // 获得Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();
        // 根据id查询User对象
        User user = session.selectOne("example.mapper.UserMapper.selectUser",2);
        // 修改User对象的属性值
        user.setName("tom");
        user.setAge(25);
        // 修改User对象
        session.update("example.mapper.UserMapper.updateUser", user);
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }

}
