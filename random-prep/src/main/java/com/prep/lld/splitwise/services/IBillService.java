package com.prep.lld.splitwise.services;

import com.prep.lld.splitwise.models.Bill;

import java.util.List;

public interface IBillService {

    Bill createBill(double amount, String description, Long paidBy);
    Bill getBill(Long billId);
    List<Bill> getAllBills();
    void deleteBill(Long billId);
    void addMember(Long billId, Long userId);
    List<Bill> getAllBillsForGroup(Long groupId);
    List<Bill> getAllBillsForUser(Long userId);

}
