package com.iwill.test;

import com.iwill.CustomerApplication;
import com.iwill.controller.UserController;
import com.iwill.util.UnitilsBlockJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

@RunWith(UnitilsBlockJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@ActiveProfiles("test")
@Transactional(value = TransactionMode.ROLLBACK)
public class UserControllerTest {

    @SpringBeanByType
    private UserController userController;

    @Test
    @DataSet(value = {"/data/getUserInfo.xls"})
    public void test() {
        String result = userController.getUserInfo("1234");
        Assert.assertTrue(result.equals("SUCCESS"));
    }

}

