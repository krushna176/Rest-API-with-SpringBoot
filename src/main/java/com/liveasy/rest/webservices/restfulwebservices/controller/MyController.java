package com.liveasy.rest.webservices.restfulwebservices.controller;

import com.liveasy.rest.webservices.restfulwebservices.entities.Load;
import com.liveasy.rest.webservices.restfulwebservices.services.MyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private MyServices myServices;

    @GetMapping("/load")
    public List<Load> getLoads() {
        return this.myServices.getLoads();
    }

    @PostMapping("/load")
    public Load addLoad(@RequestBody Load load) {
        return this.myServices.addLoad(load);
    }
    @GetMapping("/load/LoadId/{LoadId}")
    public Load getLoad(@PathVariable int LoadId){
        return this.myServices.getLoad(LoadId);
    }

    @GetMapping("/load/ShipperId")
    public ResponseEntity<Optional<Load>> getLoadbyShipperId(@RequestParam String ShipperId){
        return this.myServices.getLoadbyShipperId(ShipperId);
    }
    @PutMapping("/load/update/{LoadId}")
    public Load updatedLoad(@PathVariable int LoadId, @RequestBody Load load){
        return this.myServices.updateLoad(LoadId,load);
    }
    @DeleteMapping("/load/delete/{LoadId}")
    public String deleteLoad(@PathVariable int LoadId){
        return this.myServices.deleteLoad(LoadId);
    }
}