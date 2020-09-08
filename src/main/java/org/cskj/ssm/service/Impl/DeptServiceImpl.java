package org.cskj.ssm.service.Impl;

import java.util.List;
import java.util.Map;

import org.cskj.ssm.bean.Dept;
import org.cskj.ssm.bean.Emp;
import org.cskj.ssm.mapper.DeptMapper;
import org.cskj.ssm.mapper.EmpMapper;
import org.cskj.ssm.service.DeptService;
import org.cskj.ssm.service.EmpService;
import org.cskj.ssm.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptMapper deptMapper;

	public List<Dept> queryDeptAll() {
		// TODO Auto-generated method stub
		return deptMapper.queryDeptAll();
	}
	
	
	

	

}
