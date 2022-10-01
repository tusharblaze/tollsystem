package com.titanblaze.tollsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TollRecipt {
	private String reciptId;
	private String name;
	private int chargeAmount;
	private String discount;
	private String issueDate;
	private String valiDate;
}
