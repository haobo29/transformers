package com.chb.transformers.aop;

public class DefaultUsageTracked implements UsageTracked {
    int count;
    @Override
    public void incrementUseCount() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
