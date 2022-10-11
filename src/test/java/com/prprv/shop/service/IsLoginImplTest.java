package com.prprv.shop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 未確認の庭師
 */
class IsLoginImplTest {

    @Test
    void admin() {
        System.out.println(new IsLoginImpl().admin("zrk","123456")?"登录成功":"登录失败");
    }

    @Test
    void user() {
        assertTrue(new IsLoginImpl().user("test@p.jp","test"));
    }

}