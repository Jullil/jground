package org.jground;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        System.out.println("Hellod world!");
        logger.debug("Hello World!!!!!!!!!!!!!!!!!");
    }
}
