package domain.user.password;

import org.glassfish.jersey.internal.util.collection.StringIgnoreCaseKeyComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PasswordFactoryTest {

	private static final String GOOD_PASSWORD = "Wint3rIsC0ming!";
	private static final String BAD_PASSWORD = "blabla";
	private PasswordFactory passwordFactory;

	@Mock
	private PasswordPolicy passwordPolicy;

	@BeforeEach
	public void setUp(){
		passwordFactory = new PasswordFactory(passwordPolicy);

	}


	@Test
	public void whenThePasswordRespectPolicies_thenReturnNewPasswordObject() throws Exception {

		Password password = passwordFactory.create(GOOD_PASSWORD);

		String digestCreatedFromFactory = 	password.getPasswordDigest();

		assertTrue(equalPassword(GOOD_PASSWORD,digestCreatedFromFactory));
	}

	@Test
	public void whenThePlainPasswordGivenTOtheFactoryDoesntMatchThePolicies_thenThrowAnException()throws Exception{

		assertThrows(IllegalPasswordFormatException.class,()->{

			passwordFactory.create(BAD_PASSWORD);
		});

	}

	private boolean equalPassword(String plainPassword,String digestedPassword){

		return BCrypt.checkpw(plainPassword,digestedPassword);
	}
}


