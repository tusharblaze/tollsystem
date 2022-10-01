package com.titanblaze.tollsystem.model;

public enum Vehicle {
	CAR(100),TRUCK(200),SEMI_TRAILER(150),BUS(200);

	private final int value;

	Vehicle(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
