package com.liveasy.rest.webservices.restfulwebservices.services;

import com.liveasy.rest.webservices.restfulwebservices.entities.Load;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MyServices {
    public List<Load> getLoads();

    public Load addLoad(Load load);

    public Load getLoad(int LoadId);

    public ResponseEntity<Optional<Load>> getLoadbyShipperId(String shipperId);

    public Load updateLoad(int loadId, Load load);

    public String deleteLoad(int loadId);
}
