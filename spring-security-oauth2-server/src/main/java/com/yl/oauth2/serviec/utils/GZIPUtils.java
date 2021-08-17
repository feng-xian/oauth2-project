package com.yl.oauth2.serviec.utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.assertj.core.util.Maps;
import org.bouncycastle.util.encoders.Base64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Auther: liangbl
 * @Date: 2018/12/21 13:06
 * @Description:
 */
public class GZIPUtils {
    /**
     * 使用gzip进行压缩
     */
    public static String compress(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] encode = Base64.getEncoder().encode(out.toByteArray());
        return new String(encode);
//        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 使用gzip进行解压缩
     */
    public static String uncompress(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            compressed = Base64.getDecoder().decode(compressedStr);
//            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            try {
                out.close();
            } catch (IOException e) {
            }
        }
        return decompressed;
    }

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("head","456522");
        map.put("test","fdsafd");

        ArrayList<Map<String, String>> maps = new ArrayList<>();
        for (int i=0;i<20;i++){
            HashMap<String, String> stringHashMap = new HashMap<>(3);
            stringHashMap.put("test"+i,"test_"+i);
            stringHashMap.put("test"+i,"test_"+i);
            stringHashMap.put("test"+i,"test_"+i);
            maps.add(stringHashMap);
        }

        map.put("list", maps);

        String paramMap = JSONObject.toJSONString(map);
        String str =
                "1888888888888888888888884444444444444444444444444444443333333333333333332222222222222222288888888888888884444444444444444444444444443333d888888888888888866666";
//        System.out.println("原字符串：" + str);
//        System.out.println("原长度：" + str.length());
//        String compress = GZIPUtils.compress(str);
//        System.out.println("压缩后字符串：" + compress);
//        System.out.println("压缩后字符串长度：" + compress.length());
//        String string = GZIPUtils.uncompress(compress);
//        System.out.println("解压缩后字符串：" + string);
//        System.out.println("解压缩后字符串：" + str);

        System.out.println("原字符串：" + paramMap);
        System.out.println("原长度：" + paramMap.length());
        String compress = GZIPUtils.compress(paramMap);
        System.out.println("压缩后字符串：" + compress);
        System.out.println("压缩后字符串长度：" + compress.length());
        String string = GZIPUtils.uncompress(compress);
        System.out.println("解压缩后字符串：" + string);
        System.out.println("解压缩后字符串：" + paramMap);

    }
}