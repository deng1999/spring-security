package com.deng;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class FotestApplicationTests {

    @Test
    void contextLoads() {
    }
//$2a$10$XthuYdDmdkljTK7eUxmn2uWo21uO8YzmiuTjx318lQ1uGZ7jMog6O
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("456"));
    }
}
