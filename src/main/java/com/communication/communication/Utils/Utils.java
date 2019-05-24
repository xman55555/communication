package com.communication.communication.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String generateTimeStringId() {
        StringBuffer id = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        String time = sdf.format(new Date());
        id.append(time);
        // 生成的3位的随机数
        id.append(Math.round(Math.random() * 900) + 100);
        return id.toString();
    }
}
