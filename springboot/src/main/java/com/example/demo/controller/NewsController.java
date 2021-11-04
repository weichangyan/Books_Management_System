package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController{
    @Resource
    NewsService newsService;

    @PostMapping
    public Result<?> save(@RequestBody News news) {
        news.setTime(LocalDateTime.now());
        newsService.save(news);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody News news) {
        newsService.updateById(news);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        newsService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Long id) {
        return Result.success(newsService.getById(id));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<News> wrapper = Wrappers.<News>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(News::getTitle, search);
        }
        Page<News> newsPage = newsService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(newsPage);
    }
}

