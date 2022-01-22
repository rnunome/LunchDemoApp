package com.example.demo.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.User;

@Mapper
public interface UserRepository {
	public User findById(String name);
}
