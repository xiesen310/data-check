package com.check.datacheck.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.check.datacheck.model.DataSet;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 谢森
 * @Description 项目展示模型
 * @className com.check.datacheck.model.vo.ProjectVO
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 9:42 星期三
 */
@Data
@ToString
public class ProjectVO {
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

    /**
     * 数据集列表
     */
    private List<DataSet> dataSetList;
}
