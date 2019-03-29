package com.mx.test.service;

import java.util.List;

import com.mx.test.entity.User;

/**
 *  描述: 测试模型接口
 *  作者: 郎国峰 
 *  时间: 2019年3月14日 上午10:56:24
 */
public interface ITestPageHerlperService {
	/**
	 * @方法名: queryAll 
	 * @描述: TODO 查询所有用户
	 * @作者: 郎国峰
	 * @时间: 2019年3月14日 上午10:58:32
	 * @参数: @return   
	 * @返回类型： List<User>     
	 * @throws
	 */
	List<User> queryAll();

}
