package domain.user.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PasswordTest {

	private static final String A_PASSWORD ="JohnCena33";

	private Password password;
	private Password anotherPassword;

	@BeforeEach
	public void setUp(){
		anotherPassword = new Password();
		password = new Password(A_PASSWORD);
	}

	@Test
	public void whenDigestingAClearPassword_thenItGetsCryptedAndDifferent()throws Exception{

		String digestedPassword = password.getPasswordDigest();

		assertNotEquals(A_PASSWORD,digestedPassword);

	}

	@Test
	public void whenASavedPasswordIsDifferent_thenThrowMismatchedPasswordException()throws Exception{

		String differentPassword = "TheRock45";

		assertThrows(MismatchedPasswordException.class,()->{

			password.verify(differentPassword);

		});
	}
}