package example.pojo.mybatis;

import java.io.Serializable;

/**
 *
 CREATE TABLE tb_card(
 id INT PRIMARY KEY AUTO_INCREMENT,
 code VARCHAR(18)
 );

 INSERT INTO tb_card(code) VALUES('432801198009191038');
 */
public class Card implements Serializable {

    private Integer id;  // 主键id
    private String code; // 身份证编号

    public Card() {
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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
