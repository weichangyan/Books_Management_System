package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
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
public class BookServiceImp extends ServiceImpl<BookMapper, Book> implements BookService {

}
