package com.example.demo.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.controller.dto.UserAddressDto;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
public interface UserMapper extends BaseMapper<User> {
    // 一对多查询
    Page<User> findPage(Page<User> page, @Param("nickName") String nickName);

    @Select("select count(id) count, address from user GROUP BY address")
    List<UserAddressDto> countAddress();
}
