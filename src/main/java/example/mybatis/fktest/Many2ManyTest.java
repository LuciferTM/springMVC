package example.mybatis.fktest;


import example.mapper.OrderMapper;
import example.mapper.User2Mapper;
import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Article;
import example.pojo.mybatis.Order;
import example.pojo.mybatis.User2;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Many2ManyTest {
    public static void main(String[] args) throws Exception {
        SqlSession session = TestSqlSessionFactory.getSqlSession();

        Many2ManyTest t = new Many2ManyTest();

        // 根据用户id查询用户，测试一对多
		t.testSelectUserById(session);
        // 根据订单id查询订单，测试多对多
        //t.testSelectOrderById(session);

        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }

    // 测试一对多，查询User2（一）的时候级联查询订单Order（多）
    public void testSelectUserById(SqlSession session){
        // 获得UserMapper接口的代理对象
        User2Mapper um = session.getMapper(User2Mapper.class);
        // 调用selectUserById方法
        User2 user = um.selectUserById(1);
        // 查看查询到的user对象信息
        System.out.println(user.getId() + " " + user.getUsername());
        // 查看user对象关联的订单信息
        List<Order> orders = user.getOrders();
        for(Order order : orders){
            System.out.println(order);
        }
    }

    // 测试多对多，查询订单Order（多）的时候级联查询订单的商品Article（多）
    public void testSelectOrderById(SqlSession session){
        // 获得OrderMapper接口的代理对象
        OrderMapper om = session.getMapper(OrderMapper.class);
        // 调用selectOrderById方法
        Order order = om.selectOrderById(2);
        // 查看查询到的order对象信息
        System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
        // 查看order对象关联的用户信息
        User2 user = order.getUser();
        System.out.println(user);
        // 查看order对象关联的商品信息
        List<Article> articles = order.getArticles();
        for(Article article : articles){
            System.out.println(article);
        }
    }
}
