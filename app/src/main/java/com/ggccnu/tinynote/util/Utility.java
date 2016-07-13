package com.ggccnu.tinynote.util;

import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
	/**
	 * 解析服务器返回的地理位置json数据，百度返回的数据非JSON格式的数据，需要先处理下，转化为JSON格式的数据，再提取想要的位置信息。
	 *我需要的是city，district。他们在addressComponent这个键的值里面。先得到JSON对象result,再得到JSON对象addressComponet。
	 *最后从中取出city,district
	 */
	public static String handleLocationResponse(String response) {
		try {
			// 转换为json数据先
			String tmp = response.split("\\(")[1];
			String responseJson = tmp.split("\\)")[0];
			JSONObject jsonObject = new JSONObject(responseJson);
			JSONObject result = jsonObject.getJSONObject("result");
			JSONObject addressComponent = result.getJSONObject("addressComponent");
			String city = addressComponent.getString("city");
			String district = addressComponent.getString("district");
			return city+district;
		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}
	}
}