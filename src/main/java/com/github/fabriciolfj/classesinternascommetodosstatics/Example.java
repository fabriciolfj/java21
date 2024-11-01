package com.github.fabriciolfj.classesinternascommetodosstatics;

public class Example {

    Print printer = new Print() {

        @Override
        public void print(String quality) {
            if (quality.equals("high")) {
                enableLaserGuidance();
            }
            System.out.print("Printing your photos");
        }

        private static void enableLaserGuidance() {
            System.out.print("Adding laser guidance");
        }
    };
}
