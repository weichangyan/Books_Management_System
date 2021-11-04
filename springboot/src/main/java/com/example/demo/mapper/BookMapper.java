package com.example.demo.mapper;

import com.example.demo.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
public interface BookMapper extends BaseMapper<Book> {
    // 根据用户id查询图书信息
    List<Book> findByUserId(@Param("userId") Integer userId);
}
