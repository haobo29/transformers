package com.chb.transformers.aop;

public interface UsageTracked {
    public void incrementUseCount();
    public int getCount();
}
