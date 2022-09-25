package net.atos.weatherSoap.demo.Repository;

import net.atos.weatherSoap.demo.model.Entity.City;

import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;

@Transactional
public interface CityRepository extends JpaRepository<City,Integer> {

    City findByName(String name);



}
