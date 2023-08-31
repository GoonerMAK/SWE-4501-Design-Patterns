package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class NormalHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Normal Hit";
    }
}
