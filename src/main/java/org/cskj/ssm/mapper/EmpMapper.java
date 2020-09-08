package org.cskj.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.cskj.ssm.bean.Emp;
import org.cskj.ssm.utils.PageUtil;

public interface EmpMapper {
	List<Emp> queryEmpAll(Map<String,Object> map);
	int getCount(String mohu);
	
	
}
