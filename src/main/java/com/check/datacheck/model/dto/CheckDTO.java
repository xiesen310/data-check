package com.check.datacheck.model.dto;

import lombok.Data;

/**
 * @author 谢森
 * @Description 校验传输 DTO
 * @className com.check.datacheck.model.dto.CheckDTO
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 10:51 星期五
 */
@Data
public class CheckDTO {
    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 数据集名称
     */
    private String dataSetName;

    /**
     * 数据集 ID (必填字段)
     */
    private Long datasetId;

    /**
     * json 约束条件
     */
    private String jsonSchema;

}
