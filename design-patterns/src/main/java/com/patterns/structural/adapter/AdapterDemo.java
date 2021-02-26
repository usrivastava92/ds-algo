package com.patterns.structural.adapter;

import lombok.Getter;
import lombok.ToString;

public class AdapterDemo {

    public static void main(String[] args) {
        System.out.println(new NewCodeAdapter(new LegacyCode(1, "utkarsh")));
    }

    private interface NewCode {
        int getId();

        String getName();
    }

    @Getter
    @ToString
    private static final class LegacyCode {

        private final int serialNumber;
        private final String displayName;

        public LegacyCode(int serialNumber, String displayName) {
            this.serialNumber = serialNumber;
            this.displayName = displayName;
        }

    }

    @ToString
    private static final class NewCodeAdapter implements NewCode {

        private final LegacyCode legacyCode;

        public NewCodeAdapter(LegacyCode legacyCode) {
            this.legacyCode = legacyCode;
        }

        @Override
        public int getId() {
            return legacyCode.getSerialNumber();
        }

        @Override
        public String getName() {
            return legacyCode.getDisplayName();
        }

    }


}
