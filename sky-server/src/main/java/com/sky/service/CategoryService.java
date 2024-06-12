package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    /**
     * 分类分页
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 分类的启用或禁用
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 删除id
     * @param id
     */
    void delete(Long id);

    /**
     * 更新分类
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 获取分类类型
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
