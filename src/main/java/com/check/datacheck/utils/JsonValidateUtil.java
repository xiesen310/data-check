package com.check.datacheck.utils;

import com.check.datacheck.constants.Constant;
import com.check.datacheck.model.dto.RespDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author 谢森
 * @Description json 校验工具
 * @className com.check.datacheck.utils.JsonSchemaUtil
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 15:34 星期五
 */
public class JsonValidateUtil {
    private static final JsonValidator VALIDATOR = JsonSchemaFactory.byDefault().getValidator();
    private static final Logger logger = LoggerFactory.getLogger(JsonValidateUtil.class);

    public static RespDto validate(String jsonSchema, String jsonInstance) {
        ProcessingReport report = null;
        try {
            JsonNode schemaNode = JsonLoader.fromString(jsonSchema);
            JsonNode instanceNode = JsonLoader.fromString(jsonInstance);
            report = VALIDATOR.validate(schemaNode, instanceNode);
        } catch (Exception e) {
            logger.error("json validate fail", e);
        }
        if (report.isSuccess()) {
            return RespHelper.ok(Constant.SUCCESS_STATUS_STR, report.toString());
        } else {
            return RespHelper.fail(Constant.JSON_VALIDATE_FAIL, jsonInstance, report.toString());
        }

    }
}
