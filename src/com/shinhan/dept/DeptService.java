package com.shinhan.dept;

import java.util.List;

public class DeptService {
	
	DeptDAO deptDAO = new DeptDAO();
	
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);
	}
	
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}
	
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}
	
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}
	
	public List<DeptDTO> selectAll(){
		return deptDAO.selectAll();
	}
}
