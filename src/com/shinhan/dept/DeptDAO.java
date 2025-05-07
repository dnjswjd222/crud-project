package com.shinhan.dept;

import java.sql.*;
import java.util.*;

import com.shinhan.day15.DBUtill;

public class DeptDAO {
	public int deptDelete(int deptid) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = "delete from departments where department_id = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, null);
		}
		return result;
	}
	
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		Map<String, Object> dynamicSQL = new HashMap();
		if(dept.getDepartment_name()!=null) dynamicSQL.put("DEPARTMENT_NAME", dept.getDepartment_name());
		if(dept.getLocation_id()!=null) dynamicSQL.put("LOCATION_ID", dept.getLocation_id());
		if(dept.getManager_id()!=null) dynamicSQL.put("MANAGER_ID", dept.getManager_id());
		
		String sql = "update departments set ";
		String sql2 = " where department_id = ?";
		
		for(String key: dynamicSQL.keySet()) {
			sql += key+"="+"?,";
		}
		sql = sql.substring(0, sql.length()-1);
	 	sql += sql2;
		try {
			st = conn.prepareStatement(sql);
			int i=1;
			for(String key: dynamicSQL.keySet()) {
				st.setObject(i++, dynamicSQL.get(key));
			}
			st.setInt(i, dept.getDepartment_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, null);
		}
		return result;
	}
	
	public int deptInsert(DeptDTO dept) {
		int result = 0;
		Connection conn = DBUtill.getConnection();
		PreparedStatement st = null;
		String sql = "insert into departments values(?,?,?,?)";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			st.setInt(3, dept.getManager_id());
			st.setInt(4, dept.getLocation_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, null);
		}
		return result;
	}
	
	public DeptDTO selectById(int deptid) {
		Connection conn = DBUtill.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where department_id = " + deptid;
		DeptDTO dept = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		return dept;
	}
	
	public List<DeptDTO> selectAll(){
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		Connection conn = DBUtill.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		return deptlist;
	}
	
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = DeptDTO.builder()
				.department_id(rs.getInt("department_id"))
				.department_name(rs.getString("department_name"))
				.location_id(rs.getInt("location_id"))
				.manager_id(rs.getInt("manager_id"))
				.build();
		return dept;
	}
}
