package domain.user.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BasicPasswordPolicyTest {

	private static final String VALID_LENGTH_PASSWORD = "GOOD_PASSWORD";
	private static final String INVALID_LENGTH_PASSWORD = "Bad";

	private static final String VALID_PATTERN_PASSWORD = "Wint3rIsC0ming!";
	private static final String INVALID_PATTERN_PASSWORD = "bobo";

	private BasicPasswordPolicy basicPasswordPolicy;

	@BeforeEach
	public void setUp(){
		basicPasswordPolicy = new BasicPasswordPolicy();
	}

	@Test
	public void whenPasswordLengthIsGreaterThanRequired_thenReturnTrue(){

		boolean validLength = basicPasswordPolicy.isValidLength(VALID_LENGTH_PASSWORD);

		assertTrue(validLength);
	}

	@Test
	public void whenPasswordLengthIsShorterThanRequired_thenReturnFalse(){

		boolean validLength = basicPasswordPolicy.isValidLength(INVALID_LENGTH_PASSWORD);

		assertFalse(validLength);
	}

	@Test
	public void whenPasswordHaveInvalidPattern_thenReturnTrue(){

		boolean invalidLength = basicPasswordPolicy.isValidPattern(INVALID_PATTERN_PASSWORD);

		assertFalse(invalidLength);
	}

	@Test
	public void whenPasswordHaveValidPattern_thenReturnTrue(){

		boolean validLength = basicPasswordPolicy.isValidPattern(VALID_PATTERN_PASSWORD);

		assertTrue(validLength);
	}

	@Test
	public void whenAllPoliciesAreRespected_thenReturnTrue(){
		boolean valid = basicPasswordPolicy.isValid(VALID_PATTERN_PASSWORD);

		assertTrue(valid);
	}

	@Test
	public void whenAllPoliciesAreNotRespected_thenReturnFalse(){
		boolean valid = basicPasswordPolicy.isValid(INVALID_PATTERN_PASSWORD);

		assertFalse(valid);
	}



}