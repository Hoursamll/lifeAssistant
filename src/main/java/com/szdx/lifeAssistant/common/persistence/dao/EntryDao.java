package com.szdx.lifeAssistant.common.persistence.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Tips: EntryDao<T>支持类实现
 * @author szc
 * @param <T>
 */
public interface EntryDao<T> extends Dao<T> {
	
	/**
	 * Tips: 根据父ID删除分录记录
	 * @param id
	 * @return
	 */
	public int deleteByParentId(@Param("id") String id);
	
	public List<T> findListByParentId(@Param("id") String id);
	
	/**
	 * Tips: 根据对象中的指定条件获取对象集合
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * Tips: 根据自定义sql条件查询对象集合
	 * @param sqlWhere
	 * @return
	 */
	public List<T> findList(String sqlWhere);
	

}