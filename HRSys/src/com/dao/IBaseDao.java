package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.common.DaoException;
import com.util.PageBean;





public interface IBaseDao {
	 void add(Object obj) throws DaoException;
	    void update(Object obj) throws DaoException;
	    void delete(Object obj) throws DaoException;
	    void delete(Class cls,Serializable id) throws DaoException;
	    Object get(Class cls,Serializable id) throws DaoException;
	    List query(String hql) throws DaoException;
	    List query(String hql,Map<String,Object> paraMap) throws DaoException;
	    PageBean query4Page(String hql,String countHql,PageBean pageBean) throws DaoException;
	    List queryBySql(String sql,Class voCls) throws DaoException;
	   
}
