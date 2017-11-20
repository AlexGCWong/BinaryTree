package com.m3c.agw;

import org.apache.log4j.Logger;

/**
 * Created by alumniCurie02 on 12/10/2017.
 */
public class DuplicatedNode extends Exception{


    private static Logger log = Logger.getLogger(App.class.getName());

    public void printStackTrace(int number){

        log.error(number +" is a Duplicate Node");
//        System.out.println(number +" is a Duplicate Node");
    }

}
