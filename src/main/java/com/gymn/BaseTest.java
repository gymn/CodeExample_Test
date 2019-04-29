package com.gymn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hunan
 * @date 2019/2/20
 * @time 8:43 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring.local/spring-*.xml"})
public class BaseTest {
    @Test
    public void test() {

    }
}
