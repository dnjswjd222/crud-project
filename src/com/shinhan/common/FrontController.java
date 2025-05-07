package com.shinhan.common;

import java.util.Scanner;

import com.shinhan.dept.DeptController;
import com.shinhan.emp.EmpController;

//FrontController패턴 : Controller가 여러개인 경우 사용자의 요청과 응답은 출구가 여러개
//바람직하지 않음
//하나로 통합(Front는 1개)
//Servlet : DispatcherSerlet있다. (Spring은 FrontController가 이미 있다.)
public class FrontController {

	public static void main(String[] args) {
		//사용자가 emp, dept 작업할 것인지 결정
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		CommonInterface controller = null;
		while(!isStop) {
			System.out.print("emp, dept, job/ end>>");
			String job = sc.next();
			switch(job) {
			case "emp" -> {controller = ControllerFactory.make("emp");}
			case "dept" -> {controller = ControllerFactory.make("dept");}
			case "job" -> {controller = ControllerFactory.make("job");}
			case "end" -> {isStop = true; continue;}
			default -> {continue;}
			}
			controller.execute(); //작업이 달라져도 사용법은 같다.(전략패턴)
		}
		sc.close();
		System.out.println("=======Main End=======");
	}
}
