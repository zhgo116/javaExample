package cn.fancy.design.patterns.bridge.v4;

public class WildGift extends Gift {
    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }
}
