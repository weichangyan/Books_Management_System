package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_order")
@ApiModel(value = "Order对象", description = "订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("总价")
    private BigDecimal totalPrice;

    @ApiModelProperty("实付款")
    private BigDecimal payPrice;

    @ApiModelProperty("优惠金额")
    private BigDecimal discount;

    @ApiModelProperty("运费")
    private BigDecimal transportPrice;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户账户")
    private String username;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime payTime;

    @ApiModelProperty("状态")
    private Integer state;


}
