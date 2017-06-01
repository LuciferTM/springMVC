package example.anotation_mapper;


import example.pojo.mybatis.Card;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    @Select("SELECT * FROM TB_CARD WHERE ID = #{id}")
    Card selectCardById(int id);
}

