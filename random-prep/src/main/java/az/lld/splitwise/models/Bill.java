package az.lld.splitwise.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class Bill {

    private final Long id;
    private final Double amount;
    private final String description;
    private final User paidBy;
    @Setter
    private Group group;
    @EqualsAndHashCode.Exclude
    private final Set<User> contributors;

    public Bill(Long id, Double amount, User paidBy, String description) {
        assert id != null : "id can't be null";
        assert description != null : "description can't be null";
        assert amount != null && amount <= 0 : "amount can't be null or negative";
        assert paidBy != null : "paidBy can't be null";
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.contributors = new HashSet<>();
        this.contributors.add(paidBy);
    }

    public void addContributor(User user) {
        assert user != null : "user can't be null";
        contributors.add(user);
    }

}
