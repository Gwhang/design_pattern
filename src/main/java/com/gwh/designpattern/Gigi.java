package com.gwh.designpattern;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.SortedMap;
import java.util.TreeMap;

public class Gigi {
    public static void main(String[] args) throws UnsupportedEncodingException {

        SortedMap<String,String> map=new TreeMap<String,String>();

        map.put("serviceKey","dg_8686_9ZP6RTFEG3H9S6BEREDZBZGKR");
        map.put("orderId","ruyi1616575981854697513584");
        map.put("productType","138");
        map.put("orderType","0");
        map.put("phoneNum","18532271520");
        map.put("contactNum","13784080043");
        map.put("certName","赵勇煜");
        map.put("certNo","130726199408010053");
        map.put("provinceCode","76");
        map.put("cityCode","763");
        map.put("postProvinceCode","410000");
        map.put("postCityCode","411600");
        map.put("postDistrictCode","411622");
        map.put("postAddr","河南省周口市西华县西夏亭镇");
        map.put("postName","赵勇煜");
        map.put("custId","99999963852741");
        map.put("referrerName","东莞市石龙如意电子渠道");
        map.put("referrerCode","5111578480");
        map.put("referrerDepartId","51b9ut4");
        map.put("firstMonthFee","A000011V000003");
        map.put("goodsId","981610241535");
        map.put("channel","08-2278-5761-5075");
        map.put("captchaId","21032417530665965199");
        map.put("baseProductId","");
        System.out.println(getParamsSign(map));


    }
    public static String getParamsSign(SortedMap<String, String> params) throws UnsupportedEncodingException {
        params.remove("sign");
        String paramsJsonStr = JSONObject.toJSONString(params);
        System.out.println(paramsJsonStr);
        return DigestUtils.md5DigestAsHex(paramsJsonStr.getBytes("utf-8")).toUpperCase();
    }

}
