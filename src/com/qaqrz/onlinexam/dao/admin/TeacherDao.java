package com.qaqrz.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao {
	private DBUtil db = new DBUtil();

	@Override
	public List<Teacher> findAllTeacherByInfo(String name) {
		String sql = "select * from teacher";
		if (!"".equals(name))
			sql += " where teacherName like '%" + name + "%'";
		List teacherList = new ArrayList();
		try {
			teacherList = db.getQueryList(sql);
		} catch (Exception e) {
			teacherList = new ArrayList();
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String sql = "insert into teacher(teacherName,pwd) values (?,?)";
		try {
			db.execute(sql, new Object[] { teacher.getTeacherName(), teacher.getPwd() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		String sql = "update teacher set teacherName = ?,pwd = ? where id = ?";
		try {
			db.execute(sql, new Object[] { teacher.getTeacherName(), teacher.getPwd(), oldId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		String sql = "select * from teacher where id = ?";
		Map<String, Object> teacherMap = new HashMap<String, Object>();
		try {
			teacherMap = db.getObject(sql, new Object[] { id });
		} catch (Exception e) {
			teacherMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return teacherMap;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		return null;
	}

	@Override
	public void deleteTeacherById(int classId) {
		String sql = "delete from teacher where id = ?";
		try {
			db.execute(sql, new Object[] { classId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}