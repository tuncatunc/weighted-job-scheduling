package com.att;

import java.io.Console;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int w[] = {5, 6, 5, 4, 11, 2};
        int s[] = {1, 2, 4, 6, 5, 7};
        int f[] = {3, 5, 6, 7, 8, 9};
	    WeightedJobScheduling weightedJobScheduling = new WeightedJobScheduling(w, s, f);
	    int maxProfit = weightedJobScheduling.maxProfit();
        System.out.println("maxProfit: "+ maxProfit);
	    List<Integer> maxProfitJobs = weightedJobScheduling.maxProfitJobs();
        System.out.println("Max Profitting Jobs are: ");
        for (Integer j :
                maxProfitJobs) {
            System.out.print(j + " ");
        }
    }
}
