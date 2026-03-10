package com.patterns.behavioural.chainofresponsibility;

public class ChainOfResponsibilityDemo {

    public String sanctionLoan(int amount) {
        LoanRequestProcessor cashier = new Cashier(new Manager(new BranchManager(null)));
        return cashier.sanctionLoan(amount);
    }

    private static final class Cashier implements LoanRequestProcessor {
        private final LoanRequestProcessor next;

        public Cashier(LoanRequestProcessor next) {
            this.next = next;
        }

        @Override
        public String sanctionLoan(int amount) {
            if (amount < 100) {
                return "Loan sanctioned by " + getClass().getSimpleName();
            }
            return next.sanctionLoan(amount);
        }
    }

    private static final class Manager implements LoanRequestProcessor {
        private final LoanRequestProcessor next;

        public Manager(LoanRequestProcessor next) {
            this.next = next;
        }

        @Override
        public String sanctionLoan(int amount) {
            if (amount < 200) {
                return "Loan sanctioned by " + getClass().getSimpleName();
            }
            return next.sanctionLoan(amount);
        }
    }

    private static final class BranchManager implements LoanRequestProcessor {
        private final LoanRequestProcessor next;

        public BranchManager(LoanRequestProcessor next) {
            this.next = next;
        }


        @Override
        public String sanctionLoan(int amount) {
            return "Loan sanctioned by " + getClass().getSimpleName();
        }
    }

    private interface LoanRequestProcessor {
        String sanctionLoan(int amount);
    }


}
