package com.check.datacheck.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 谢森
 * @Description 项目实体
 * @className com.check.datacheck.model.Project
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 10:31 星期二
 */
@Data
public class Project {
    /**
     * id
     */
    private Long id;

    /**
     * 项目名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    /**
     * 项目描述信息
     */
    private String describeMessage;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
