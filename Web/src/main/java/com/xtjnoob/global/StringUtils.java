package com.xtjnoob.global;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    public static boolean isNotEmpty(String target) {
        return target != null && !"".equals(target);
    }

    public static Date string2Date(String target) throws ParseException {
        if ("".equals(target)) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(target);
        }
    }
}
