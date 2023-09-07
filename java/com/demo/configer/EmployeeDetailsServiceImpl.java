
package com.demo.configer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		  Employee employee  = employeeRepository.getEmployeeByEmailByJpa(username); 
		  System.out.println("employee : "+employee);
		  if(employee==null) {
				throw new UsernameNotFoundException("Could not found user");
			}
		  CustomeEmployeeDetails userDetails = new CustomeEmployeeDetails(employee);
		  System.out.println("userDetails : "+userDetails);
			return 	userDetails;    
	}

}
