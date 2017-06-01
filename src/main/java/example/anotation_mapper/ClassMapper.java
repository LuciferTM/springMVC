package example.anotation_mapper;


import example.pojo.mybatis.Class;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface ClassMapper {
    @Select("SELECT * FROM TB_CLASS where id = #{id}")
    @Results({
            @Result(id=true, column = "id" , property = "id"),
            @Result(column = "code" , property = "code"),
            @Result(column="id",property="students",
                many=@Many(
                select="example.anotation_mapper.StudentMapper.selectByClassId",
                fetchType= FetchType.LAZY))
    })
    Class selectClassWithId(int id);
}
