package com.gymn.reflect;

import com.gymn.BaseTest;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author hunan
 * @date 2019/4/28
 * @time 9:05 PM
 */
public class ProxyTest extends BaseTest {
    @Test
    public void testProxy() {
        Person officer = new Officer("hello");
        ClassLoader cl = Officer.class.getClassLoader();
        Class<?>[] itfs = Officer.class.getInterfaces();
        Person officerProxy = (Person) Proxy.newProxyInstance(cl, itfs, new TranslatePlugin(officer));
        officerProxy.speak("hello world");
    }
}
