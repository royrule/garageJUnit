package com.everis.alicante.becajava.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.alicante.becajava.domain.Booking;

@RunWith(MockitoJUnitRunner.class)
public class BookingDAOJPAImplTest {

	private BookingDAOJPAImpl bookingDAO;

	@Mock
	private EntityManager entityManagerMock;

	@Mock
	private EntityTransaction entityTransactionMock;

	@Before
	public void init() {
		this.bookingDAO = new BookingDAOJPAImpl(entityManagerMock);
	}

	@Test
	public void testCreate() {
		// Arrange
		Booking booking = new Booking();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		bookingDAO.create(booking);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).persist(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		// Arrange
		Booking expectedBooking = new Booking();
		Mockito.when(this.entityManagerMock.find(Booking.class, 1)).thenReturn(expectedBooking);
		// Act
		final Booking result = bookingDAO.readById(1);
		// Assert
		Assert.assertEquals(expectedBooking, result);

	}

	@Test
	public void testUpdate() {
		// Arrange
		Booking booking = new Booking();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		bookingDAO.update(booking);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).merge(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();

	}

	@Test
	public void testDelete() {
		// Arrange
		Booking booking = new Booking();

		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		bookingDAO.delete(booking);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).remove(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testBookingDAOJPAImpl() {
		// Assert
		Assert.assertNotNull(entityManagerMock);
	}

	@Test
	public void testFindAll() {
		// Arrange
		List<Booking> expectedBooking = new ArrayList<Booking>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNamedQuery("Booking.findAll")).thenReturn(queryMock);
		// Act
		final List<Booking> result = bookingDAO.findAll();
		// Assert
		Assert.assertEquals(expectedBooking, result);
	}

}
