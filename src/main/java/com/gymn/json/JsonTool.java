package com.gymn.json;

/**
 * @Author hunan
 * @Date 2018/6/26
 * @Time 上午10:57
 */
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.*;

public class JsonTool {
    private static final Logger log = Logger.getLogger(JsonTool.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public JsonTool() {
    }

    public static String writeListValueAsString(Collection<? extends Jsonable> var0) {
        LinkedList var1 = new LinkedList();
        Iterator var2 = var0.iterator();

        while(var2.hasNext()) {
            Jsonable var3 = (Jsonable)var2.next();
            var1.add(var3.getMap4Json());
        }

        return writeValueAsString((Object)var1);
    }

    public static String writeValueAsString(Jsonable var0) {
        return writeValueAsString((Object)var0.getMap4Json());
    }

    public static String writeValueAsString(Object var0) {
        if(var0 instanceof Jsonable) {
            return writeValueAsString((Jsonable)var0);
        } else {
            try {
                return mapper.writeValueAsString(var0);
            } catch (JsonGenerationException var2) {
                throw new IllegalArgumentException(var2);
            } catch (JsonMappingException var3) {
                throw new IllegalArgumentException(var3);
            } catch (IOException var4) {
                throw new IllegalArgumentException(var4);
            }
        }
    }

    @Test
    public void testWriteValueAsString(){
        String s = JsonTool.writeValueAsString(new Integer(1));
        System.out.println(s);
    }

    public static <T> T readValue(String var0, Class<T> var1) {
        try {
            return mapper.readValue(var0, var1);
        } catch (JsonParseException var3) {
            throw new IllegalArgumentException(var3);
        } catch (JsonMappingException var4) {
            throw new IllegalArgumentException(var4);
        } catch (IOException var5) {
            throw new IllegalArgumentException(var5);
        }
    }

    public static ArrayList<Map<String, Object>> readValue2List(String var0) {
        ArrayList var1 = null;

        try {
            var1 = (ArrayList)mapper.readValue(var0, TypeFactory.collectionType(ArrayList.class, Map.class));
            return var1;
        } catch (JsonParseException var3) {
            throw new IllegalArgumentException(var3);
        } catch (JsonMappingException var4) {
            throw new IllegalArgumentException(var4);
        } catch (IOException var5) {
            throw new IllegalArgumentException(var5);
        }
    }

    public static <T> ArrayList<T> readValue2List(String var0, Class<T> var1) {
        try {
            return (ArrayList)mapper.readValue(var0, TypeFactory.collectionType(ArrayList.class, var1));
        } catch (JsonParseException var3) {
            throw new IllegalArgumentException(var3);
        } catch (JsonMappingException var4) {
            throw new IllegalArgumentException(var4);
        } catch (IOException var5) {
            throw new IllegalArgumentException(var5);
        }
    }

    public static <T> ArrayList<T> readValue2List(String var0, TypeReference<List<T>> var1) {
        try {
            return (ArrayList)mapper.readValue(var0, var1);
        } catch (JsonParseException var3) {
            throw new IllegalArgumentException(var3);
        } catch (JsonMappingException var4) {
            throw new IllegalArgumentException(var4);
        } catch (IOException var5) {
            throw new IllegalArgumentException(var5);
        }
    }

    public static <K, V> Map<K, V> readValue2Map(String var0, Class<K> var1, Class<V> var2) {
        try {
            return (Map)mapper.readValue(var0, TypeFactory.mapType(Map.class, var1, var2));
        } catch (JsonParseException var4) {
            throw new IllegalArgumentException(var4);
        } catch (JsonMappingException var5) {
            throw new IllegalArgumentException(var5);
        } catch (IOException var6) {
            throw new IllegalArgumentException(var6);
        }
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    static {
        mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
