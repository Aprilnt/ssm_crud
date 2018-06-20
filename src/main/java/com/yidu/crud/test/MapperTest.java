package com.yidu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yidu.crud.bean.Department;
import com.yidu.crud.bean.Employee;
import com.yidu.crud.dao.DepartmentMapper;
import com.yidu.crud.dao.EmployeeMapper;

/**
 * ����dao��
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	/**
	 * ����department
	 */
	@Test
	public void testCRUD(){
		/*//1.����spring��ioc����
		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.�������л�ȡmapper
		DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentMapper);
		//1.���벿��
		
		/*departmentMapper.insertSelective(new Department(null, "������"));
		departmentMapper.insertSelective(new Department(null, "���Բ�"));*/
		
		//2.����Ա��
		//employeeMapper.insertSelective(new Employee(null, "jerry", "M", "jerry@yidu.com", 1));
		//3.����������Ա��:ʹ�ÿ���ִ������������sqlsession
		EmployeeMapper mapper=	sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uid=UUID.randomUUID().toString().substring(0,5);
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@yidu.com", 1));
		}
		System.out.println("ִ�����");
	}
}
