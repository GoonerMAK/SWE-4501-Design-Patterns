import java.util.ArrayList;

public class Evaluations {
    public static void main(String[] args)
    {
        PerformanceEvaluator performanceEvaluator = new PerformanceEvaluator();

        AccuracyIndex accuracyIndex = new AccuracyIndex(performanceEvaluator);
        RatioIndex ratioIndex = new RatioIndex(performanceEvaluator);
        EfficiencyIndex efficiencyIndex = new EfficiencyIndex(performanceEvaluator);
        ExperienceIndex experienceIndex = new ExperienceIndex(performanceEvaluator);

        performanceEvaluator.setPerformanceMetrics(2, 30, 153, 60, 403, 280);

        performanceEvaluator.removeObserver(accuracyIndex);

        performanceEvaluator.setPerformanceMetrics(143, 1203, 2333, 230, 4103, 4280);

        /* accuracyIndex.display();
        ratioIndex.display();
        efficiencyIndex.display();
        experienceIndex.display(); */
    }
}

interface Subject
{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyAllObservers();
}


class PerformanceEvaluator implements Subject
{
    private int PlayingHours;
    private int ActiveDays;
    private int TotalKills;
    private int TotalHeadshots;
    private int TotalDeaths;
    private int TotalAssists;

    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyAllObservers()
    {
        for (Observer observer : observers)
        {
            observer.update(PlayingHours, ActiveDays, TotalKills, TotalHeadshots, TotalDeaths, TotalAssists);
        }
    }

    public void setPerformanceMetrics(int playingHours, int activeDays, int totalKills, int totalHeadshots, int totalDeaths, int totalAssists)
    {
        this.PlayingHours = playingHours;
        this.ActiveDays = activeDays;
        this.TotalKills = totalKills;
        this.TotalHeadshots = totalHeadshots;
        this.TotalDeaths = totalDeaths;
        this.TotalAssists = totalAssists;

        notifyAllObservers();
    }

}



interface Display
{
    void display();
}


interface Evaluate
{
    double evaluate();
}

interface Observer
{
    void update(int PlayingHours, int ActiveDays, int TotalKills, int TotalHeadshots, int TotalDeaths, int TotalAssists);
}



class AccuracyIndex implements Observer, Display, Evaluate
{
    private int TotalKills;
    private int TotalHeadshots;
    private Subject performance;

    public AccuracyIndex(Subject performance)
    {
        this.performance = performance;
        performance.addObserver(this);
    }

    @Override
    public void update(int PlayingHours, int ActiveDays, int TotalKills, int TotalHeadshots, int TotalDeaths, int TotalAssists)
    {
        this.TotalKills = TotalKills;
        this.TotalHeadshots = TotalHeadshots;
        display();
    }

    @Override
    public void display()
    {
        System.out.println("Headshot Percentage: " + evaluate() + "%");
    }

    @Override
    public double evaluate()
    {
        if (TotalKills == 0)
        {
            return 0.0;
        }

        return (double) TotalHeadshots / TotalKills * 100.0;
    }
}


class RatioIndex implements Observer, Display, Evaluate
{
    private int TotalKills;
    private int TotalDeaths;
    private Subject performance;

    public RatioIndex(Subject performance)
    {
        this.performance = performance;
        performance.addObserver(this);
    }

    @Override
    public void update(int PlayingHours, int ActiveDays, int TotalKills, int TotalHeadshots, int TotalDeaths, int TotalAssists)
    {
        this.TotalKills = TotalKills;
        this.TotalDeaths = TotalDeaths;
        display();
    }

    @Override
    public void display()
    {
        System.out.println("Kill Ratio: " + evaluate() );
    }

    @Override
    public double evaluate()
    {
        if (TotalDeaths == 0)
        {
            return 0.0;
        }

        return (double) (TotalKills) / TotalDeaths;
    }

}


class EfficiencyIndex implements Observer, Display, Evaluate
{
    private int TotalKills;
    private int TotalDeaths;
    private int TotalAssists;
    private Subject performance;

    public EfficiencyIndex(Subject performance)
    {
        this.performance = performance;
        performance.addObserver(this);
    }

    @Override
    public void update(int PlayingHours, int ActiveDays, int TotalKills, int TotalHeadshots, int TotalDeaths, int TotalAssists)
    {
        this.TotalKills = TotalKills;
        this.TotalDeaths = TotalDeaths;
        this.TotalAssists = TotalAssists;
        display();
    }

    @Override
    public void display()
    {
        System.out.println("Overall Efficiency: " + evaluate() + "%");
    }

    @Override
    public double evaluate()
    {
        if (TotalDeaths == 0)
        {
            return 0.0;
        }

        return ((double) (TotalKills + TotalAssists) / TotalDeaths) * 50.0;
    }

}



class ExperienceIndex implements Observer, Display, Evaluate
{
    private int PlayingHours;
    private int ActiveDays;
    private int TotalKills;
    private int TotalHeadshots;
    private int TotalDeaths;
    private int TotalAssists;
    private Subject performance;

    public ExperienceIndex(Subject performance)
    {
        this.performance = performance;
        performance.addObserver(this);
    }

    @Override
    public void update(int PlayingHours, int ActiveDays, int TotalKills, int TotalHeadshots, int TotalDeaths, int TotalAssists)
    {
        this.PlayingHours = PlayingHours;
        this.ActiveDays = ActiveDays;
        this.TotalKills = TotalKills;
        this.TotalHeadshots = TotalHeadshots;
        this.TotalDeaths = TotalDeaths;
        this.TotalAssists = TotalAssists;
        display();
    }

    @Override
    public void display()
    {
        System.out.println("Player Experience Percentile: " + evaluate() + "%");
    }

    @Override
    public double evaluate()
    {
        if (PlayingHours <= 0)
        {
            return 0.0;
        }

        double killsWeight = .2;
        double headshotsWeight = .3;
        double assistsWeight = .1;
        double deathsWeight = 0.05;
        double activeDaysWeight = 0.07;

        double score = (TotalKills * killsWeight + TotalHeadshots * headshotsWeight +
                TotalAssists * assistsWeight + TotalDeaths * deathsWeight) / PlayingHours;

        score += ActiveDays * activeDaysWeight;

        double maxScore = 100.0;
        double experiencePercentile = (score / maxScore) * 100.0;

        return Math.min(100.0, experiencePercentile);
    }

}