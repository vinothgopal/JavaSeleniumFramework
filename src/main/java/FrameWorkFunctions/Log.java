package FrameWorkFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

    static{
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    System.setProperty("current.date.time", dateFormat.format(new Date()));
}

static Logger logger = Logger.getLogger(Log.class); 
public Log(){
	DOMConfigurator.configure("log4j.xml"); 
}
//DOMConfigurator.configure("log4j.xml"); 
public  void debug(String debug){
	
        logger.debug(debug);  
     
    
}  
public  void warn(String warn){
	
    //DOMConfigurator.configure("log4j.xml");  
    logger.debug(warn);  
     
    
}  
public  void ingo(String info){
	
    //DOMConfigurator.configure("log4j.xml");  
    logger.info(info);  
    
    
} 
public  void error(String error){
	
    //DOMConfigurator.configure("log4j.xml");  
    
    logger.error(error);  
    
    
}  
public  void fatal(String fatal){
	
    //DOMConfigurator.configure("log4j.xml");  
     
    logger.fatal(fatal);  
    
}  

}  
