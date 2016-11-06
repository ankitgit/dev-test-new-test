package com.goeuro.routefinder.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class PlannedRoutes {

    private static List<String> listOfStops;

    @Value("${name}")
    private String filePath;

    public PlannedRoutes() {
        listOfStops = createBusRouteFromFile();
    }


    public List<String> createBusRouteFromFile() {
        List<String> list = new ArrayList<>();
        try {
            Scanner fileIn = new Scanner(new File(this.filePath));
            int numberOfRoutes = Integer.parseInt(fileIn.nextLine());
            while (fileIn.hasNext()) {
                String inputLine = fileIn.nextLine().trim();
                String routeFromLine = inputLine.substring(inputLine.indexOf(" ")).concat(" ");
                list.add(routeFromLine);
            }
            if (list.size() == numberOfRoutes) {
                return list;
            } else {
                return Collections.emptyList();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    public List<String> getListOfStops() {
        return listOfStops;
    }
}
