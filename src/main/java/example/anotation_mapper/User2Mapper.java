package example.anotation_mapper;

import example.pojo.mybatis.User2;
import org.apache.ibatis.annotations.Select;


public interface User2Mapper {
    @Select("SELECT * FROM TB_USER2 WHERE ID = #{id} ")
    User2 selectById(Integer id);
}
