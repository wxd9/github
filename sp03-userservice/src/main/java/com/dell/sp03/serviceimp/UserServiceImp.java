package com.dell.sp03.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.sp01.web.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImp implements UserService{
	@Value("${sp.user-service.users}")
	private String userJson;
	@Override
	public User getUser(Integer id) {
		log.info("用户 json 数据"+userJson);
		List<User> list=JsonUtil.from(userJson, 
				//TypeReference此类专门用引用json提供的工具类
				new TypeReference<List<User>>() {});
		for (User user : list) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return new User(id,"name"+id,"pwd"+id);
	}

	@Override
	public void addScore(Integer id, Integer score) {
		
	}

}
