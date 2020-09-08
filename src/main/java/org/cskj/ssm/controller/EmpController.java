package org.cskj.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cskj.ssm.bean.Emp;
import org.cskj.ssm.service.EmpService;
import org.cskj.ssm.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping("list")
	public String queryAll(Model model,String currentPage,String mohu,Integer did ) {
		System.out.println(did);
		int count=empService.getCount(mohu);
		mohu=mohu==null ? "" : mohu;
		PageUtil page = new PageUtil(currentPage, count, 5);
		Map<String,Object> map= new HashMap<String, Object>();
		map.put("mohu",mohu);
		map.put("page", page);
		map.put("did", did);
		List<Emp> list = empService.queryEmpAll(map);
		model.addAttribute("list" ,list);
		model.addAttribute("page" ,page);
		model.addAttribute("mohu" ,mohu);
		model.addAttribute("result_did" ,did);
		return "emp/list";
	}
}
