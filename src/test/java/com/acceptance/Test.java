package com.acceptance;

/**
 * @author Abhijeet Gulve
 */
public class Test {
    public static void main(String[] args) {
        int a[] = {-4, 9, 5, -6, -7, -1};
        int max1 = a[0];
        int max2 = a[1];
        for (int i = 2; i < a.length; i++) {
            if (max1 < a[i]) {
                if (max2 < max1) {
                    max2 = max1;
                }
                max1 = a[i];
            } else if (max2 < a[i]) {
                max2 = a[i];
            }
        }
        System.out.println(max1 + " " + max2);
    }
}
