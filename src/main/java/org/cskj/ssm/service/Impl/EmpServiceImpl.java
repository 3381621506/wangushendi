package org.cskj.ssm.service.Impl;

import java.util.List;
import java.util.Map;

import org.cskj.ssm.bean.Emp;
import org.cskj.ssm.mapper.EmpMapper;
import org.cskj.ssm.service.EmpService;
import org.cskj.ssm.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> queryEmpAll(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return empMapper.queryEmpAll(map);
	}

	public int getCount(String mohu) {
		// TODO Auto-generated method stub
		return empMapper.getCount(mohu);
	}

	

	

}
