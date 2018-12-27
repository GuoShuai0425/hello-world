package com.dao;

import java.util.List;

import com.entity.Yuangong;

public interface YuangongDao {
	List<Yuangong> getYg();
	void addYuangong (Yuangong yg);
	List<Yuangong> getygByname(Yuangong yg);
	void deleteById(Yuangong yg);
}
