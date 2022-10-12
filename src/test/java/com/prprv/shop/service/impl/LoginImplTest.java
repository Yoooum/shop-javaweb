package com.prprv.shop.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 未確認の庭師
 */
class LoginImplTest {

    @Test
    void getUserInfo() {
        System.out.println(new LoginImpl().getUserInfo("test@p.p"));
    }
}