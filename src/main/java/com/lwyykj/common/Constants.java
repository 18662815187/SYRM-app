package com.lwyykj.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * 业务常量
 * 
 * @author john
 *
 */
public class Constants {
	private static long fileNewName = 0;
	// 图片服务器
	public static final String IMG_URL = "http://www.zjyyxxw.com/";
	// 用户名
	public static final String USER_NAME = "USER_NAME";
	// 购物车 保存在cookie中的名称
	public static final String BUYER_CART = "BUYER_CART";
	// 登录中转页面
	public static final String LOGIN_URL = "../../sessionrun.jsp";
	// 登录状态码
	public static final String LOGIN_STATUS = "LOGIN_STATUS";
	// 登录时间
	public static final String LOGIN_TIME = "LONGIN_TIME";

	// 图片新名字
	public synchronized static String getNewFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = sdf.format(new Date());
		fileNewName++;
		return now + fileNewName;
	}

	// 订单号orderNum
	public synchronized static String getOrderNum() {
		int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
	}
}
