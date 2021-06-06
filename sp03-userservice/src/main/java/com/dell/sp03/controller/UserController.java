package com.dell.sp03.controller;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.sp01.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class UserController {
	@Autowired 	
	private UserService userService;
	@GetMapping("${userId}")
	public JsonResult<User> getUser(
			@PathVariable Integer userId){
		log.info("通过id获取用户"+userId);
		User u=userService.getUser(userId);
		return JsonResult.ok(u);
	}
	@GetMapping("/{userId}/score") 
	public JsonResult addScore(
			@PathVariable Integer userId, Integer score) {
		userService.addScore(userId, score);
		return JsonResult.ok();
	}}
