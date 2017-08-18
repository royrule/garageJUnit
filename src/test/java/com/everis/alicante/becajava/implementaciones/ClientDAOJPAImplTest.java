package com.everis.alicante.becajava.implementaciones;

import static org.junit.Assert.fail;

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
import com.everis.alicante.becajava.domain.Client;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOJPAImplTest {

	private ClientDAOJPAImpl clientDAO;

	@Mock
	private EntityManager entityManagerMock;

	@Mock
	private EntityTransaction entityTransactionMock;

	@Before
	public void init() {
		this.clientDAO = new ClientDAOJPAImpl(entityManagerMock);
	}

	@Test
	public void testCreate() {
		// Arrange
		Client client = new Client();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		clientDAO.create(client);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).persist(client);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		// Arrange
		Client expectedClient = new Client();
		Mockito.when(this.entityManagerMock.find(Client.class, 1)).thenReturn(expectedClient);
		// Act
		final Client result = clientDAO.readById(1);
		// Assert
		Assert.assertEquals(expectedClient, result);
	}

	@Test
	public void testUpdate() {
		// Arrange
		Client client = new Client();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		clientDAO.update(client);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).merge(client);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		// Arrange
		Client client = new Client();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		clientDAO.delete(client);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).remove(client);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testClientDAOJPAImpl() {
		// Assert
		Assert.assertNotNull(entityManagerMock);
	}

	@Test
	public void testFindAll() {
		// Arrange
		List<Client> expectedClient = new ArrayList<Client>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNamedQuery("Client.findAll")).thenReturn(queryMock);
		// Act
		final List<Client> result = clientDAO.findAll();
		// Assert
		Assert.assertEquals(expectedClient, result);
	}

	@Test
	public void testFindImporteByClient() {
		// Arrange
		Client expectedClient = new Client();
		expectedClient.setName("juan");
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNativeQuery(Mockito.anyString())).thenReturn(queryMock);
		Mockito.when(queryMock.getSingleResult()).thenReturn(2d);
		// Act
		final double result = clientDAO.findImporteByClient(expectedClient);
		// Assert
		Assert.assertEquals(2d, result, 0);
		Mockito.verify(queryMock, Mockito.times(1)).setParameter(1, "juan");
	}

}
