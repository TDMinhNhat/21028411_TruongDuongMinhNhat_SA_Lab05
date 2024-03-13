package dev.skyherobrine.sa_lab05.utils;

import com.google.gson.Gson;

import java.util.List;

public class ConvertToObject {

    public static Object convertJsonToOject(String json, Class<? extends Object> clazz) {
        return new Gson().fromJson(json, clazz);
    }

    public static List<? extends Class> convertJsonToList(String json, Class<? extends Object> clazz) {
        return (List<? extends Class>) new Gson().fromJson(json, clazz);
    }
}
