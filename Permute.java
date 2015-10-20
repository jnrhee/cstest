package com.example.jrhee.test;

import android.util.Log;

import java.util.Arrays;
import java.util.HashSet;

class Permute {
    private int[] a = {1, 2, 3, 2, 3, 5};
    private int totalCnt, aCnt;

    HashSet<String> hs = new HashSet<String>();

    public void printAllPermute() {
        totalCnt = 0;
        aCnt = 0;
        doPermute(0, a.length - 1);
        Log.v("JOON", "Total = "+totalCnt+"  actual = "+aCnt);
    }

    private void doPermute(int l, int r) {
        if (l >= r) {
            totalCnt++;
            String str = Arrays.toString(a);
            boolean existing = hs.add(str);
            if (!existing) {
                aCnt++;
                Log.v("JOON", Arrays.toString(a));
            }
            return;
        }

        for (int i=l;i<=r;i++) {
            swap(l, i);
            doPermute(l+1, r);
            swap(l, i);
        }
    }

    private void swap(int l, int r) {
        int tmp = a[l];

        a[l] = a[r];
        a[r] = tmp;
    }
}