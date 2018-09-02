package com.eshop.eshopproductservice.mapper;

import com.eshop.eshopproductservice.model.Category;
import org.apache.ibatis.annotations.*;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:06
 * @modified By:
 */
public interface CategoryMapper {

    @Insert("insert into category(name,description) values(#{name}, #{description})")
    @SelectKey(keyColumn = "id", keyProperty = "id", before = false, resultType = java.lang.Long.class, statement = "select last_insert_id()")
    void add(Category category);

    @Update("update category set name=#{name},description=#{description} where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{id}")
    void delete(Long id);

    @Select("select * from category where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description")
    })
    Category findById(Long id);
}
