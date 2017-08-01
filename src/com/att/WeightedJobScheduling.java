package com.att;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tunca on 01/08/2017.
 */
public class WeightedJobScheduling {
    private final int[] w;
    private final int[] s;
    private final int[] f;
    private HashMap<Integer, List<Integer>> listOfJobs;
    private int[] maxIndices;
    private int maxProfitIndex;

    public WeightedJobScheduling(int[] w, int[] s, int[] f) {
        this.w = w;
        this.s = s;
        this.f = f;
        this.maxIndices = new int[w.length]; // Indices with max profit
        Arrays.fill(this.maxIndices, -1);
    }

    public int maxProfit(){
        int max = Integer.MIN_VALUE;
        int[] T = w.clone();

        for (int i = 1; i < w.length; i++){
            for(int j = i - 1; j >=0; j--){
                if (!overlap(i, j)){
                    if (T[i] < T[j] + w[i]){
                        this.maxIndices[i] = j; // Job i done with Job j has max profit
                    }

                    T[i] = java.lang.Math.max(T[i], T[j] + w[i]);

                    // Index of T[i] where max profit is achieved
                    if (max < T[i]){
                        maxProfitIndex = i;
                    }
                    max = java.lang.Math.max(max, T[i]);
                }
            }
        }
        return max;
    }

    public List<Integer> maxProfitJobs(){
        List<Integer> maxProfitList = new ArrayList<Integer>();
        // Starting from max profit index backtrace all jobs

        maxProfitList.add(this.maxProfitIndex);
        int next = this.maxIndices[this.maxProfitIndex];
        while(true){
            if(next == -1) break;
            maxProfitList.add(next);
            next = this.maxIndices[next];
        }
        return maxProfitList;
    }

    private boolean overlap(int i, int j){
        boolean overlap = this.f[j] > this.s[i];
        return overlap;
    }
}
