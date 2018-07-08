package com.iwill;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.iwill.controller.UserController;
import com.iwill.service.UserService;
import com.iwill.service.api.IProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@ActiveProfiles("test")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Test
    @DatabaseSetup(value = {"/data/getUserInfo.xls"}, type = DatabaseOperation.CLEAN_INSERT)
    public void test() {
        IProductService productService = Mockito.mock(IProductService.class);
        Mockito.when(productService.getProductName(Mockito.anyLong())).thenReturn("mock");
        ReflectionTestUtils.setField(userService, "productService", productService);

        String result = userController.getUserInfo("1234");
        Assert.assertTrue(result.equals("SUCCESS"));
    }

}
