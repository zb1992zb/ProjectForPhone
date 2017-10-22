package com.soa.mdm.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.soa.mdm.dao.BaseDao;
import com.soa.mdm.entity.PageBean;

@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T o) throws Exception {
		return this.getCurrentSession().save(o);
	}

	@Override
	public void merge(T o) throws Exception {
		this.getCurrentSession().merge(o);
	}

	@Override
	public void delete(T o) throws Exception {
		System.err.println(this.getCurrentSession());
		this.getCurrentSession().delete(o);
	}

	@Override
	public void update(T o) throws Exception {
		this.getCurrentSession().update(o);
	}

	@Override
	public void saveOrUpdate(T o) throws Exception {
		this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public List<T> find(String hql) throws Exception {
		return this.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<T> find(String hql, Object[] param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, List<Object> param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, Object[] param, PageBean pageBean) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
	}

	@Override
	public List<T> find(String hql, List<Object> param, PageBean pageBean) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
	}

	@Override
	public T get(Class<T> c, Serializable id) throws Exception {
		return (T) this.getCurrentSession().get(c, id);
	}

	@Override
	public T get(String hql, Object[] param) throws Exception {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T get(String hql, List<Object> param) throws Exception {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Long count(String hql) throws Exception {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Long count(String hql, Object[] param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, List<Object> param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public Integer executeHql(String hql) throws Exception {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, Object[] param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, List<Object> param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	@Override
	public Integer executeSql(String sql) throws Exception {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	@Override
	public String getStr(String hqlStr, List<Object> param) throws Exception {
		Query q = this.getCurrentSession().createQuery(hqlStr);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (String) q.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soa.mdm.dao.BaseDao#getStr(java.lang.String)
	 */
	@Override
	public String getStr(String hqlStr) throws Exception {
		Query q = this.getCurrentSession().createQuery(hqlStr);
		List<String> list = q.list();
		if (list != null) {
			return list.get(0);
		} else {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soa.mdm.dao.BaseDao#getAllTableNameInDatabase()
	 */
	@Override
	public List<String> getAllTableNameInDatabase() throws Exception {
		List<String> tableNames = new ArrayList();
		Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		for (String entityName : map.keySet()) {
			SessionFactoryImpl sfImpl = (SessionFactoryImpl) sessionFactory;
			String tableName = ((AbstractEntityPersister) sfImpl.getEntityPersister(entityName)).getTableName();
			tableNames.add(tableName);
		}
		return tableNames;
	}

}
