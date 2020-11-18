package az.lld.splitwise.services.impl;

import az.lld.splitwise.models.BalanceSheet;
import az.lld.splitwise.models.Bill;
import az.lld.splitwise.services.IBalanceService;
import az.lld.splitwise.models.Group;
import az.lld.splitwise.models.User;
import az.lld.splitwise.services.IBillService;
import az.lld.splitwise.services.IGroupService;
import az.lld.splitwise.services.IUserService;

public class BalanceServiceImpl implements IBalanceService {

    private static final IUserService USER_SERVICE = UserServiceImpl.getInstance();
    private static final IGroupService GROUP_SERVICE = GroupServiceImpl.getInstance();
    private static final IBillService BILL_SERVICE = BillServiceImpl.getInstance();

    private static final IBalanceService balanceService = new BalanceServiceImpl();

    private BalanceServiceImpl() {

    }

    @Override
    public double getBalance(Long userId) {
        User user = USER_SERVICE.getUser(userId);
        double totalSettlement = 0;
        for (Group group : user.getGroups()) {
            totalSettlement += getBalanceForGroup(userId, group.getId());
        }
        return totalSettlement;
    }

    @Override
    public double getBalanceForGroup(Long userId, Long groupId) {
        Group group = GROUP_SERVICE.getGroup(groupId);
        double totalSettlement = 0;
        for (Bill bill : group.getBills()) {
            totalSettlement += getBalanceForBill(userId, bill.getId());
        }
        return totalSettlement;
    }

    @Override
    public double getBalanceForBill(Long userId, Long billId) {
        Bill bill = BILL_SERVICE.getBill(billId);
        User user = USER_SERVICE.getUser(userId);
        if (!bill.getContributors().contains(user)) {
            return 0;
        }
        double eachPersonsShare = bill.getAmount() / bill.getContributors().size();
        if (userId.equals(bill.getPaidBy().getId())) {
            return eachPersonsShare - bill.getAmount();
        }
        return eachPersonsShare;
    }

    @Override
    public BalanceSheet getBalanceSheet(Long userId) {
        BalanceSheet balanceSheet = new BalanceSheet(userId);
        User user = USER_SERVICE.getUser(userId);
        double totalBalance = 0;
        for (Group group : user.getGroups()) {
            for (Bill bill : group.getBills()) {
                if (bill.getContributors().contains(user)) {
                    totalBalance += getBalanceForBill(userId, bill.getId());
                    if (bill.getPaidBy().equals(user)) {
                        for (User contributor : bill.getContributors()) {
                            if (!contributor.equals(user)) {
                                balanceSheet.addBalance(contributor.getId(), group.getId(), getBalanceForBill(contributor.getId(), bill.getId()));
                            }
                        }
                    } else {
                        balanceSheet.addBalance(bill.getPaidBy().getId(), group.getId(), getBalanceForBill(user.getId(), bill.getId()));
                    }
                }
            }
        }
        balanceSheet.setTotalBalance(totalBalance);
        return balanceSheet;
    }

    public static IBalanceService getInstance() {
        return balanceService;
    }
}
