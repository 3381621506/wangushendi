package org.cskj.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cskj.ssm.bean.Dept;
import org.cskj.ssm.service.DeptService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("queryDeptAll")
	@ResponseBody
	public void queryDeptAll(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		List<Dept> list = deptService.queryDeptAll();
		String string = JSON.toJSONString(list);
		response.getWriter().print(string);
	}
	
}
