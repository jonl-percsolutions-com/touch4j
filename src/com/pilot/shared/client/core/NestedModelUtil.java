package com.pilot.shared.client.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pilot.shared.client.data.BaseModel;

public class NestedModelUtil {

    @SuppressWarnings("unchecked")
    public static <X> X getNestedValue(BaseModel model, String property) {
        return (X) getNestedValue(model, getPath(property));
    }

    @SuppressWarnings("unchecked")
    public static <X> X getNestedValue(BaseModel model, List<String> paths) {
        Object obj = model.get(paths.get(0));
        if (paths.size() == 1) {
            return (X) obj;
        } else if (obj != null && obj instanceof BaseModel) {
            List<String> tmp = new ArrayList<String>(paths);
            tmp.remove(0);
            return (X) getNestedValue((BaseModel) obj, tmp);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <X> X setNestedValue(BaseModel model, String property, Object value) {
        return (X) setNestedValue(model, getPath(property), value);
    }

    @SuppressWarnings("unchecked")
    public static <X> X setNestedValue(BaseModel model, List<String> paths, Object value) {
        int index = paths.size() - 1;
        String path = paths.get(index);
        paths.remove(index);
        BaseModel m = getNestedValue(model, paths);
        m.set(path, value);
        return (X) m.get(path);
    }

    public static boolean isNestedProperty(String property) {
        return property != null && property.contains(".");
    }

    private static List<String> getPath(String property) {
        return new ArrayList<String>(Arrays.asList(property.split("\\.")));
    }
}
