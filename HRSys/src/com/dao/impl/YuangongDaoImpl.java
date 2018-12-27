package com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dao.BaseDao;
import com.dao.YuangongDao;
import com.entity.Yuangong;
@Repository
public class YuangongDaoImpl extends BaseDao implements YuangongDao {

	@Override
	public List<Yuangong> getYg() {
		String hql="from Yuangong";
		return query(hql);
	}

	@Override
	public void addYuangong(Yuangong yg) {
		this.add(yg);
	}

	@Override
	public List<Yuangong> getygByname(Yuangong yg) {
		String hql ="from Yuangong yg where yg.staffName like '%"+yg.getStaffName()+"%')";
		return query(hql);
	}

	@Override
	public void deleteById(Yuangong yg) {
		delete(yg);
	}

}
