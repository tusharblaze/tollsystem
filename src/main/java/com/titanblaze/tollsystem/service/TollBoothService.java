package com.titanblaze.tollsystem.service;

import com.titanblaze.tollsystem.dto.VehicleUserDto;
import com.titanblaze.tollsystem.model.TollRecipt;

public interface TollBoothService {

	public TollRecipt chargeTollAmount(VehicleUserDto user);
}
