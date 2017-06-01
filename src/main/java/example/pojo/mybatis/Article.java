package example.pojo.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 CREATE TABLE tb_article(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(18),
 price DOUBLE,
 remark VARCHAR(18)
 );

 INSERT INTO tb_article(NAME,price,remark)
 VALUES('疯狂Java讲义',108.9,'李刚老师经典著作');
 INSERT INTO tb_article(NAME,price,remark)
 VALUES('疯狂Android讲义',99.9,'李刚老师经典著作');
 INSERT INTO tb_article(NAME,price,remark)
 VALUES('疯狂iOS讲义',89.9,'李刚老师经典著作');
 INSERT INTO tb_article(NAME,price,remark)
 VALUES('SpringMVC+MyBatis企业开发',69.9,'肖文吉老师经典著作');

 139.8+108.9=217.8
 */
public class Article implements Serializable {
    private Integer id;		// 商品id，主键
    private String name;	// 商品名称
    private Double price;	// 商品价格
    private String remark;	// 商品描述

    // 商品和订单是多对多的关系，即一种商品可以包含在多个订单中
    private List<Order> orders;

    public Article() {
    }

    public Article(String name, Double price, String remark) {
        this.name = name;
        this.price = price;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                '}';
    }
}
