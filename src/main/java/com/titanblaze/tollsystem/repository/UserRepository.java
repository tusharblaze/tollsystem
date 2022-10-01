package com.titanblaze.tollsystem.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.titanblaze.tollsystem.dto.VehicleUserDto;
import com.titanblaze.tollsystem.model.Roles;
import com.titanblaze.tollsystem.model.TollUser;

@Component
public class UserRepository {

	List<TollUser> tollUserList = 
			Arrays.asList(
					new TollUser[] {
							new TollUser("1", "tushar", "anand", "tusharblaze2@orkut.com", "titanblaze", "123", 783645, new ArrayList<Roles>()),
							new TollUser("2", "Abinav", "kumar", "AbinavH@orkut.com", "AbinavKumar", "123", 34234234, new ArrayList<Roles>()),
							new TollUser("3", "Pravas", "kumar", "kumarPravas@orkut.com", "PravasKumar", "123", 32423451, new ArrayList<Roles>()),
							new TollUser("4", "Pawan", "pandey", "Pawan@orkut.com", "PawanPoo", "123", 36324345, new ArrayList<Roles>())
					}
					);
    List<VehicleUserDto> visitedUsers  = new ArrayList<VehicleUserDto>(); 
	public List<TollUser> getAllUserDetails(){
		return tollUserList;
	}
	
	public TollUser getUserDetailByUserNameAndPassword(String userName){
		return tollUserList.stream().filter(e-> e.getUserName().equals(userName)).findAny().get();
	}
	
	public boolean saveVisitedVehicle(VehicleUserDto user) {
		visitedUsers.add(user);
		return true;
	}
}
