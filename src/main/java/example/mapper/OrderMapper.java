package example.mapper;


import example.pojo.mybatis.Order;

public interface OrderMapper {
    Order selectOrderById(int id);
}
