package com.prep.lld.splitwise.models;

import java.util.HashMap;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class UserBalance {

  private double totalBalance;
  private final Map<Long, Double> splitDetails;

  public UserBalance() {
    splitDetails = new HashMap<>();
  }

  public void addBalance(Long groupId, Double amount) {
    totalBalance += amount;
    splitDetails.put(groupId, amount);
  }
}
