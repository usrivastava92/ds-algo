package com.prep.lld.splitwise.models;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public class BalanceSheet {

  @Getter private final Long userId;
  @Setter @Getter private double totalBalance;
  @Getter private final Map<Long, UserBalance> balanceMap;

  public BalanceSheet(Long userId) {
    this.userId = userId;
    this.balanceMap = new HashMap<>();
  }

  public void addBalance(Long userId, Long groupId, Double balance) {
    UserBalance userBalance = balanceMap.getOrDefault(userId, new UserBalance());
    userBalance.addBalance(groupId, balance);
    balanceMap.put(userId, userBalance);
  }
}
