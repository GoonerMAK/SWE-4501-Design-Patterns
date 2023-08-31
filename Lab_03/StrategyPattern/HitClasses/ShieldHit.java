package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class ShieldHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Shield Hit";
    }
}
