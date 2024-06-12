package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 分类分页
     * @param categoryPageQueryDTO
     * @return
     */

    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 分类的更新
     * @param category
     */
    void update(Category category);

    /**
     * 新增分类
     * @param category
     */
    void save(Category category);

    /**
     * 删除分类
     * @param id
     */
    @Delete("delete from category where id= #{id} ")
    void delete(Long id);

    /**
     * 获取分类类型
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
