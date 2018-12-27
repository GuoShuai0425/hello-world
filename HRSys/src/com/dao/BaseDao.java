package com.dao;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.OneToMany;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.common.DaoException;
import com.util.PageBean;

@Repository
public class BaseDao implements IBaseDao {
	protected  Logger logger =Logger.getLogger(BaseDao.class);
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Object obj) throws DaoException {
		// TODO Auto-generated method stub
		try {
			getSession().save(obj);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void update(Object obj) throws DaoException {
		// TODO Auto-generated method stub
		try {
			getSession().update(obj);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Object obj) throws DaoException {
		// TODO Auto-generated method stub
		try {
			getSession().delete(obj);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public Object get(Class cls, Serializable id) throws DaoException {
		// TODO Auto-generated method stub
		Object obj = null;
		try {
			Session session = getSession();
			obj = session.get(cls, id);
			// 获取所有的属性
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				// 获取属性的注解
				// @OneToMany(fetch=FetchType.LAZY)
				Annotation[] anns = field.getDeclaredAnnotations();
				for (Annotation annotation : anns) {
					if (annotation instanceof OneToMany) {
						// 属性名
						String fieldName = field.getName();
						String first = fieldName.substring(0, 1).toUpperCase();
						// 拼接 getOrderItems()
						String methodName = "get" + first + fieldName.substring(1);
						Method method = cls.getDeclaredMethod(methodName);
						Set set = (Set) method.invoke(obj);
						set.size();
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);

		}
		return obj;
	}

	@Override
	public List query(String hql, Map<String, Object> paraMap) throws DaoException {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		try {
			Session session = getSession();
			Query query = session.createQuery(hql);
			if (paraMap != null) {
				query.setProperties(paraMap);
			}
			result = query.list();
		} catch (Exception e) {

			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);

		}
		return result;
	}

	@Override
	public void delete(Class cls, Serializable id) throws DaoException {
		// TODO Auto-generated method stub
		Object obj = this.get(cls, id);
		this.delete(obj);
	}

	@Override
	public List query(String hql) {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		try {
			Session session = getSession();
			Query query = session.createQuery(hql);

			result = query.list();
		} catch (Exception e) {

			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);

		}
		return result;
	}

	@Override
	public PageBean query4Page(String hql, String countHql, PageBean pageBean) throws DaoException {
		// TODO Auto-generated method stub
		try {
			Session session = getSession();
			Query query = session.createQuery(hql);
			query.setProperties(pageBean.getParaMap());
			int start = (pageBean.getCurrPageNo() - 1) * pageBean.getPageSize();
			query.setFirstResult(start);// 查询的起始索引
			query.setMaxResults(pageBean.getPageSize());// 查询结果记录数
			ArrayList result = (ArrayList) query.list();
			Query countQuery = session.createQuery(countHql);
			countQuery.setProperties(pageBean.getParaMap());
			Long total = (Long) countQuery.uniqueResult();
			pageBean.setTotalCount(total.intValue());
			pageBean.setResultList(result);

		} catch (Exception e) {

			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);

		}
		return pageBean;
	}

	@Override
	public List queryBySql(String sql, Class voCls) throws DaoException {
		List result = new ArrayList();
		try {
			Session session = getSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(voCls));
			result = query.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DaoException(e.getMessage(), e);

		}
		return result;
	}
}
