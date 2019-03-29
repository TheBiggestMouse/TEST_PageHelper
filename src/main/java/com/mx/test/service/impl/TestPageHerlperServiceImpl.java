package com.mx.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.test.entity.User;
import com.mx.test.mapper.UserMapper;
import com.mx.test.service.ITestPageHerlperService;

/**
 *  描述: 测试接口模型实现类
 *  作者: 郎国峰 
 *  时间: 2019年3月14日 上午10:59:54
 */
@Service
public class TestPageHerlperServiceImpl implements ITestPageHerlperService {
	@Autowired
	private UserMapper userMapper;
	

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> userList = userMapper.queryAll();
		
		
		return userList;
	}

}
