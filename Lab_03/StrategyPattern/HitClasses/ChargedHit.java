package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class ChargedHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Charged Hit";
    }
}
