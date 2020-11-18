package az.lld.splitwise.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class User {

    private final Long id;
    private final String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final Set<Group> groups;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final Set<Bill> bills;

    public User(@NonNull Long id, @NonNull String name) {
        this.id = id;
        this.name = name;
        this.groups = new HashSet<>();
        this.bills = new HashSet<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

}
