package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.entity.Employee;
import com.nit.repositories.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		EmployeeRepository repository = run.getBean(EmployeeRepository.class);
		// Employee employee = new Employee(220,"Syam",88990.0,"Hyd");
		// bean.save(employee);
		// System.out.println("===========Record Saved========");
		// List<Employee> empName = repository.findByEmpName("Syam");
		// System.out.println(empName);

		// Employee byEmpSal = repository.findByEmpSal(25000.0);
		// System.out.println(byEmpSal);

		// List<Employee> byEmpNameAndEmpSal = repository.findByEmpNameAndEmpSal("Syam",
		// 12000.0);
		// System.out.println(byEmpNameAndEmpSal);

		// List<Employee> byEmpSalIsGreaterThanEqual =
		// repository.findByEmpSalIsGreaterThanEqual(5000.0);
		// System.out.println(byEmpSalIsGreaterThanEqual);

		// Double empSalByEmpName = repository.findEmpSalByEmpName("Syam");
		// System.out.println(empSalByEmpName);

		// Integer count = repository.getCount();
		// System.out.println(count);
		/*
		 * List<Employee> empNameAndEmpAddressByEmpSal =
		 * repository.findByEmpNameAndEmpAddressByEmpSal(25000.0);
		 * 
		 * for(Employee e:empNameAndEmpAddressByEmpSal) {
		 * System.out.println(e.getEmpName()+"   "+e.getEmpAddress()); }
		 * 
		 * empNameAndEmpAddressByEmpSal.forEach(e->System.out.println(e.getEmpName()
		 * +"  "+e.getEmpAddress()));
		 */
		/*
		 * int deleteByEmpID = repository.rfdsgEmpID(101);
		 * System.out.println("Custom Query to delete by id :"+deleteByEmpID);
		 */
		
		/*
		 * Integer insertIntoEmpTbl = repository.insertIntoEmpTbl(333, "Ben", 54090.0,
		 * "Usj"); if(insertIntoEmpTbl>0) {System.out.println("Data inserted");} else
		 * {System.out.println("Data not inserted");}
		 */
		
		Integer updateEmpTblById = repository.updateEmpTblById("Ben10", 34000.0, "USA", 333);
		 if(updateEmpTblById>0) {System.err.println("Data inserted");} else
			 {System.out.println("Data not inserted");}
	}

}
