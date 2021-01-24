package com.prep.lld.splitwise.services;

import com.prep.lld.splitwise.models.Bill;
import com.prep.lld.splitwise.models.Group;

import java.util.List;

public interface IGroupService {

    Group createGroup(String name);

    Bill addBill(Long groupId, double amount, String description, Long paidBy);

    Group getGroup(Long id);

    List<Group> getAllGroups();

    void deleteGroup(Long id);

    Group addMember(Long groupId, Long userId);

}
