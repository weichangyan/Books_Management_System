package com.example.demo.service.impl;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@Service
public class NewsServiceImp extends ServiceImpl<NewsMapper, News> implements NewsService {

}
