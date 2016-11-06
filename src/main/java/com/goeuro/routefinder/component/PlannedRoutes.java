package com.goeuro.routefinder.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlannedRoutes implements ApplicationRunner {

    private String filePath;

    /**
     * Here write logic for loading and storing the file in-memory
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> value = args.getOptionValues("some");
        filePath = value.get(0);
    }
}
