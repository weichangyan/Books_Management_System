package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.controller.dto.UserAddressDto;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
public interface UserService extends IService<User> {

    List<UserAddressDto> countAddress();

    Page<User> findPage(Page<User> objectPage, String search);
}
