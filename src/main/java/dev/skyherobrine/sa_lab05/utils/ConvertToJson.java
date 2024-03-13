package dev.skyherobrine.sa_lab05.utils;

import com.google.gson.Gson;

import java.util.List;

public class ConvertToJson {

    public static String convertObjectToJson(Object object) {
        return new Gson().toJson(object);
    }

    public static String convertListToJson(List<Object> list) {
        return new Gson().toJson(list);
    }
}
