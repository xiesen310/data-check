package com.check.datacheck.utils;

import com.check.datacheck.model.dto.RespDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description json 数据校验测试
 * @className com.check.datacheck.utils.JsonSchemaUtilTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 14:48 星期五
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonValidateUtilTest {
    private static final JsonValidator VALIDATOR = JsonSchemaFactory.byDefault().getValidator();

    String jsonSchema = "{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"title\":\"Product\",\"description\":\"A product from Acme's catalog\",\"type\":\"object\",\"properties\":{\"id\":{\"description\":\"The unique identifier for a product\",\"type\":\"integer\"},\"name\":{\"description\":\"Name of the product\",\"type\":\"string\"}},\"required\":[\"id\",\"name\"]}";
    String ErrorInstance= "{\"id\":123,\"names\":\"allen\"}";
    String successInstance= "{\"id\":123,\"name\":\"allen\"}";

    @Test
    public void jsonSchema() throws Exception {
        JsonNode mainNode = JsonLoader.fromString(jsonSchema);
        JsonNode instanceNode = JsonLoader.fromString(successInstance);

        ProcessingReport report = VALIDATOR.validate(mainNode, instanceNode);
        if (report.isSuccess()) {
            System.out.println("校验成功");
            System.out.println(report);
        } else {
            System.out.println("校验失败");
            System.out.println(report);
        }
    }

    @Test
    public void validate() {
        RespDto resp = JsonValidateUtil.validate(jsonSchema, successInstance);
        System.out.println("data： "+resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }
}
