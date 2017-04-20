package com.pzj.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONReader;

/**
 * Created by Administrator on 2016-7-28.
 */
public class JsonDataUtil {

    public static <T> T readOneFromClasspath(String path, Class<T> clazz){
        try {
            InputStream inputStream = JsonDataUtil.class.getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            JSONReader reader = new JSONReader(inputStreamReader);
            T obj = reader.readObject(clazz);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> readListFromClasspath(String path, Class<T> clazz){
        try {
            InputStream inputStream = JsonDataUtil.class.getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            JSONReader reader = new JSONReader(inputStreamReader);
            List<T> result = new ArrayList<>();
            reader.startArray();
            while (reader.hasNext()){
                T obj = reader.readObject(clazz);
                result.add(obj);
            }
            reader.endArray();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Set<T> readSetFromClasspath(String path, Class<T> clazz){
        try {
            InputStream inputStream = JsonDataUtil.class.getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            JSONReader reader = new JSONReader(inputStreamReader);
            Set<T> result = new HashSet<>();
            reader.startArray();
            while (reader.hasNext()){
                T obj = reader.readObject(clazz);
                result.add(obj);
            }
            reader.endArray();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
