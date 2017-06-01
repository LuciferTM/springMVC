package example.mybatis.fktest;


import example.mapper.PersonMapper;
import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Person;
import org.apache.ibatis.session.SqlSession;

public class One2OneTest {
    public static void main(String[] args) throws Exception {
        // 获得Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();

		/*Person p
		= session.selectOne("org.fkit.mapper.PersonMapper.selectPersonById",1);
		System.out.println(p);
		System.out.println(p.getCard().getCode());*/
        // 获得mapper接口的代理对象
        PersonMapper pm = session.getMapper(PersonMapper.class);
        // 直接调用接口的方法，查询id为1的Peson数据
        Person p = pm.selectPersonById(1);
        // 打印Peson对象
        System.out.println(p);
        // 打印Person对象关联的Card对象
        System.out.println(p.getCard());

        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }
}
