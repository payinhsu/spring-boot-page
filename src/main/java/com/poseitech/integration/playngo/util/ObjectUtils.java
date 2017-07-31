package com.poseitech.integration.playngo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * ${file_name} created ${date}
 * <p>
 * \$LastChangedBy\$ \$Date\$ \$Revision\$
 */
public class ObjectUtils {
   private ObjectUtils() {
   }

   public static Map<String, Object> getFieldNamesAndValues(final Object obj, boolean publicOnly)
         throws IllegalArgumentException, IllegalAccessException {
      Class<? extends Object> c1 = obj.getClass();
      Map<String, Object> map = new HashMap<String, Object>();
      Field[] fields = c1.getDeclaredFields();
      for (int i = 0; i < fields.length; i++) {
         String name = fields[i].getName();
         if (publicOnly) {
            if (Modifier.isPublic(fields[i].getModifiers())) {
               Object value = fields[i].get(obj);
               map.put(name, value);
            }
         } else {
            fields[i].setAccessible(true);
            Object value = fields[i].get(obj);
            map.put(name, value);
         }
      }
      return map;
   }

   public static Object setFieldValue(final Object obj, String fieldName, String setValue)
         throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InstantiationException {
      Class<? extends Object> c1 = obj.getClass();
      Object object = c1.newInstance();
      Field[] fields = c1.getDeclaredFields();
      for (int i = 0; i < fields.length; i++) {
         String name = fields[i].getName();
         if (name.equals(fieldName)) {
            fields[i].setAccessible(true);
            fields[i].set(object, setValue);
         } else if (!name.equals("serialVersionUID")) {
            fields[i].setAccessible(true);
            fields[i].set(object, fields[i].get(obj));
         }
      }
      return object;
   }

   public static String getClassName(final Object obj) {
      Class<? extends Object> c1 = obj.getClass();
      return c1.getSimpleName();
   }
}
