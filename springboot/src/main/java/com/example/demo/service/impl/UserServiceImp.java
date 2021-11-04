package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.controller.dto.UserAddressDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<UserAddressDto> countAddress() {
        return userMapper.countAddress();
    }

    @Override
    public Page<User> findPage(Page<User> objectPage, String search) {
        return userMapper.findPage(objectPage,search);
    }
}
