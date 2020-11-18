package az.lld.splitwise.services;

import az.lld.splitwise.models.Bill;
import az.lld.splitwise.models.Group;

import java.util.List;

public interface IGroupService {

    Group createGroup(String name);

    Bill addBill(Long groupId, double amount, String description, Long paidBy);

    Group getGroup(Long id);

    List<Group> getAllGroups();

    void deleteGroup(Long id);

    Group addMember(Long groupId, Long userId);

}
