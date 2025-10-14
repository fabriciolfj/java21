package com.github.fabriciolfj.pesquisabinaria;

public class Simulacao {

    static void main() {
        int[] values = {1, 3, 4, 5, 7, 9};
        var result = search(values, 3);

        System.out.println(result);
    }

    private static int search(int[] values, int value) {
        int low = 0;
        int high = values.length -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int found = values[mid];

            if (value == found) {
                return mid;
            } else if (high > found) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
