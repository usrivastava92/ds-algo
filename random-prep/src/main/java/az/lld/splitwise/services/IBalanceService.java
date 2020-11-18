package az.lld.splitwise.services;

import az.lld.splitwise.models.BalanceSheet;

public interface IBalanceService {

    double getBalance(Long userId);

    double getBalanceForGroup(Long userId, Long groupId);

    double getBalanceForBill(Long userId, Long billId);

    BalanceSheet getBalanceSheet(Long userId);


}
