package com.example.javalearn.hot.restore;

import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import dalvik.system.PathClassLoader;

public class HotRestoreUtils {
    public static  void HotRestore(PathClassLoader pathClassLoader, List<File> List,String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = findFiled(pathClassLoader, fieldName);
        Log.d("HotRestoreUtils","field=="+field.get(fieldName));
    }

    public static Field findFiled(Object object,String fieldName) throws NoSuchFieldException {
        for (Class objectClass=object.getClass();objectClass!=null;objectClass=object.getClass().getSuperclass()){
            Field field = null;
            try {
                field = objectClass.getDeclaredField(fieldName);
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        throw new NoSuchFieldException("Field " + fieldName + " not found in " + object.getClass());
    }

}
