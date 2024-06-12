package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 分类的启用或禁用
     *
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("分类的启用或禁用")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        categoryService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 添加分类
     *
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("添加分类")
    public Result save(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result delete(Long id) {
        categoryService.delete(id);
        return Result.success();
    }

    /**
     * 更新分类
     *
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("更新分类")
    public Result update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 获取分类类型
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("获取分类类型")
    public Result<List<Category>> list(Integer type) {
        List<Category> categoryList=categoryService.list(type);
        return Result.success(categoryList);
    }


}
