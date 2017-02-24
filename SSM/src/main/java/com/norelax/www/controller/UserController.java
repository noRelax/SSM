/**
 * 海风app在线学习平台
 * @author: no_relax
 * @Title: UserController.java 
 * @Package: com.norelax.www.controller
 * @date: 2017年2月24日-下午5:05:51
 * @version: Vpad1.2.0
 * @copyright: 2017上海风创信息咨询有限公司-版权所有
 * 
 */

package com.norelax.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.cyfonly.flogger.FLogger;

/**
 * @ClassName: UserController
 * @Description: TODO(用户controller)
 * @author no_relax
 * @date 2017年2月24日 下午5:05:51
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	private static final FLogger log = FLogger.getInstance();

	@RequestMapping("/login")
	public JSONObject login() {
		log.info("request /user/login... ");
		return null;
	}

}
