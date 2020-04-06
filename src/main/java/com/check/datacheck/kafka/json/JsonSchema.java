package com.check.datacheck.kafka.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Iterator;

/**
 * @Description JsonSchema
 * @className com.check.datacheck.kafka.json.JsonSchema
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:29
 */
@Slf4j
public class JsonSchema {
    /**
     * 数据校验
     *
     * @param jsonSchema schema 字符串
     * @param jsonData   json 数据
     * @return boolean
     */
    public static boolean check(String jsonSchema, String jsonData) {
        ProcessingReport report = null;
        try {
            JsonNode data = JsonLoader.fromString(jsonData);
            JsonNode schema = JsonLoader.fromString(jsonSchema);
            report = JsonSchemaFactory.byDefault().getValidator().validateUnchecked(schema, data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (report != null) {
                Iterator<ProcessingMessage> it = report.iterator();
                while (it.hasNext()) {
                    log.error(it.next().toString());
                }
            }

        }
        return report.isSuccess();
    }
}
