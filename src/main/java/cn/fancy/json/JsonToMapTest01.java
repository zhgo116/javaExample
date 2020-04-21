package cn.fancy.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;
import java.util.Map;

class JsonUtil {
    /**
     * JSON 转 POJO
     */
    public static <T> T getObject(String pojo, Class<T> tclass) {
        try {
            return JSONObject.parseObject(pojo, tclass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POJO 转 JSON
     */
    public static <T> String getJson(T tResponse) {
        String pojo = JSONObject.toJSONString(tResponse);
        return pojo;
    }

}

class JsonListUtil {
    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }

}

public class JsonToMapTest01 {
    public static void main(String[] args) {

        String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        //第一种方式
        Map maps = (Map) JSON.parse(str);
        System.out.println("这个是用JSON类来解析JSON字符串!!!");
        for (Object map : maps.entrySet()) {
            System.out.println(((Map.Entry) map).getKey() + "     " + ((Map.Entry) map).getValue());
        }
        //第二种方式
        Map mapTypes = JSON.parseObject(str);
        System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
        for (Object obj : mapTypes.keySet()) {
            System.out.println("key为：" + obj + "值为：" + mapTypes.get(obj));
        }
        //第三种方式
        Map mapType = JSON.parseObject(str, Map.class);
        System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!");
        for (Object obj : mapType.keySet()) {
            System.out.println("key为：" + obj + "值为：" + mapType.get(obj));
        }
        //第四种方式
        /**
         * JSONObject是Map接口的一个实现类
         */
        Map json = (Map) JSONObject.parse(str);
        System.out.println("这个是用JSONObject类的parse方法来解析JSON字符串!!!");
        for (Object map : json.entrySet()) {
            System.out.println(((Map.Entry) map).getKey() + "  " + ((Map.Entry) map).getValue());
        }
        //第五种方式
        /**
         * JSONObject是Map接口的一个实现类
         */
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println("这个是用JSONObject的parseObject方法来解析JSON字符串!!!");
        for (Object map : json.entrySet()) {
            System.out.println(((Map.Entry) map).getKey() + "  " + ((Map.Entry) map).getValue());
        }
        //第六种方式
        /**
         * JSONObject是Map接口的一个实现类
         */
        Map mapObj = JSONObject.parseObject(str, Map.class);
        System.out.println("这个是用JSONObject的parseObject方法并执行返回类型来解析JSON字符串!!!");
        for (Object map : json.entrySet()) {
            System.out.println(((Map.Entry) map).getKey() + "  " + ((Map.Entry) map).getValue());
        }
        String strArr = "{{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}}";
        // JSONArray.parse()
        System.out.println(json);


        //json转list集合对象

       List<User> c= JsonListUtil.jsonToList("[{\n" +
                "\t\"name\": \"操圣\",\n" +
                "\t\"age\": 12\n" +
                "}, {\n" +
                "\t\"name\": \"java\",\n" +
                "\t\"age\": 1\n" +
                "}]",User.class);
        System.out.println(c);
    }
}
@Data
class User{
    private String name="zhangsan";
    private int age;
}
