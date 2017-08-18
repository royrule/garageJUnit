package com.everis.alicante.becajava.services.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.domain.Client;
import com.everis.alicante.becajava.domain.Parkingplace;
import com.everis.alicante.becajava.domain.Vehicle;
import com.everis.alicante.becajava.interfaces.BookingDAO;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {

	private Booking expectedBooking;

	@Mock
	private EntityManager entityManagerMock;

	@Mock
	private BookingDAO bookingDAOMock;

	private Client expectedClient = new Client();

	private Date expectedBookingDate = new Date();

	private Parkingplace expectedParkingPlace = new Parkingplace();

	private Vehicle expectedVehicle = new Vehicle();

	private BookingServiceImpl bookingServiceImpl;

	@Before
	public void init() {
		this.bookingServiceImpl = new BookingServiceImpl(bookingDAOMock);
		this.expectedBooking = new Booking();
		this.expectedBooking.setBookingdate(expectedBookingDate);
		this.expectedBooking.setClient(expectedClient);
		this.expectedBooking.setParkingplace(expectedParkingPlace);

	}

//	@Test
//	public void testCreate() {
//		// Arrange
//		Mockito.doNothing().when(bookingDAOMock);
//		// Act
//		bookingDAOMock.create(expectedBooking);
//		// Assert
//		Mockito.verify(this.bookingDAOMock, Mockito.times(1)).create(expectedBooking);
//
//	}

	@Test
	public void testList() {
		// Arrange
		List<Booking> bookings = new ArrayList<Booking>();
		Mockito.when(bookingDAOMock.findAll()).thenReturn(bookings);
		// Act
		bookingServiceImpl.list();
		// Assert
		Mockito.verify(this.bookingDAOMock, Mockito.times(1)).findAll();
	}

	@Test
	public void testGetBookingDao() {
		// Act
		final BookingDAO result = this.bookingServiceImpl.getBookingDao();
		// Assert
		Assert.assertEquals(bookingServiceImpl.getBookingDao(), result);
	}

	@Test
	public void testSetBookingDao() {
		// Act
		bookingServiceImpl.setBookingDao(bookingDAOMock);
		// Assert
		Assert.assertEquals(bookingDAOMock, bookingServiceImpl.getBookingDao());

	}

	@Test
	public void testBookingServiceImpl() {
		// Assert
		Assert.assertNotNull(bookingServiceImpl);
	}

}
