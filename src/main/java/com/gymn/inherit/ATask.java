package com.gymn.inherit;

import org.springframework.stereotype.Component;

@Component("aTask")
public class ATask implements Task {
        @Override
        public void runTask() {
            System.out.println("hello aTask!");
        }
    }