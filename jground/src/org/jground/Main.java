package org.jground;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("conf/log4j.properties");
            logger.info("Starting the system.");

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("Hellod world!");
        logger.debug("Hello World!!!!!!!!!!!!!!!!!");
    }
}
