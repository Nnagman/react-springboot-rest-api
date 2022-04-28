package com.example.gccoffee.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            var email = new Email("acccc");
        });
    }

    @Test
    void testValidEmail() {
        var email = new Email("nnagman@kakao.com");
        assertEquals("nnagman@kakao.com", email.getAddress());
    }

    @Test
    void testEqEmail() {
        var email = new Email("nnagman@kakao.com");
        var email2 = new Email("nnagman@kakao.com");
        assertEquals(email, email2);
    }
}