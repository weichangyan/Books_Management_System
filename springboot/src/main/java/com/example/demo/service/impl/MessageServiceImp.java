package com.example.demo.service.impl;

import com.example.demo.entity.Message;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 留言表 服务实现类
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@Service
public class MessageServiceImp extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
