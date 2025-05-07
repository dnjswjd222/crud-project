package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;

import com.shinhan.common.CommonInterface;

public class DeptController implements CommonInterface{
	static Scanner sc = new Scanner(System.in);
	static DeptService deptservice = new DeptService();
	
	public void execute() {
		boolean isstop = false;
		while(!isstop) {
			menuDisplay();
			int job = sc.nextInt();
			switch(job) {
			case 1-> {f_selectAll();}
			case 2-> {f_selectById();}
			case 3-> {f_insert();}
			case 4-> {f_update();}
			case 5-> {f_delete();}
			case 9-> {isstop = true;}
			}
		}
		System.out.println("======작업 종료======");
	}

	private static void f_delete() {
		System.out.print("삭제할 부서ID>>");
		int dept = sc.nextInt();
		DeptDTO exist_dept = deptservice.selectById(dept);
		if(exist_dept == null) {
			DeptView.display("존재하지 않는 부서입니다.");
			return;
		}
		int result = deptservice.deptDelete(dept);
		DeptView.display(result + "건 삭제");
	}

	private static void f_update() {
		System.out.print("수정할 부서ID>>");
		int dept = sc.nextInt();
		DeptDTO exist_dept = deptservice.selectById(dept);
		if(exist_dept == null) {
			DeptView.display("존재하지 않는 부서입니다.");
			return;
		}
		DeptView.display("======존재하는 부서정보입니다.======");
		DeptView.display(exist_dept);
		int result = deptservice.deptUpdate(makeDept2(dept));
		DeptView.display(result + "건 수정");
	}

	private static DeptDTO makeDept2(int dept) {
		System.out.print("department_name>>");
		String deptname = sc.next();
		System.out.print("manager_id>>");
		Integer deptman = sc.nextInt();
		System.out.print("location_id>>");
		Integer deptloc = sc.nextInt();
		
		if(deptname.equals("0")) deptname = null;
		if(deptman == 0) deptman = null;
		if(deptloc == 0) deptloc = null;
		
		DeptDTO deptin = DeptDTO.builder()
				.department_id(dept)
				.department_name(deptname)
				.manager_id(deptman)
				.location_id(deptloc)
				.build();
		return deptin;
	}

	private static void f_insert() {
		System.out.print("신규 부서ID>>");
		int dept = sc.nextInt();
		int result = deptservice.deptInsert(makeDept(dept));
		DeptView.display(result + "건 입력");
	}

	private static DeptDTO makeDept(int dept) {
		System.out.print("department_name>>");
		String deptname = sc.next();
		System.out.print("manager_id>>");
		int deptman = sc.nextInt();
		System.out.print("location_id>>");
		int deptloc = sc.nextInt();
		
		DeptDTO deptin = DeptDTO.builder()
				.department_id(dept)
				.department_name(deptname)
				.manager_id(deptman)
				.location_id(deptloc)
				.build();
		return deptin;
	}

	private static void f_selectById() {
		System.out.print("조회할 부서ID>>");
		int deptid = sc.nextInt();
		DeptDTO dept = deptservice.selectById(deptid);
		DeptView.display(dept);
	}

	private static void f_selectAll() {
		List<DeptDTO> deptlist = deptservice.selectAll();
		DeptView.display(deptlist);
	}

	private static void menuDisplay() {
		System.out.println("---------------------------");
		System.out.println("1.모두조회 2.조회(부서번호) 3.입력 4.수정 5.삭제 9.끝");
		System.out.println("---------------------------");
		System.out.print("작업선택>");
	}
}
