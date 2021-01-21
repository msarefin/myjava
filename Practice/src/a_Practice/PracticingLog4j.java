package a_Practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PracticingLog4j {

	private static Logger log = LogManager.getLogger(PracticingLog4j.class);
	public static void main(String[] args) {
		
		System.out.println("Hello");
		log.info("This is Information message");
		log.error("This i san error Message");
		log.warn("This ia warning message");
		log.fatal("Thisi s a fatal message");
	}
}
