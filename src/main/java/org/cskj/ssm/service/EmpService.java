package org.cskj.ssm.service;

import java.util.List;
import java.util.Map;

import org.cskj.ssm.bean.Emp;
import org.cskj.ssm.utils.PageUtil;

public interface EmpService {
	List<Emp> queryEmpAll(Map<String,Object> map);
	int getCount(String mohu);
	
}
