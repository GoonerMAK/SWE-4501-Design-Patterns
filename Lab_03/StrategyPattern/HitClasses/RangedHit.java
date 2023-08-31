package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class RangedHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Ranged Hit";
    }
}
