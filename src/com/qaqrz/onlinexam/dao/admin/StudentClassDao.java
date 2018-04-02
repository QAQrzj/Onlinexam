package com.qaqrz.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.StudentClass;
import com.qaqrz.onlinexam.util.DBUtil;

public class StudentClassDao implements IStudentClassDao {
	private DBUtil db = new DBUtil();

	@Override
	public List<?> findAllStudentClassInfo() {
		String sql = "select * from studentclass";
		List<?> studentClassList = new ArrayList();
		try {
			studentClassList = db.getQueryList(StudentClass.class, sql, new Object[] {});
		} catch (Exception e) {
			studentClassList = new ArrayList();
			e.printStackTrace();
		}
		return studentClassList;
	}

	@Override
	public Map<String, Object> findStudentClassById(int classId) {
		String sql = "select * from studentclass where id = ?";
		Map<String, Object> studentClassMap = new HashMap<String, Object>();
		try {
			studentClassMap = db.getObject(sql, new Object[] { classId });
		} catch (Exception e) {
			studentClassMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return studentClassMap;
	}

	public void deleteStudentClassById(int classId) {
		String sql = "delete from studentclass where id = ?";
		try {
			db.execute(sql, new Object[] { classId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStudentClass(StudentClass sc) {
		String sql = "insert into studentclass(className,deptName) values(?,?)";
		try {
			db.execute(sql, new Object[] { sc.getClassName(), sc.getDeptName() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudentClass(StudentClass sc) {
		String sql = "update studentclass set className = ?,deptName = ? where id = ?";
		try {
			db.execute(sql, new Object[] { sc.getClassName(), sc.getDeptName(), sc.getId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql = "select className from studentclass where id in (" + ids + ")";
		List<Map<String, Object>> nameList = new ArrayList<Map<String, Object>>();
		try {
			nameList = db.getQueryList(sql);
		} catch (Exception e) {
			nameList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nameList.size(); i++) {
			sb.append(nameList.get(i).get("className") + (i < nameList.size() - 1 ? " " : ""));
		}
		return sb.toString();
	}

	@Override
	public List<StudentClass> findStudentClassesByTeacherId(int teacherId) {
		String sql = "select * from studentclass where id in(select classId from teachercourse where teacherId = ?)";
		List<?> studentClassList = new ArrayList<StudentClass>();
		try {
			studentClassList = db.getQueryList(StudentClass.class, sql, new Object[] { teacherId });
		} catch (Exception e) {
			studentClassList = new ArrayList<StudentClass>();
			e.printStackTrace();
		}
		return (List<StudentClass>) studentClassList;
	}

	public static void main(String[] args) {
		IStudentClassDao scd = new StudentClassDao();
		List<?> scList = scd.findAllStudentClassInfo();
		System.out.println(scList);
	}
}