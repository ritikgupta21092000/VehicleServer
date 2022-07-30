package com.lti;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.PersonalDetailsDao;
import com.lti.dao.PersonalDetailsDaoImpl;
import com.lti.dao.UserDao;
import com.lti.dao.UserDaoImpl;
import com.lti.dao.VehicleDao;
import com.lti.dao.VehicleDaoImpl;
import com.lti.entity.PersonalDetails;
import com.lti.entity.User;
import com.lti.entity.Vehicles;

@SpringBootTest
class VehicleLoanApplicationTests {
	UserDao dao1 =new UserDaoImpl();
	PersonalDetailsDao dao2=new PersonalDetailsDaoImpl();
	@Test
	public void addOrUpdateUser() {
		User u1 =dao1.finduserById(1002);
		System.out.println(u1);
		PersonalDetails personalDetails= new PersonalDetails();
		personalDetails.setFirstName("karthik");
		personalDetails.setAge(21);
		personalDetails.setGender("male");
		personalDetails.setMobileNo("8939233576");
		personalDetails.setEmail("karthik@gmail.com");
		personalDetails.setAddress("16/31 Chennai/Tamil Nadu");
		personalDetails.setState("TamilNadu");
		personalDetails.setCity("Chennai");
		personalDetails.setPincode("600023");
		personalDetails.setUser(u1);
		PersonalDetails p1=dao2.addPersonalDetails(personalDetails);
		assertNotNull(p1);
		
	}
	
	
	
	@Test
	public void adduser() {
		User user=new User();
		user.setFirstName("vikram");
		user.setEmail("vikram@gmail.com");
		user.setMobileNo("8934725");
		user.setPassword("vikram123");
		user.setLastName("lal");
		user.setAdmin(false);
			
	}
	
	@Test
	public void finduser() {
		User u1 =dao1.finduserById(1002);
		assertNotNull(u1);
//		PersonalDetails personalDetails= new PersonalDetails();
//		personalDetails.setFirstName(user.getFirstName());				
	}
}
