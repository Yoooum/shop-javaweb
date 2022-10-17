package com.prprv.shop.util;

import com.alibaba.fastjson2.JSON;
import com.prprv.shop.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @author 未確認の庭師
 */
public class JsonTest {
    @Test
    void testJson() {
        String json = JSON.toJSONString(new User(123, "123@p.p", "123", "123456", true));
        System.out.println(json);
    }
}
