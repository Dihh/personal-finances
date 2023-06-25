package com.dehhvs.personalfinance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dehhvs.personalfinance.models.Spending;

public interface SpendingRepository extends JpaRepository<Spending, Integer> {

}
