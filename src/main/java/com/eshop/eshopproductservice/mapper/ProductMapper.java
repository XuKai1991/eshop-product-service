package com.eshop.eshopproductservice.mapper;

import com.eshop.eshopproductservice.model.Product;
import org.apache.ibatis.annotations.*;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:15
 * @modified By:
 */
public interface ProductMapper {

    @Insert("insert into product(id, name, category_id, brand_id) values(#{id}, #{name}, #{categoryId}, #{brandId})")
    void add(Product product);

    @Update("update product set name=#{name},category_id=#{categoryId},brand_id=#{brandId} where id=#{id}")
    void update(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(Long id);

    @Select("select * from product where id=#{id}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "brand_id", property = "brandId")
    })
    Product findById(Long id);
}
