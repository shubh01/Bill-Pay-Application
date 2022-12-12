package com.billpay.repository;

import com.billpay.data.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserWalletRepository extends JpaRepository<UserWallet, Integer> {

    @Query(value = "SELECT u FROM UserWallet u WHERE u.userDetails.id=:userId")
    public UserWallet getUserWalletByUserId(@Param("userId") Integer userId);


}
