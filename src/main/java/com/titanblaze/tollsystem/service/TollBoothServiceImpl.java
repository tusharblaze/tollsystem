package com.titanblaze.tollsystem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titanblaze.tollsystem.dto.VehicleUserDto;
import com.titanblaze.tollsystem.model.TollRecipt;
import com.titanblaze.tollsystem.repository.UserRepository;

@Service
public class TollBoothServiceImpl implements TollBoothService{

	private static final int EXTENDED_TIME = 2000;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public TollRecipt chargeTollAmount(VehicleUserDto user) {
		TollRecipt recipt = new TollRecipt();
		String reciptId = String.valueOf(Math.random());
		recipt.setReciptId(reciptId);
		recipt.setName(user.getFirstName() +" "+ user.getLastName());
		recipt.setIssueDate(new Date(System.currentTimeMillis()).toString());
		recipt.setValiDate(new Date(System.currentTimeMillis() * EXTENDED_TIME * 10000).toString());
		if(user.getVehicle().getValue() > 0) {
			recipt.setChargeAmount(user.getVehicle().getValue() * 10);
		}
		recipt.setChargeAmount(0);
		user.setReciptId(reciptId);
		userRepo.saveVisitedVehicle(user);
		return recipt;
	}
	
	
}
