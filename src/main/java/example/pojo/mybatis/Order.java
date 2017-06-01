package example.pojo.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 CREATE TABLE tb_order(
 id INT PRIMARY KEY AUTO_INCREMENT,
 code VARCHAR(32),
 total DOUBLE,
 user_id INT,
 FOREIGN KEY (user_id) REFERENCES tb_user2(id)
 );

 INSERT INTO tb_order(code,total,user_id)
 VALUES('6aa3fa359ff14619b77fab5990940a2d',388.6,1);

 INSERT INTO tb_order(code,total,user_id)
 VALUES('6aa3fa359ff14619b77fab5990940b3c',217.8,1);

 M2M中间表

 CREATE TABLE tb_item(
 order_id INT,
 article_id INT,
 amount INT,
 PRIMARY KEY(order_id,article_id),
 FOREIGN KEY (order_id) REFERENCES tb_order(id),
 FOREIGN KEY (article_id) REFERENCES tb_article(id)
 );

 INSERT INTO tb_item(order_id,article_id,amount)
 VALUES(1,1,1);
 INSERT INTO tb_item(order_id,article_id,amount)
 VALUES(1,2,1);
 INSERT INTO tb_item(order_id,article_id,amount)
 VALUES(1,3,2);

 INSERT INTO tb_item(order_id,article_id,amount)
 VALUES(2,4,2);
 INSERT INTO tb_item(order_id,article_id,amount)
 VALUES(2,1,1);
 */

public class Order implements Serializable {
    private Integer id;  // 订单id，主键
    private String code;  // 订单编号
    private Double total; // 订单总金额

    // 订单和用户是多对一的关系，即一个订单只属于一个用户
    private User2 user;

    // 订单和商品是多对多的关系，即一个订单可以包含多种商品
    private List<Article> articles;

    public Order() {
    }

    public Order(String code, Double total) {
        this.code = code;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User2 getUser() {
        return user;
    }

    public void setUser(User2 user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
