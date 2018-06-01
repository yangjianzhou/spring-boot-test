package com.iwill;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetUserInfo() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("userId", "12345");
        String body = restTemplate.getForObject("/user/get-user-info?userId={userId}", String.class, params);
        Assert.assertEquals(body, "SUCCESS");
    }

}
