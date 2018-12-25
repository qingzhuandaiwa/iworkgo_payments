package com.yk.iworkgo.payment.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yk.iworkgo.utils.EhCacheUtil;
import com.yk.iworkgo.utils.http.HttpUtil;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataservicesService {

	/**
	 * 获取AccessToken
	 * @return Access_Token
	 */
    @Cacheable
	public static String getAccessToken(){
        String key = "Access_Token";
        String Access_Token = (String)EhCacheUtil.getInstance().get("payment",key);

		if(StringUtils.isEmpty(Access_Token)){
            HttpUtil.requestGet("");
			String data = HttpKit.get(PropKit.get("IPPort")+PropKit.get("getToken")+"?client_id="+PropKit.get("client_id")+"&client_secret="+PropKit.get("client_secret"));
			System.out.println("Access_Token获取返回数据============="+data);
			try {
				Access_Token = JSONObject.fromObject(data).getString("access_token");
			} catch (Exception e) {
				System.out.println("Access_Token获取失败！");
			}
			CacheKit.put("Access_Token", "Access_Token", Access_Token);
		}

		return Access_Token;
	}

	/**
	 * 获取投诉电话(逗号分隔)
	 * @return ComplaintsHotline
	 */
	public static String getComplaintsHotline(String parkId){
		String data = HttpKit.get(PropKit.get("IPPort")+PropKit.get("getParkListInfo")+"?$filter=isDel%20eq%200%20and%20parkId%20eq%20"+parkId+"&access_token="+DataservicesService.getAccessToken()+"&$format=json");
		System.out.println("ComplaintsHotline获取返回数据============="+data);
		String ComplaintsHotline = "";
		try {
			 ComplaintsHotline = JSONObject.fromObject(JSONArray.fromObject(JSONObject.fromObject(data).getString("value")).get(0)).getString("contactWay");
		} catch (Exception e) {
			System.out.println("ComplaintsHotline获取失败！");
		}

		return ComplaintsHotline;
	}

	/**
	 * 获取楼宇信息
	 * @return ComplaintsHotline
	 */
	public static Map<String, String> getBuildingListInfo(String parkId){
		String BuildingListInfo = HttpKit.get(PropKit.get("IPPort")+PropKit.get("getBuildingListInfo")+"?$filter=isDel%20eq%200%20and%20parkId%20eq%20"+parkId+"&access_token="+DataservicesService.getAccessToken()+"&$format=json");
		System.out.println("BuildingListInfo获取返回数据============="+BuildingListInfo);
		Map<String, String> buildMap = new HashMap<String, String>();
		try {
			JSONArray buildInfo_str = JSONArray.fromObject(JSONObject.fromObject(BuildingListInfo).getString("value"));
			for (int i = 0; i < buildInfo_str.size(); i++) {
				String buildingId = JSONObject.fromObject(buildInfo_str.get(i)).getString("buildingId");
				String buildingName = JSONObject.fromObject(buildInfo_str.get(i)).getString("buildingName");
				buildMap.put(buildingId, buildingName);
			}
		} catch (Exception e) {
			System.out.println("BuildingListInfo获取失败！");
		}

//		buildMap.put("1", "1号楼");
//		buildMap.put("2", "2号楼");
//		buildMap.put("3", "3号楼");
//		buildMap.put("4", "4号楼");
//		buildMap.put("5", "5号楼");
//		buildMap.put("6", "6号楼");
//		buildMap.put("7", "7号楼");
//		buildMap.put("8", "8号楼");
		return buildMap;
	}

	/**
	 * 获取园区信息
	 * @return ComplaintsHotline
	 */
	public static List<Map<String, String>> getParkListInfo(){
		String IPPort = PropKit.use("config.properties").get("IPPort");
		String getParkListInfo = PropKit.use("config.properties").get("getParkListInfo");

		String ParkListInfo = HttpKit.get(IPPort+getParkListInfo+"?access_token="+DataservicesService.getAccessToken()+"&$top=20&$format=json");
		System.out.println("ParkListInfo获取返回数据============="+ParkListInfo);
		List<Map<String, String>> resultS = new ArrayList<Map<String,String>>();
		try {
			JSONArray parkInfo_str = JSONArray.fromObject(JSONObject.fromObject(ParkListInfo).getString("value"));
			for (int i = 0; i < parkInfo_str.size(); i++) {
				Map<String, String> parkMap = new HashMap<String, String>();
				String parkId = JSONObject.fromObject(parkInfo_str.get(i)).getString("parkId");
				String parkName = JSONObject.fromObject(parkInfo_str.get(i)).getString("parkName");
				String parkAddr = JSONObject.fromObject(parkInfo_str.get(i)).getString("parkAddr");
				String contacts = JSONObject.fromObject(parkInfo_str.get(i)).getString("contacts");
				String contactWay = JSONObject.fromObject(parkInfo_str.get(i)).getString("contactWay");
				String backPic = JSONObject.fromObject(parkInfo_str.get(i)).getString("backPic");
				String isDel = JSONObject.fromObject(parkInfo_str.get(i)).getString("isDel");
				String cTime = JSONObject.fromObject(parkInfo_str.get(i)).getString("cTime");
				String uTime = JSONObject.fromObject(parkInfo_str.get(i)).getString("uTime");
				parkMap.put("parkId", parkId);
				parkMap.put("parkName", parkName);
				parkMap.put("parkAddr", parkAddr);
				parkMap.put("contacts", contacts);
				parkMap.put("contactWay", contactWay);
				parkMap.put("backPic", backPic);
				parkMap.put("isDel", isDel);
				parkMap.put("cTime", cTime);
				parkMap.put("uTime", uTime);
				resultS.add(parkMap);
			}
		} catch (Exception e) {
			System.out.println("ParkListInfo获取失败！");
		}

		return resultS;
	}

	/**
	 * @param buildingId
	 * @return
	 */
	public static Map<String,String> getRoomsByBuildingId(String buildingId){
		String IPPort = PropKit.use("config.properties").get("IPPort");
		String getApartmentListInfo = PropKit.use("config.properties").get("getApartmentListInfo");
		Map<String, String> roomMap = new HashMap<String, String>();
		try {
			String roomListInfo = HttpKit.get(IPPort+getApartmentListInfo+ "?$filter=buildingId%20eq%20" + buildingId +
					"&access_token="+DataservicesService.getAccessToken()+"&$format=json");
			System.out.println("RoomList获取返回数据============="+roomListInfo);
			JSONArray roomsJsonArr = JSONArray.fromObject(JSONObject.fromObject(roomListInfo).getString("value"));
			for(int i = 0; i < roomsJsonArr.size(); i++) {
				String roomId = JSONObject.fromObject(roomsJsonArr.get(i)).getString("roomId");
				String roomNumber = JSONObject.fromObject(roomsJsonArr.get(i)).getString("roomNumber");
				roomMap.put(roomId, roomNumber);
			}
			return roomMap;
		} catch (Exception e) {
			e.printStackTrace();
			return roomMap;
		}
	}

	/**
	 * 根据buildingId和roomid获取对应的公司详情
	 * @param buildingId
	 * @param roomId
	 * @return
	 */
	public static Map<String,String> getCompanyInfo(String buildingId,String roomId) {
		String ContractListInfo = HttpKit.get(PropKit.get("IPPort")+PropKit.get("getContractList")+"?$filter=buildingId%20eq%20"+buildingId+"&access_token="+DataservicesService.getAccessToken()+"&$format=json");
		System.out.println("ContractListInfo获取返回数据============="+ContractListInfo);
		Map<String, String> companyMap = new HashMap<String, String>();
		String companyId = null;
		String companyName = null;
		try {
			JSONArray jsonArray = JSONArray.fromObject(JSONObject.fromObject(ContractListInfo).getString("value"));
			for (int i = 0; i < jsonArray.size(); i++) {
				String roomIds = JSONObject.fromObject(jsonArray.get(i)).getString("roomIds");
				String enterpriseId = JSONObject.fromObject(jsonArray.get(i)).getString("enterpriseId");//企业id
				 if(!StrKit.isBlank(roomIds)) {
					 if(roomIds.contains(roomId)) {
						 companyId = enterpriseId;
						 break;
					 }
				 }
			}
			if(!StrKit.isBlank(companyId)) {
				String companyInfo = HttpKit.get(PropKit.get("IPPort")+PropKit.get("getEnterpriseListInfo")+"?$filter=enterpriseId%20eq%20"+companyId+"&access_token="+DataservicesService.getAccessToken()+"&$top=1&$format=json");
				System.out.println("companyInfo获取返回数据============="+companyInfo);
				JSONArray companyInfoArr = JSONArray.fromObject(JSONObject.fromObject(companyInfo).getString("value"));
				if(companyInfoArr != null && companyInfoArr.size() > 0) {
					companyName = JSONObject.fromObject(companyInfoArr.get(0)).getString("enterpriseName");
				}
			}
			companyMap.put(companyId, companyName);
		} catch (Exception e) {
			System.out.println("companyInfo获取失败！");
			e.printStackTrace();
		}
		return companyMap;
	}

}
