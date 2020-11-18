package az.lld.splitwise.services.impl;

import az.lld.splitwise.models.Bill;
import az.lld.splitwise.services.IBillService;
import az.lld.splitwise.services.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BillServiceImpl implements IBillService {

    private static final IBillService billService = new BillServiceImpl();
    private static final IUserService USER_SERVICE = UserServiceImpl.getInstance();
    private static long id = 1;
    private static final Map<Long, Bill> BILL_MAP = new HashMap<>();

    private BillServiceImpl() {
    }

    @Override
    public Bill createBill(double amount, String description, Long paidBy) {
        Bill bill = new Bill(id++, amount, USER_SERVICE.getUser(paidBy), description);
        BILL_MAP.put(bill.getId(), bill);
        return bill;
    }

    @Override
    public Bill getBill(Long billId) {
        return BILL_MAP.get(billId);
    }

    @Override
    public List<Bill> getAllBills() {
        return new ArrayList<>(BILL_MAP.values());
    }

    @Override
    public void deleteBill(Long billId) {
        BILL_MAP.remove(billId);
    }


    @Override
    public void addMember(Long billId, Long userId) {
        BILL_MAP.get(billId).addContributor(USER_SERVICE.getUser(userId));
    }

    @Override
    public List<Bill> getAllBillsForGroup(Long groupId) {
        return BILL_MAP.values().stream().filter(bill -> bill.getGroup().getId().equals(groupId)).collect(Collectors.toList());
    }

    @Override
    public List<Bill> getAllBillsForUser(Long userId) {
        return BILL_MAP.values().stream().filter(bill -> bill.getPaidBy().getId().equals(userId)).collect(Collectors.toList());
    }

    public static IBillService getInstance() {
        return billService;
    }

}
