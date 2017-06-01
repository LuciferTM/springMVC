package example.pojo.mybatis;

import java.io.Serializable;

/**
 CREATE TABLE tb_person(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(18),
 sex VARCHAR(18),
 age INT,
 card_id INT UNIQUE,
 FOREIGN KEY (card_id) REFERENCES tb_card(id)
 );

 INSERT INTO tb_person(name,sex,age,card_id) VALUES('jack','男',23,1)
 */
public class Person implements Serializable{
    private Integer id;  // 主键id
    private String name; // 姓名
    private String sex;  // 性别
    private Integer age; // 年龄
    private Card card;   //id_card

    public Person() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", card=" + card.getCode() +
                '}';
    }
}
