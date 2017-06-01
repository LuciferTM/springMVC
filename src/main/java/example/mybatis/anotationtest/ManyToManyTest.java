package example.mybatis.anotationtest;


import example.anotation_mapper.OrderMapper;
import example.mybatis.util.TestSqlSessionFactory;
import example.pojo.mybatis.Order;
import org.apache.ibatis.session.SqlSession;

public class ManyToManyTest {
    public static void main(String[] args) throws Exception {
        // 获取Session实例
        SqlSession session = TestSqlSessionFactory.getSqlSession();
        // 获取OrderMapper实例
        OrderMapper om = session.getMapper(OrderMapper.class);
        // 根据id查询Order对象
        Order order = om.selectById(1);
        // 查看查询到的Order对象
        System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
        // 查看Order关联的User对象
        System.out.println(order.getUser());
        // 查看关联的Article集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句
        order.getArticles().forEach(article -> System.out.println(article));
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }
}
