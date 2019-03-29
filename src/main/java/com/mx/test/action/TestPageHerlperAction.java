package com.mx.test.action;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.test.entity.User;
import com.mx.test.service.ITestPageHerlperService;

/**
 *  描述: 测试pageHelper控制器
 *  作者: 郎国峰 
 *  时间: 2019年3月14日 上午9:43:22
 */
@Controller
@RequestMapping("testPageHelper")
public class TestPageHerlperAction {
	@Autowired
	private ITestPageHerlperService service;
	

	@RequestMapping("queryAll")
	public String queryAll(ModelMap map,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="3",required=false)int pageSize) {
		//测试是否进入测试pageHelper查询所有用户控制器
		PageHelper.startPage(pageNum, pageSize);
		//调用接口查询所有用户
		List<User> userList = service.queryAll();
		PageInfo info = new PageInfo(userList);
	
		map.put("info", info);
		return "jsp/test/pageHelper/pageHelper_list";
	}
}
