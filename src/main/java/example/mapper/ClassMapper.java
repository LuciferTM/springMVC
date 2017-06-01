package example.mapper;


import example.pojo.mybatis.Class;

public interface ClassMapper {
    Class selectClassWithId(Integer id);
}
