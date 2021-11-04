package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
@ApiModel(value = "Book对象", description = "书籍表")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("出版日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate createTime;

    @ApiModelProperty("封面地址")
    private String cover;

    @ApiModelProperty("用户id")
    private Integer userId;

    @TableField(exist = false)
    private String username;
}
