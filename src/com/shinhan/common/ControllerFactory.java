package com.shinhan.common;

import com.shinhan.dept.DeptController;
import com.shinhan.emp.EmpController;
import com.shinhan.job.JobController;

public class ControllerFactory {

	public static CommonInterface make(String business) {
		CommonInterface controller = null;
		switch(business) {
		case "emp" -> {controller = new EmpController();}
		case "dept" -> {controller = new DeptController();}
		case "job" -> {controller = new JobController();}
		}
		return controller;
	}

	
}
