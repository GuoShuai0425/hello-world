package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YuangongDao;
import com.entity.Yuangong;
import com.service.YuangongService;
@Service
public class YuangongServiceImpl implements YuangongService {
	@Autowired
	private YuangongDao ygdao;
	@Override
	public List<Yuangong> getYg() {
		List<Yuangong> yglist = ygdao.getYg();
		return yglist;
	}
	@Override
	public void addYuangong(Yuangong yg) {
		ygdao.addYuangong(yg);
	}
	@Override
	public List<Yuangong> getygByname(Yuangong yg) {
		return ygdao.getygByname(yg);
	}
	@Override
	public void deleteById(Yuangong yg) {
		ygdao.deleteById(yg);
	}

}
