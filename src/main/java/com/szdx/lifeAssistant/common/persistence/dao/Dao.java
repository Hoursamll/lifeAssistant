package com.szdx.lifeAssistant.common.persistence.dao;

import java.util.List;

/**
 * Tips: Dao支持类实现
 * Created by shizhicheng on 2018/4/19.
 */
public interface Dao<T> {
    /**
     * Tips: 获取单条数据
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * Tips: 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    public int delete(String id);

    /**
     * Tips: 插入数据
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * Tips: 更新数据
     * @param entity
     * @return
     */
    public int update(T entity);

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
