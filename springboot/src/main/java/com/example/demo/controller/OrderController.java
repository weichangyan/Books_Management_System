package com.example.demo.controller;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{
    @Resource
    OrderService OrderService;

    @Resource
    BookService bookService;

    @PostMapping
    public Result<?> save(@RequestBody Order Order) {
        OrderService.save(Order);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Order Order) {
        OrderService.updateById(Order);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        OrderService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Long id) {
        return Result.success(OrderService.getById(id));
    }

    @GetMapping("/buy/{bookId}")
    public Result<?> buy(@PathVariable Long bookId) {
        Book book = bookService.getById(bookId);
        String orderNo = IdUtil.getSnowflake().nextIdStr();
        String payUrl = "http://localhost:9090/alipay/pay?subject=" + book.getName() + "&traceNo=" + orderNo + "&totalAmount=" + book.getPrice();

        User user = getUser();
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setTotalPrice(book.getPrice());
        order.setPayPrice(book.getPrice());
        order.setTransportPrice(BigDecimal.ZERO);
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setName(book.getName());
        save(order);
        // 新建订单，扣减库存
        return Result.success(payUrl);
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Order::getOrderNo, search);
        }
        Page<Order> OrderPage = OrderService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(OrderPage);
    }
}

