package com.qaqrz.onlinexam.service.login;

import com.qaqrz.onlinexam.dao.login.ILoginDao;
import com.qaqrz.onlinexam.dao.login.LoginDao;
import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.po.Teacher;

public class LoginService implements ILoginService {
	private ILoginDao ld = new LoginDao();

	@Override
	public Teacher canLogin(Teacher t) {
		return ld.canLogin(t);
	}

	@Override
	public Student canLogin(Student t) {
		return ld.canLogin(t);
	}
}