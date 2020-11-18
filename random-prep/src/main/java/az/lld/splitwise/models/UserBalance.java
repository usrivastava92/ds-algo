package az.lld.splitwise.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

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
