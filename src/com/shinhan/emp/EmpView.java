package com.shinhan.emp;

import java.util.List;

public class EmpView {
	//여러건출력
	public static void display(List<EmpDTO> emplist) {
		if(emplist.size() == 0) {
			display("해당하는 직원이 존재하지않습니다.");
			return;
		}
		System.out.println("====직원 여러건 조회====");
		emplist.stream().forEach(emp -> System.out.println(emp));
	}
	
	public static void display (EmpDTO emp) {
		if(emp == null) {
			display("해당하는 직원이 존재하지않습니다");
			return;
		}
		System.out.println("직원정보: " + emp);
	}
	
	public static void display (String message) {
		System.out.println("알림: " + message);
	}
}
