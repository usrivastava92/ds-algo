package az.lld.splitwise;

import az.lld.splitwise.models.*;
import az.lld.splitwise.services.IBalanceService;
import az.lld.splitwise.services.impl.BalanceServiceImpl;
import az.lld.splitwise.services.IBillService;
import az.lld.splitwise.services.IGroupService;
import az.lld.splitwise.services.IUserService;
import az.lld.splitwise.services.impl.BillServiceImpl;
import az.lld.splitwise.services.impl.GroupServiceImpl;
import az.lld.splitwise.services.impl.UserServiceImpl;
import com.ds.utils.NumberUtils;

import java.util.Map;
import java.util.UUID;
import java.util.stream.LongStream;

public class SplitwiseExecutor {

    private static final IGroupService GROUP_SERVICE = GroupServiceImpl.getInstance();
    private static final IUserService USER_SERVICE = UserServiceImpl.getInstance();
    private static final IBillService BILL_SERVICE = BillServiceImpl.getInstance();
    private static final IBalanceService BALANCE_SERVICE = BalanceServiceImpl.getInstance();

    static {

        long minGroupId = 1;
        long maxGroupId = 3;
        long minUserId = 1;
        long maxUserId = 15;
        long minBillId = 1;
        long maxBillId = 100;
        LongStream.rangeClosed(minGroupId, maxGroupId).forEach(id -> GROUP_SERVICE.createGroup(UUID.randomUUID().toString()));
        LongStream.rangeClosed(minUserId, maxUserId).forEach(id -> {
            User user = USER_SERVICE.createUser(UUID.randomUUID().toString());
            long randomGroupId = NumberUtils.getRandomLong(minGroupId, maxGroupId);
            GROUP_SERVICE.addMember(randomGroupId, user.getId());
        });
        LongStream.rangeClosed(minBillId, maxBillId).forEach(id -> {
            long randomGroupId = NumberUtils.getRandomLong(minGroupId, maxGroupId);
            long randomUserId = NumberUtils.getRandomLong(minUserId, maxUserId);
            while (!GROUP_SERVICE.getGroup(randomGroupId).getMembers().contains(USER_SERVICE.getUser(randomUserId))) {
                randomUserId = NumberUtils.getRandomLong(minUserId, maxUserId);
            }
            double randomAmount = NumberUtils.getRandomDouble(0d, 1000d);
            Bill bill = GROUP_SERVICE.addBill(randomGroupId, randomAmount, "random description", randomUserId);
            for (User user : GROUP_SERVICE.getGroup(randomGroupId).getMembers()) {
                if (NumberUtils.getRandomInt(0, 10) < 3) {
                    BILL_SERVICE.addMember(bill.getId(), user.getId());
                }
            }
        });
    }

    public static void main(String[] args) {

        for (User user : USER_SERVICE.getAllUsers()) {
            BalanceSheet balanceSheet = BALANCE_SERVICE.getBalanceSheet(user.getId());
            System.out.println(user);
            System.out.println("total balance : " + balanceSheet.getTotalBalance());
            for (Map.Entry<Long, UserBalance> balanceEntry : balanceSheet.getBalanceMap().entrySet()) {
                System.out.println("\t from user -> " + USER_SERVICE.getUser(balanceEntry.getKey()));
                for (Map.Entry<Long, Double> entry : balanceEntry.getValue().getSplitDetails().entrySet()) {
                    System.out.println("\t\t from group -> " + GROUP_SERVICE.getGroup(entry.getKey()) + " amount -> " + entry.getValue());
                }
            }
        }

    }

}
