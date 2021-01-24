package com.prep.lld.splitwise.models;


import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
public class Group {

    private final Long id;
    private final String name;
    @ToString.Exclude
    private final Set<User> members;
    @ToString.Exclude
    private final Set<Bill> bills;


    public Group(Long id, String name) {
        assert id != null : "id can't be null";
        assert name != null : "name can't be null";
        this.id = id;
        this.name = name;
        this.bills = new HashSet<>();
        members = new HashSet<>();
    }

    public void addMember(User user) {
        members.add(user);
    }


    public void addBill(Bill bill) {
        bills.add(bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Group) {
            Group group = (Group) obj;
            return group.getId().equals(this.id) && group.getName().equals(this.name);
        }
        return false;
    }
}
