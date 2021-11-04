package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController{
    @Resource
    CategoryService CategoryService;

    @PostMapping
    public Result<?> save(@RequestBody Category Category) {
        CategoryService.save(Category);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Category Category) {
        CategoryService.updateById(Category);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        CategoryService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Integer id) {
        return Result.success(CategoryService.getById(id));
    }

    /**
     * 分类父子查询
     *
     * @return Result<?>
     */
    @GetMapping
    public Result<?> getAll() {
        // 先查询所有的数据
        List<Category> allCategories = CategoryService.list(null);
        return Result.success(loopQuery(null, allCategories));
    }

    /**
     * 递归查询子集
     *
     * @param pid
     * @param allCategories
     * @return
     */
    private List<Category> loopQuery(Integer pid, List<Category> allCategories) {
        List<Category> categoryList = new ArrayList<>();
        for (Category category : allCategories) {
            if (pid == null) {
                if (category.getPid() == null) {
                    categoryList.add(category);
                    category.setChildren(loopQuery(category.getId(), allCategories));
                }
            } else if (pid.equals(category.getPid())) {
                categoryList.add(category);
                category.setChildren(loopQuery(category.getId(), allCategories));
            }
        }
        return categoryList;
    }
}

