package domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserProfileFactoryTest {

	private static final String NAME ="Jordan";
	private static final String LAST_NAME ="Michael";
	private static final String EMAIL = "michaelj@NBA.com";
	private static final String NICKNAME = "TheGoat";

	private UserProfileFactory userProfileFactory;
	private UserProfile userProfile;

	@BeforeEach
	public void setUp(){
		userProfile = new UserProfile(NAME,LAST_NAME,NICKNAME);
		userProfileFactory = new UserProfileFactory();
	}

	@Test
	public void givenParamaters_whenCreating_thenReturnNewUserProfile(){

		UserProfile createdUserProfile =userProfileFactory.create(NAME,LAST_NAME,NICKNAME);

		assertEquals(userProfile.getLastName(),createdUserProfile.getLastName());
	}



}
