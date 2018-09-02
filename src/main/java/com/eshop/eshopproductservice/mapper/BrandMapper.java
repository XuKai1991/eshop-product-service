package com.eshop.eshopproductservice.mapper;

import com.eshop.eshopproductservice.model.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 10:48
 * @modified By:
 */
public interface BrandMapper {

    @Insert("insert into brand(name, description) values(#{name}, #{description})")
    @SelectKey(keyColumn = "id", keyProperty = "id", before = false, resultType = java.lang.Long.class, statement = "select last_insert_id()")
    void add(Brand brand);

    @Update("update brand set name=#{name}, description=#{description} where id=#{id}")
    void update(Brand brand);

    @Delete("delete from brand where id=#{id}")
    void delete(Long brand);

    @Select("select * from brand where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description")
    })
    Brand findById(Long id);

    @Select("select * from brand where id in (${ids})")
    List<Brand> findByIds(@Param("ids") String ids);
}
