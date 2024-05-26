package com.example.esercizio_unit_test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.esercizio_unit_test.controllers.UserController;
import com.example.esercizio_unit_test.entities.User;
import com.example.esercizio_unit_test.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserControllerTests {

	@Mock
	private UserService userServiceMock;

	@InjectMocks
	private UserController userController;

	private User testUser;

	@BeforeEach //setUp(): Inizializzo il testUser che sarà utilizzato in tutti i test.
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		testUser = new User(1L, "Davide", "Tatone", "davidetat@example.com");
	}

	@Test // Verifica che il controller restituisca correttamente una lista di utenti.
	public void testGetAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(testUser);

		when(userServiceMock.getAllUsers()).thenReturn(userList);

		List<User> result = userController.getAllUser();

		assertEquals(1, result.size());
		assertEquals(testUser, result.get(0));
	}

	@Test //Verifica che il controller restituisca correttamente un utente per un dato ID.
	public void testGetUserById() {
		when(userServiceMock.getUserById(1L)).thenReturn(Optional.of(testUser));

		ResponseEntity<User> responseEntity = userController.getUserById(1L);

		assertEquals(testUser, responseEntity.getBody());
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test // Verifica che il controller gestisca  il caso in cui l'utente con l'ID cercato
	      // non viene trovato.
	public void testGetUserById_UserNotFound() {
		when(userServiceMock.getUserById(2L)).thenReturn(Optional.empty());

		ResponseEntity<User> responseEntity = userController.getUserById(2L);

		assertEquals(404, responseEntity.getStatusCodeValue());
	}

	@Test //Verifica che il controller crei un nuovo utente.
	public void testCreateUser() {
		when(userServiceMock.createUser(testUser)).thenReturn(testUser);

		ResponseEntity<User> responseEntity = userController.createUser(testUser);

		assertEquals(testUser, responseEntity.getBody());
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test // Verifica che il controller aggiorni correttamente un utente esistente.
	public void testUpdateUser() {
		when(userServiceMock.updateUser(1L, testUser)).thenReturn(Optional.of(testUser));

		ResponseEntity<User> responseEntity = userController.updateUser(1L, testUser);

		assertEquals(testUser, responseEntity.getBody());
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test // Verifica che il controller gestisca  il caso in cui l'utente da aggiornare non viene trovato.
	public void testUpdateUser_UserNotFound() {
		when(userServiceMock.updateUser(2L, testUser)).thenReturn(Optional.empty());

		ResponseEntity<User> responseEntity = userController.updateUser(2L, testUser);

		assertEquals(404, responseEntity.getStatusCodeValue());
	}

	@Test //Verifica che il controller cancelli correttamente un utente esistente.
	public void testDeleteUser() {
		when(userServiceMock.deleteUser(1L)).thenReturn(true);

		ResponseEntity<Void> responseEntity = userController.deleteUser(1L);

		assertEquals(204, responseEntity.getStatusCodeValue());
	}

	@Test // Verifica che il metodo deleteUser restituisca un 404 se l'utente da eliminare non esiste.
	public void testDeleteUser_UserNotFound() {
		when(userServiceMock.deleteUser(2L)).thenReturn(false);

		ResponseEntity<Void> responseEntity = userController.deleteUser(2L);

		assertEquals(404, responseEntity.getStatusCodeValue());
	}
}
