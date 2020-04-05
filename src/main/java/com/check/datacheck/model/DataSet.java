package com.check.datacheck.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "数据集名称不能为空")
    private String datasetName;

    /**
     * 主题名称
     */
    @NotBlank(message = "主题名称不能为空")
    private String topic;

    /**
     * 分区数
     */
    private Integer partitionNum;

    /**
     * 副本数
     */
    private Integer replicationNum;

    /**
     * json 约束
     */
    @NotBlank(message = "约束条件不能为空")
    private String jsonSchema;

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
