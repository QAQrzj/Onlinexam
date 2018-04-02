<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="height: 20px;"></div>
<script>
	$('.ui.dropdown').dropdown({
		keepOnScreen : true
	});
	$('.ui.radio.checkbox').checkbox();
	$('.ui.checkbox').checkbox();
	$(document).ready(function() {
		$('.ui.form').form({
			fields : {
				username : {
					identifier : 'username',
					rules : [ {
						type : 'empty',
						prompt : '请输入用户名'
					} ]
				},
				studentname : {
					identifier : 'studentname',
					rules : [ {
						type : 'empty',
						prompt : '请输入姓名'
					} ]
				},
				teachername : {
					identifier : 'teachername',
					rules : [ {
						type : 'empty',
						prompt : '请输入姓名'
					} ]
				},
				teacherid : {
					identifier : 'teacherid',
					rules : [ {
						type : 'empty',
						prompt : '请选择教师'
					} ]
				},
				password : {
					identifier : 'password',
					rules : [ {
						type : 'empty',
						prompt : '请输入密码'
					} ]
				},
				school : {
					identifier : 'school',
					rules : [ {
						type : 'empty',
						prompt : '请输入学院'
					} ]
				},
				born : {
					identifier : 'born',
					rules : [ {
						type : 'empty',
						prompt : '请输入出生日期'
					} ]
				},
				coursename : {
					identifier : 'coursename',
					rules : [ {
						type : 'empty',
						prompt : '请输入课程名称'
					} ]
				},
				courseid : {
					identifier : 'courseid',
					rules : [ {
						type : 'empty',
						prompt : '请选择科目'
					} ]
				},
				classname : {
					identifier : 'classname',
					rules : [ {
						type : 'empty',
						prompt : '请输入班级名称'
					} ]
				},
				classid : {
					identifier : 'classid',
					rules : [ {
						type : 'empty',
						prompt : '请选择班级'
					} ]
				},
				deptname : {
					identifier : 'deptname',
					rules : [ {
						type : 'empty',
						prompt : '请选择所属方向'
					} ]
				},
				role : {
					identifier : 'role',
					rules : [ {
						type : 'empty',
						prompt : '请选择角色'
					} ]
				},
				queType : {
					identifier : 'queType',
					rules : [ {
						type : 'empty',
						prompt : '请选择试题类型'
					} ]
				},
				queTitle : {
					identifier : 'queTitle',
					rules : [ {
						type : 'empty',
						prompt : '请输入题目'
					} ]
				},
				choiceA : {
					identifier : 'choiceA',
					rules : [ {
						type : 'empty',
						prompt : '请输入选项A'
					} ]
				},
				choiceB : {
					identifier : 'choiceB',
					rules : [ {
						type : 'empty',
						prompt : '请输入选项B'
					} ]
				},
				choiceC : {
					identifier : 'choiceC',
					rules : [ {
						type : 'empty',
						prompt : '请输入选项C'
					} ]
				},
				choiceD : {
					identifier : 'choiceD',
					rules : [ {
						type : 'empty',
						prompt : '请输入选项D'
					} ]
				},
				ans : {
					identifier : 'ans',
					rules : [ {
						type : 'empty',
						prompt : '请输入答案'
					}, {
						type : 'regExp[/^[A-D]{1}$/]',
						prompt : '答案必须为"A","B","C","D"中的一种'
					} ]
				},
				testname : {
					identifier : 'testname',
					rules : [ {
						type : 'empty',
						prompt : '请输入试卷名称'
					} ]
				},
				testcourseid : {
					identifier : 'testcourseid',
					rules : [ {
						type : 'empty',
						prompt : '请选择考试科目'
					} ]
				},
				classcheck : {
					identifier : 'classcheck',
					rules : [ {
						type : 'checked',
						prompt : '请选择考试班级'
					} ]
				},
				enddate : {
					identifier : 'enddate',
					rules : [ {
						type : 'empty',
						prompt : '请输入截止时间'
					} ]
				},
				testtime : {
					identifier : 'testtime',
					rules : [ {
						type : 'empty',
						prompt : '请输入考试时长'
					}, {
						type : 'integer[1..1439]',
						prompt : '考试时长必须为整数且范围为[1,1440)'
					} ]
				},
				sinscores : {
					identifier : 'sinscores',
					rules : [ {
						type : 'empty',
						prompt : '请输入总分'
					}, {
						type : 'integer[1..]',
						prompt : '总分必须为正整数'
					} ]
				},
				sinnum : {
					identifier : 'sinnum',
					rules : [ {
						type : 'empty',
						prompt : '请输入题目数量'
					}, {
						type : 'integer[1..]',
						prompt : '题目数量必须为正整数'
					} ]
				}
			}
		});
	});
</script>