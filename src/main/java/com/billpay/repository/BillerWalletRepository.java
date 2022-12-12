package com.billpay.repository;

import com.billpay.data.BillerWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillerWalletRepository extends JpaRepository<BillerWallet, Integer> {

    @Query(value = "SELECT u FROM BillerWallet u WHERE u.billerId.id=:billerId")
    public BillerWallet getBillerWalletByBillerId(@Param("billerId") Integer billerId);


}
