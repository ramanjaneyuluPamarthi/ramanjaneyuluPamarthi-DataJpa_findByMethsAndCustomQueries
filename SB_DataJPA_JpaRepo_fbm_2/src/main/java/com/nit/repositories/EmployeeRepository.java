package com.nit.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nit.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Serializable>
{ 
	
	public  List<Employee> findByEmpName(String name);
	
	public Employee findByEmpSal(Double sal);
	
	public List<Employee> findByEmpNameAndEmpSal(String name, Double sal);
	
	public List<Employee> findByEmpSalIsGreaterThanEqual(Double sal);
	
	@Query("select empSal from Employee where empName=:name")   // JPQL(Java Persistance Query Language) Query
	public  Double findEmpSalByEmpName(String name);
	
	@Query(value ="select count(*) from emp_tbl", nativeQuery = true)        //SQL query
	public Integer getCount();
	
	
	//  @Query(value = "SELECT * FROM EMP_TBL WHERE EMP_SAL = :sal", nativeQuery =true) 
	//  public List<Employee> findByEmpNameAndEmpAddressByEmpSal(@Param("sal")Double sal);
	 
	@Query(value = "SELECT EMP_ID,EMP_NAME,EMP_SAL,EMP_ADDRESS FROM EMP_TBL WHERE EMP_SAL = :sal", nativeQuery = true)
	public List<Employee> findByEmpNameAndEmpAddressByEmpSal(@Param("sal") Double sal);
	@Transactional
	@Modifying
	@Query("Delete from Employee where empId =:id")
	public Integer rfdsgEmpID(Integer id);
	
	@Transactional
	@Modifying
	@Query(value= "insert into EMP_TBL values (:id,:name,:sal,:address)",nativeQuery=true)
	public Integer insertIntoEmpTbl(Integer id, String name, Double sal, String address);
	
	@Transactional
	@Modifying
	@Query(value="update EMP_TBL set EMP_NAME =:name, EMP_SAL =:sal, EMP_ADDRESS =:address where EMP_ID =:id ",nativeQuery=true)
	public Integer updateEmpTblById(String name,Double sal,String address,Integer id);
	


}
