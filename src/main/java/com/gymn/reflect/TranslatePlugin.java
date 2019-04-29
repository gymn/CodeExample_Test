package com.gymn.reflect;

import com.google.common.collect.ImmutableMap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author hunan
 * @date 2019/4/29
 * @time 10:37 AM
 */
public class TranslatePlugin implements InvocationHandler {
    public Map<String, String> lagMap = ImmutableMap.of("hello", "你好", "world", "世界");

    private Person person;

    public TranslatePlugin(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.equals(Person.class.getMethod("speak", String.class))) {
            method.invoke(person, args);
            System.out.println(translate(String.valueOf(args[0])));
            return null;
        }
        return method.invoke(person, args);
    }

    private String translate(String content) {
        if (content == null) {
            return null;
        }
        String[] words = content.split("\\s+");
        StringBuilder newContent = new StringBuilder();
        for (String word : words) {
            String newWord = lagMap.get(word);
            if (newWord != null) {
                newContent.append(newWord);
            } else {
                newContent.append(word);
            }
            newContent.append(" ");
        }
        return newContent.toString();
    }
}
