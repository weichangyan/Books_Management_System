package com.example.demo.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 留言表 前端控制器
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {
    @Resource
    private MessageService messageService;
    @Resource
    private UserService userService;
    @Resource
    HttpServletRequest request;

    @PostMapping
    public Result<?> save(@RequestBody Message Message) {
        Message.setUsername(getUser().getUsername());
        Message.setTime(DateUtil.formatDateTime(new Date()));
        return Result.success(messageService.save(Message));
    }

    @PutMapping
    public Result<?> update(@RequestBody Message Message) {
        return Result.success(messageService.updateById(Message));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        messageService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable Long id) {
        return Result.success(messageService.getById(id));
    }

    @GetMapping
    public Result<?> findAll() {
        return Result.success(messageService.list(null));
    }

    // 查询所有数据
    @GetMapping("/foreign/{foreignId}")
    public Result<?> foreign(@PathVariable Long foreignId) {
        return Result.success(findByForeign(foreignId));
    }

    @GetMapping("/page")
    public Result<?> findPage(@RequestParam(required = false, defaultValue = "") String name,
                              @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<Message> query = Wrappers.<Message>lambdaQuery().like(Message::getContent, name).orderByDesc(Message::getId);
        return Result.success(messageService.page(new Page<>(pageNum, pageSize), query));
    }

    private List<Message> findByForeign(Long foreignId) {
        // 根据 foreignId 0 查询所有的留言数据
        LambdaQueryWrapper<Message> queryWrapper = Wrappers.<Message>lambdaQuery().eq(Message::getForeignId, foreignId).orderByDesc(Message::getId);
        List<Message> list = messageService.list(queryWrapper);
        // 循环所有留言数据
        for (Message Message : list) {
            User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, Message.getUsername()));
            if (StrUtil.isNotBlank(one.getAvatar())) {
                Message.setAvatar(one.getAvatar());
            } else {
                // 默认一个头像
                Message.setAvatar("https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png");
            }
            Long parentId = Message.getParentId();
            // 判断当前的留言是否有父级，如果有，则返回父级留言的信息
            // 原理：遍历所有留言数据，如果id跟当前留言信息的parentId相等，则将其设置为父级评论信息，也就是Message::setParentMessage
            list.stream().filter(c -> c.getId().equals(parentId)).findFirst().ifPresent(Message::setParentMessage);
        }
        return list;
    }
}

