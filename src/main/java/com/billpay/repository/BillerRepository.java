package com.billpay.repository;

import com.billpay.data.Biller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillerRepository extends JpaRepository<Biller, Integer> {
}
