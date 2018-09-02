package com.eshop.eshopproductservice.mapper;

import com.eshop.eshopproductservice.model.ProductProperty;
import org.apache.ibatis.annotations.*;


@Mapper
public interface ProductPropertyMapper {

    @Insert("insert into product_property(name,value,product_id) values(#{name}, #{value}, #{productId})")
    @SelectKey(keyColumn = "id", keyProperty = "id", before = false, resultType = java.lang.Long.class, statement = "select last_insert_id()")
    void add(ProductProperty productProperty);

    @Update("update product_property set name=#{name},value=#{value},product_id=#{productId} where id=#{id}")
     void update(ProductProperty productProperty);

    @Delete("delete from product_property WHERE id=#{id}")
     void delete(Long id);

    @Select("select * from product_property where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "value", property = "value"),
            @Result(column = "product_id", property = "productId")
    })
     ProductProperty findById(Long id);

    @Select("select * from product_property where product_id=#{productId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "value", property = "value"),
            @Result(column = "product_id", property = "productId")
    })
    ProductProperty findByProductId(Long productId);
}
