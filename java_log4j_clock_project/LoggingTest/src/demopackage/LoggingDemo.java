package demopackage;
import org.apache.logging.log4j.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingDemo {
	
	private static Logger logger =LogManager.getLogger(LoggingDemo.class.getName());
		
	public static void main(String[] args) throws InterruptedException {
		logger.getLevel();
		while (true) {
			
			if(logger.getLevel().toString()=="ERROR") {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
				LocalDateTime now = LocalDateTime.now();  
				System.out.println(dtf.format(now)+":00:00");  
				logger.error(dtf.format(now)+":00:00");
				Thread.sleep(3600000);
			}
			else if(logger.getLevel().toString()=="INFO") {
			
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
				 LocalDateTime now = LocalDateTime.now();  
				 System.out.println(dtf.format(now)+":00"); 
				 logger.info(dtf.format(now)+":00");
				 Thread.sleep(60000);
				
			}
			else if(logger.getLevel().toString()=="DEBUG") {
			
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm.ss");  
				LocalDateTime now = LocalDateTime.now();  
				System.out.println(dtf.format(now)); 
				logger.debug(dtf.format(now));
				Thread.sleep(1000);
			   
				
			}
	

		}
	}

	
	
}


