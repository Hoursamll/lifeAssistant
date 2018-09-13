package com.szdx.lifeAssistant.common.aop;

import com.szdx.lifeAssistant.common.persistence.entity.Entity;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class FilterAOP<T extends Entity<T>> {
	
	//@Pointcut("execution(* com.top.cloud.*.*(..))")  
//		private void listJson(){}//定义一个切入点 
	/**
	 * 面向查询切面-listJson
	 * dataPermissionList-数据权限
	 * groupid - 分组隔离
	 * isLook - 下查数据隔离
	 * @param request
	 * @param response
	 * @param
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response){

	}
	
	
	protected void setDataPermissions(String requestURI) {
		
		}
	
	/**
	 * Tips: 默认过滤方案
	 * @param request 
	 * @param entity 实体对象
	 * @param billType 单据类型
	 */
	protected void setDefaultFilter(HttpServletRequest request, Entity<?> entity, String billType) {

	}
	
	/**
	 * Tips: 组织过滤
	 * @param entity 实体对象
	 * @param billType 单据类型
	 */
	protected void setOrgFilter(Entity<?> entity, String billType) {

	}
}
