package test.maven.HypMavenFirst;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Json2Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 将json格式字符串解析存储到map中的算法。
		String baiduIp = "{\"status\":\"0\",\"t\":\"1589286162270\",\"set_cache_time\":\"\",\"data\":[{\"location\":\"美国\",\"titlecont\":\"IP地址查询\",\"origip\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"3.3.3.3\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"3.3.3.3\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}]}";
		// 解析百度ip字符串为json格式对象。
		JSONObject baidujson = JSON.parseObject(baiduIp);
		System.out.println(baidujson);
		// 遍历每个键值对，存储到map中去
		// 获取值的方法，和map类似
		//System.out.println(baidujson.get("data"));
		// 创建一个新的map
		Map<String, Object> baidumap = new HashMap<>();
		// 遍历json中的所有键,由于键都用双引号引起来了，所以一定是string
		Set<String> jsonkeys = baidujson.keySet();
		for (String key : jsonkeys) {
//			System.out.println("键是"+key+"值是"+baidujson.get(key));
			baidumap.put(key, baidujson.get(key));
		}
		// 打印map内容
		System.out.println("map格式存储的结果："+baidumap);

		// 直接调用fastjson中的转换方法
		Map<String, Object> dirmap =  (Map<String, Object>) JSON.parse(baiduIp);
		// 输出结果由于是从jsonObject强转来的，所以输出结果没有采用map的 键=值的格式。
		System.out.println("直接转换成map的结果"+dirmap);
		// 使用entry来遍历map，说明一定是一个map了
		for (Entry<String, Object> e : dirmap.entrySet()) {
			//System.out.println("键是"+e.getKey()+"值是"+e.getValue());
		}

		// map拼接成为一个json格式的字符串
		// 遍历百度map的结果
		String connStr = "{";
		// 对于每个键，在前面加个" 后面加个 ":" 再拼接值，最后加个",
		for (Entry<String, Object> e : baidumap.entrySet()) {
			// 判断值是否是String,如果是String:在前面加个" 后面加个 ":" 再拼接值，最后加个",
			if (e.getValue() instanceof String) { 
				connStr += "\"" + e.getKey() + "\":\"" + e.getValue() + "\",";
			} else {
				// 如果不是string，拼接的时候：" 键 ": 值 ,
				connStr += "\"" + e.getKey() + "\":" + e.getValue() + ",";
			}
		}
		connStr += "}";
		// 由于最后多了一个,，所以替换一下这个逗号和花括号组合。
		connStr = connStr.replace(",}", "}");
		//System.out.println(connStr);

	}

}