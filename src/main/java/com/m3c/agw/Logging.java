package com.m3c.agw;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by alumniCurie02 on 12/10/2017.
 */
public class Logging {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(Logging.class.getName());

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.info("Logging initialised");
    }

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        log.trace("Message set");
    }

    public void displayMessage() {
        System.out.println(message);
        log.debug("Message Printed - " + message);
    }

    public void deleteMessage() {

    }
}
