package domain.user.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.mockito.junit.jupiter.MockitoExtension;
import utility.datamanager.ApplicationConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PasswordPolicyFactoryTest {

	private static final String BASIC_POLICY = "basic";

	private PasswordPolicyFactory passwordPolicyFactory;

	@BeforeEach
	public void setUp(){
		passwordPolicyFactory = new PasswordPolicyFactory();
	}

	@Test
	public void givenAPolicy_whenCreating_ThenReturnABasicPasswordPolicy()throws Exception{

		ApplicationConfiguration.passwordPolicyMode = BASIC_POLICY;

		PasswordPolicy passwordPolicy = passwordPolicyFactory.create(BASIC_POLICY);

		assertTrue(passwordPolicy instanceof BasicPasswordPolicy);
	}

}