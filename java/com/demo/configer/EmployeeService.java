//package com.demo.configer;
//
//import java.util.Iterator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import com.demo.model.Employee;
//import com.demo.repository.EmployeeRepository;
//
//@Service
//public class EmployeeService implements UserDetailsService {
//	
//	@Autowired
//	EmployeeRepository employeeRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		 System.out.println("In loadUserByUsername");
//		 Employee employee = employeeRepository.getEmployeeByEmployeeName(username);
//		 System.out.println(employee);
//		 if(employee==null) {
//				throw new UsernameNotFoundException("Could not found user");
//		 }
//		 	CustomeEmployeeDetails userDetails = new CustomeEmployeeDetails(employee);
//		
//		 	 System.out.println(" userDetails @@@ "+userDetails.getUsername() +" "+userDetails.getPassword());
//		 	 
//		 	System.out.println("size : "+userDetails.getAuthorities().size());
//		 	 
//			/*
//			 * while (itr.hasNext()) { System.out.println("roles : "+itr.next().toString());
//			 * 
//			 * }
//			 */
//
//		return userDetails;
//	}
//
//}
