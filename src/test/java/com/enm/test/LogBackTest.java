package com.enm.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

@Slf4j
public class LogBackTest {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Test
    void logTest(){
        log.trace(log.getName()+" : trace test");
        log.debug("debug test");
        log.info("info test");
        log.warn("warn test");
        log.error("error test");

    }
}
