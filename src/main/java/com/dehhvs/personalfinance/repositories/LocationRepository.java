package com.dehhvs.personalfinance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dehhvs.personalfinance.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
