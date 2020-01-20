package com.senla.cources.web.service;

import static org.junit.Assert.assertEquals;

import com.senla.cources.web.conf.UserServiceTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserServiceTestConfig.class})
public class StudentServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void userServiceVersionTest(){
        assertEquals(userService.getVersion(), Integer.valueOf(5));
    }
}
