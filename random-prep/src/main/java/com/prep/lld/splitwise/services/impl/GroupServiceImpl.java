package com.prep.lld.splitwise.services.impl;

import com.prep.lld.splitwise.models.Bill;
import com.prep.lld.splitwise.models.Group;
import com.prep.lld.splitwise.models.User;
import com.prep.lld.splitwise.services.IBillService;
import com.prep.lld.splitwise.services.IGroupService;
import com.prep.lld.splitwise.services.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupServiceImpl implements IGroupService {

    private static final Map<Long, Group> GROUP_MAP = new HashMap<>();
    private static long id = 1;
    private static final IUserService USER_SERVICE = UserServiceImpl.getInstance();
    private static final IBillService BILL_SERVICE = BillServiceImpl.getInstance();

    private static final GroupServiceImpl groupService = new GroupServiceImpl();

    private GroupServiceImpl() {

    }

    @Override
    public Group createGroup(String name) {
        Group group = new Group(id++, name);
        GROUP_MAP.put(group.getId(), group);
        return group;
    }

    @Override
    public Bill addBill(Long groupId, double amount, String description, Long paidBy) {
        Bill bill = BILL_SERVICE.createBill(amount, description, paidBy);
        User user = USER_SERVICE.getUser(paidBy);
        Group group = getGroup(groupId);
        if (group.getMembers().contains(user)) {
            bill.setGroup(getGroup(groupId));
            user.addBill(bill);
            group.addBill(bill);
            return bill;
        }
        return null;
    }

    @Override
    public Group getGroup(Long id) {
        return GROUP_MAP.get(id);
    }

    @Override
    public List<Group> getAllGroups() {
        return new ArrayList<>(GROUP_MAP.values());
    }

    @Override
    public void deleteGroup(Long id) {
        GROUP_MAP.remove(id);
    }

    @Override
    public Group addMember(Long groupId, Long userId) {
        if (!GROUP_MAP.containsKey(groupId)) {
            return null;
        }
        Group group = GROUP_MAP.get(groupId);
        User user = USER_SERVICE.getUser(userId);
        user.addGroup(group);
        group.addMember(user);
        return group;
    }

    public static IGroupService getInstance() {
        return groupService;
    }

}
