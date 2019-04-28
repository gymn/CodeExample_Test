package com.gymn.inet;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author hunan
 * @Date 2018/12/6
 * @Time 7:55 PM
 */
public class Main {
    @Test
    public void getIpv4() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostAddress());
    }
}
