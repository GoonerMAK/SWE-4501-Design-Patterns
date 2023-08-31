package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class CriticalHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Critical Hit";
    }
}
