package com.prprv.shop.service;

import com.prprv.shop.service.impl.LoginImpl;
import org.junit.jupiter.api.Test;

/**
 * @author 未確認の庭師
 */
class LoginImplTest {

    @Test
    void admin() {
        System.out.println(new LoginImpl().admin("zrk","123456")?"登录成功":"登录失败");
    }


//    void user() {
//        assertTrue(new LoginImpl().user("test@p.jp","test"));
//    }

}