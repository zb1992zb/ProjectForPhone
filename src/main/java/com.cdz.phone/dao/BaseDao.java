package com.soa.mdm.dao;

import java.io.Serializable;
import java.util.List;

import com.soa.mdm.entity.PageBean;

/**
 * 基础数据库操作类
 * 
 * @author ss
 * 
 */
public interface BaseDao<T> {

	/**
	 * 保存一个对象
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o) throws Exception;

	/**
	 * 删除一个对象
	 * 
	 * @param o
	 */
	public void delete(T o) throws Exception;

	/**
	 * 更新一个对象
	 * 
	 * @param o
	 */
	public void update(T o) throws Exception;

	/**
	 * 保存或更新对象
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o) throws Exception;

	/**
	 * 合并对象
	 * 
	 * @param o
	 */
	public void merge(T o) throws Exception;

	/**
	 * 查询
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql) throws Exception;

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param) throws Exception;

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param) throws Exception;

	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 *            查询第几页
	 * @param rows
	 *            每页显示几条记录
	 * @return
	 */
	public List<T> find(String hql, Object[] param, PageBean pageBean) throws Exception;

	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, List<Object> param, PageBean pageBean) throws Exception;

	/**
	 * 获得一个对象
	 * 
	 * @param c
	 *            对象类型
	 * @param id
	 * @return Object
	 */
	public T get(Class<T> c, Serializable id) throws Exception;

	/**
	 * 获得一个对象
	 * 
	 * @param hql
	 * @param param
	 * @return Object
	 */
	public T get(String hql, Object[] param) throws Exception;

	/**
	 * 获得一个对象
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param) throws Exception;

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql) throws Exception;

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, Object[] param) throws Exception;

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, List<Object> param) throws Exception;

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @return 响应数目
	 */
	public Integer executeHql(String hql) throws Exception;

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @param param
	 * @return 响应数目
	 */
	public Integer executeHql(String hql, Object[] param) throws Exception;

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, List<Object> param) throws Exception;

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 * @return
	 */
	public Integer executeSql(String sql) throws Exception;

	/**
	 * 执行Hql查询返回一个字段的值
	 * 
	 * @param hqlStr
	 * @param param
	 * @return str
	 *
	 * @author cc
	 * @Time 2016年12月20日 上午9:53:51
	 */
	public String getStr(String hqlStr, List<Object> param) throws Exception;

	/**
	 * 执行Hql查询返回一个字段的值
	 * 
	 * @param hqlStr
	 * @return
	 *
	 * @author cc
	 * @Time 2016年12月20日 上午10:06:46
	 */
	public String getStr(String hqlStr) throws Exception;

	/**
	 * 获取数据库中所有表名字
	 * 
	 * @return
	 *
	 * @author cc
	 * @Time 2016年12月23日 上午10:30:55
	 */
	public List<String> getAllTableNameInDatabase() throws Exception;
}
