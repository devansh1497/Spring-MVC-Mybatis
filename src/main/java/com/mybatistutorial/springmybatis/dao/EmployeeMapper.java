package com.mybatistutorial.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mybatistutorial.springmybatis.model.Employee;
import com.mybatistutorial.springmybatis.util.MyBatisUtil;

@Repository
public class EmployeeMapper {
	
	public List<Employee>  getAllEmployees(){
		SqlSession sqlSession = MyBatisUtil.getSqlSeesionFactory().openSession();
		List<Employee> employees = sqlSession.selectList("getAllEmployees");
		sqlSession.commit();
		sqlSession.close();
		return employees;
	}
	
	public void saveEmployee(Employee employee) {
		SqlSession sqlSession = MyBatisUtil.getSqlSeesionFactory().openSession();
		sqlSession.insert("insertEmployee", employee);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void deleteEmployee(Integer employeeId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSeesionFactory().openSession();
		sqlSession.delete("deleteEmployee", employeeId);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public Employee findById(Integer employeeId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSeesionFactory().openSession();
		Employee employee = (Employee)sqlSession.selectOne("findById", employeeId);
		sqlSession.commit();
		sqlSession.close();
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		SqlSession sqlSession = MyBatisUtil.getSqlSeesionFactory().openSession();
		sqlSession.update("updateEmployee", employee);
		sqlSession.commit();
		sqlSession.close();
	}

}
