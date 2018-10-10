package utility.datamanager;

public class ApplicationConfiguration {

	/**
	 * Properties files
	 */
	public static  final String PROPERTIES_FILE_NAME = "DanFani.properties";


	/**
	 * Application general properies files
	 */
	public static  String mode;
	public static int serverPort;

	/**
	 * Security properties configuration Password policy : basix Expiration ,
	 * shortterm, longterm
	 */
	public static String tokenExpirationPolicyFromProperties;
	public static int tokenLength;
	public static String passwordPolicyMode;







}
