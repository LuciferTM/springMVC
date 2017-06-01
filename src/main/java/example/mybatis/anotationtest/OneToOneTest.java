package example.mybatis.anotationtest;

import example.anotation_mapper.CardMapper;
import example.anotation_mapper.PersonMapper;
import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Card;
import example.pojo.mybatis.Person;
import org.apache.ibatis.session.SqlSession;

public class OneToOneTest {
    public static void main(String[] args) throws Exception {
        // 获取Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();
        // 获取PersonMapper实例
        PersonMapper pm = session.getMapper(PersonMapper.class);
        // 根据id查询Person对象，同时需要获得关联的Card对象
        Person p = pm.selectPersonById(1);
        // 查看查询到的Person对象
        System.out.println(p);
        // 查看查询到的关联的Card对象
        System.out.println(p.getCard());

//        CardMapper cm = session.getMapper(CardMapper.class);
//        Card c = cm.selectCardById(1);
//        System.out.println(c.getCode());
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }

}
