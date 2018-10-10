package domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BobFactoryTest {

	private  static final String NAME="bob";
	private static  final int  AGE = 23;
	private static final String ADRESS = "2200 chemin sainte fot";

	private BobFactory bobFactory;
	private Bob bob;

	@BeforeEach
	public void setUp(){
		bobFactory = new BobFactory();
	}

	@Test
	public void test() {

	Bob bobCreatedFromFactory  = 	bobFactory.create(NAME,AGE,ADRESS);

	assertEquals(bobCreatedFromFactory.getName(),NAME);

	Bob bobFromFactory = bobFactory.create(NAME,AGE,ADRESS);

	assertTrue(bobFromFactory instanceof Bob);

	}
}
