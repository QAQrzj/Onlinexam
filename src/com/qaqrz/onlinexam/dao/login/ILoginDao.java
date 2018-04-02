package com.qaqrz.onlinexam.dao.login;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.po.Teacher;

public interface ILoginDao {
	public Teacher canLogin(Teacher t);

	public Student canLogin(Student s);
}