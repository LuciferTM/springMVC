package example.anotation_mapper;


import example.pojo.mybatis.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface OrderMapper {
    @Select("SELECT * FROM TB_ORDER WHERE ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="code",property="code"),
            @Result(column="total",property="total"),
            @Result(column="user_id",property="user",
                    one=@One(select="example.anotation_mapper.User2Mapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="id",property="articles",
                    many=@Many(select="example.anotation_mapper.ArticleMapper.selectByOrderId",
                            fetchType=FetchType.LAZY))
    })
    Order selectById(Integer id);
}
