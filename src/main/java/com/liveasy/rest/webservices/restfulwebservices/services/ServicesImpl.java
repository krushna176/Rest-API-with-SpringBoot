package com.liveasy.rest.webservices.restfulwebservices.services;

import com.liveasy.rest.webservices.restfulwebservices.entities.Load;
import com.liveasy.rest.webservices.restfulwebservices.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesImpl implements MyServices{
    @Autowired
    private Repository repository;
    @Override
    public List<Load> getLoads() {
        return repository.findAll();
    }

    @Override
    public Load addLoad(Load load) {
        try {
            return repository.save(load);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Load getLoad(int LoadId) {
        Optional<Load> load;
        try {
            load = repository.findById(LoadId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Load l=load.get();
        return l;
    }

    @Override
    public ResponseEntity<Optional<Load>> getLoadbyShipperId(String shipperId) {
         ResponseEntity<Optional<Load>> load;
        try {
            load = new ResponseEntity<Optional<Load>>(repository.findByShipperId(shipperId), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return load;
    }

    @Override
    public Load updateLoad(int loadId, Load load) {
        Optional<Load> l;
        try {
            l = repository.findById(loadId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Load load1 = l.get();
        load1.setLoadingPoint(load.getLoadingPoint());
        load1.setComment(load.getComment());
        load1.setDate(load.getDate());
        load1.setProductType(load.getProductType());
        load1.setShipperId(load.getShipperId());
        load1.setNoOfTrucks(load.getNoOfTrucks());
        load1.setTruckType(load.getTruckType());
        load1.setUnloadingPoint(load.getUnloadingPoint());
        load1.setWeight(load.getWeight());

        return repository.save(load1);
    }

    @Override
    public String deleteLoad(int loadId) {
        try {
            repository.findById(loadId).get();
            repository.deleteById(loadId);
            return "Load Deleted Successfully";
        }catch (Exception e){
            return "No user found";
        }
    }
}
