package example.anotation_mapper;


import example.pojo.mybatis.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Select("SELECT * FROM tb_article WHERE id IN (SELECT article_id FROM tb_item WHERE order_id = #{id} ) ")
    List<Article> selectByOrderId(Integer order_id);
}
