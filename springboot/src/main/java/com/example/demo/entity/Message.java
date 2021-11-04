package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 留言表
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Message对象", description = "留言表")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("评论人")
    private String username;

    @ApiModelProperty("评论时间")
    private String time;

    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("关联id")
    private Long foreignId;

    @TableField(exist = false)
    private Message parentMessage;

    @TableField(exist = false)
    private String avatar;


}
