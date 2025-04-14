package com.github.fabriciolfj.morerecord;

public class Simulation {

    public static void main(String[] args) {
        var resident = new Resident("fabricio", new Doctor("fernando",  "test"));

        var result = cabinetSwitch(resident);

        System.out.println(result);
    }

    private static String cabinet(Staff staff) {
        if (staff instanceof Resident(var name, var dr) && (dr.specialy().equals("Allergy"))) {
            return STR."Cabinet of \{dr.specialy()}. Doctor: \{dr.name()}, Resident: \{name}";
        }

        return "";
    }

    private static String cabinetSwitch(Staff staff) {
        switch (staff) {
            case Doctor(var name, var specialy) -> {
                 return STR."Cabinet of \{specialy}. Doctor: \{name}";
            }
            case Resident(var name, var dr) when (dr.specialy().equals("Allergy") || dr.specialy().equals("test") ) -> {
                return STR."Cabinet of \{dr.specialy()}. Doctor: \{dr.name()}, Resident: \{name}";
            } default -> {
                return "";
            }
        }
    }
}
