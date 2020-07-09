package com.deng;

import com.deng.entity.ForForest;
import com.deng.entity.ForUser;
import com.deng.mapper.ForestMapper;
import com.deng.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class FotestApplicationTests {
@Autowired
    UserMapper userMapper;
@Autowired
    ForestMapper forestMapper;
    @Test
    void contextLoads() {
    }
//$2a$10$XthuYdDmdkljTK7eUxmn2uWo21uO8YzmiuTjx318lQ1uGZ7jMog6O
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("456"));
    }

    @Test
    public void  test(){
        Integer i=1;
        ForUser userByUid = userMapper.getUserByUid(1);
        System.out.println(userByUid.getUsername());
    }
    @Test
    public void test2(){
        Integer i=12;
        ForForest forest = forestMapper.getForest(i);
        System.out.println("测试结果："+forest.getForestName()+forest.getForestArea());
    }
}
