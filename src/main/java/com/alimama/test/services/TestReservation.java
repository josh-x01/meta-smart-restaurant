package com.alimama.test.services;

import com.alimama.data_util.servicesManager.ReservationDataUtil;
import com.alimama.services.Reservation;

public class TestReservation {

	public static void main(String[] args) {
		
		System.out.println("\n\nChecking orderReservation method");
		new ReservationDataUtil().orderReservation(
			new Reservation(1, 1, 3, 1)
		);
		
		System.out.println("\n\nChecking cancelReservation method");
		new ReservationDataUtil().cancelReservation(3);
	}

}
