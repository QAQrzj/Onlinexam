package com.qaqrz.onlinexam.service.login;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.po.Teacher;

public interface ILoginService {

	public Teacher canLogin(Teacher t);

	public Student canLogin(Student t);
}