package com.m3c.agw;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;


public class App {


    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args ){

        log.info("Logging initialised");

        BinaryTreeImp binaryTreeImp = new BinaryTreeImp();
        Random generator = new Random();
        for (int i = 0; i<10; i++) {
            int num = generator.nextInt(500);
            binaryTreeImp.addElement(num);
        }
        List<Integer> listAscending = binaryTreeImp.getSortedTreeAsc();
        System.out.println(listAscending);

        log.info("Logging finished");
    }
}
