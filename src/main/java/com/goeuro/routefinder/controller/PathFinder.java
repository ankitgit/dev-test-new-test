package com.goeuro.routefinder.controller;

import com.goeuro.routefinder.component.DirectRouteExistInfo;
import org.springframework.web.bind.annotation.*;

@RestController
public class PathFinder {

    @RequestMapping(value = "/api/direct", method = RequestMethod.GET)
    public @ResponseBody DirectRouteExistInfo existsDirectRoute(@RequestParam(value = "dep_sid") int departureStationId,
                                                  @RequestParam(value = "arr_sid") int arrivalStationId) {
        return new DirectRouteExistInfo(departureStationId, arrivalStationId, false);

    }
}
