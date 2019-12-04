package com.check.datacheck.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.check.datacheck.model.enums.DatasetTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 谢森
 * @Description 数据集实体类
 * @className com.check.datacheck.model.DataSet
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 14:58 星期二
 */
@Data
@TableName("dataset")
public class DataSet {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 数据集类型
     */
    private DatasetTypeEnum type;

    /**
     * 项目 ID
     */
    private Long projectId;

    /**
     * 约束条件
     */
    private String schemaJson;

    /**
     * 分区数
     */
    private Integer partitionNum;

    /**
     * 生命周期
     */
    private Integer lifecycle;

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

    /**
     * 备注
     */
    private String remark;
}
