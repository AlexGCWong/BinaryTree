package com.m3c.agw;

import org.apache.log4j.Logger;

/**
 * Created by keith.dauris on 04/06/2017.
 */
public class LoggingExample {

    private String message;
    private Logger log = Logger.getLogger(LoggingExample.class.getName());


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
