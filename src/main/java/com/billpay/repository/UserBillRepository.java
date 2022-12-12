package com.billpay.repository;

import com.billpay.data.UserBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserBillRepository extends JpaRepository<UserBill, Integer> {

    @Query(value = "SELECT u FROM UserBill u WHERE u.userDetails.id=:userId and u.dueAmount is not 0")
    List<UserBill> getUserBillByUserId(@Param("userId") Integer userId);

}
