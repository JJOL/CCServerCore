package io.ccserver.ccsc.utils;

/**
 * Created by JJOL on 17/08/2015.
 */
public class MathUtils {

    public static double max(double... nums) {
        double max = nums[0];
        for(double num : nums) {
            if(num > max) {
                max = num;
            }
        }

        return max;
    }
}
