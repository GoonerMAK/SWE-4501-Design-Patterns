import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DuckOdyssey {
    public static void main(String[] args) {

        // Create some ducks using a factory
        Quackable mallardDuck = DuckFactory.createDuck("mallard");
        Quackable redheadDuck = DuckFactory.createDuck("redhead");

        // Create counting ducks using a counting duck factory
        Quackable countingMallardDuck = CountingDuckFactory.createDuck("mallard");
        Quackable countingRedheadDuck = CountingDuckFactory.createDuck("redhead");

        // Create a goose adapter
        Goose goose = new Goose();
        Quackable gooselikeDuck = new GooselikeDuck(goose);

        // Create a flock and add ducks to it
        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redheadDuck);
        flock.add(countingMallardDuck);
        flock.add(countingRedheadDuck);
        flock.add(gooselikeDuck);

        // Create Quack Enthusiasts to observe ducks
        QuackEnthusiast quackEnthusiasts1 = new QuackEnthusiast(mallardDuck);
        QuackEnthusiast quackEnthusiasts2 = new QuackEnthusiast(redheadDuck);
        QuackEnthusiast quackEnthusiasts3 = new QuackEnthusiast(countingMallardDuck);
        QuackEnthusiast quackEnthusiasts4 = new QuackEnthusiast(countingRedheadDuck);
        QuackEnthusiast quackEnthusiasts5 = new QuackEnthusiast(gooselikeDuck);

        System.out.println("Duck simulation:");
        simulate(flock);
        simulate(countingMallardDuck);

        System.out.println("Mallard duck quack count: " + ((QuackyDuck) countingMallardDuck).getQuackCount());
        System.out.println("Redhead duck quack count: " + ((QuackyDuck) countingRedheadDuck).getQuackCount());
    }

    static void simulate(Quackable duck) {
        duck.quack();
    }
}


interface Observer           // Observer interface
{
    void update(Quackable duck);
}

interface Subject            // Subject interface
{
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}


interface Quackable extends Subject
{
    String getDescription();

    String quack();

}


abstract class QuackableEntity implements Quackable
{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}


class MallardDuck extends QuackableEntity
{
    @Override
    public String getDescription() {
        return "I'm a Mallard duck";
    }

    @Override
    public String quack() {
        notifyObservers();
        return "Quack quack...";
    }
}


class RedheadDuck extends QuackableEntity
{
    @Override
    public String getDescription() {
        return "I'm a Redhead duck";
    }

    @Override
    public String quack() {
        notifyObservers();
        return "Quack quack...";
    }
}


class QuackyDuck extends QuackableEntity
{
    private final Quackable decoratedQuacks;
    private int quackCount = 0;

    QuackyDuck(Quackable decoratedQuacks) {
        this.decoratedQuacks = decoratedQuacks;
    }

    @Override
    public String getDescription() {
        return decoratedQuacks.getDescription() + " who quacks a lot";
    }

    @Override
    public String quack() {
        quackCount++;
        notifyObservers();
        return decoratedQuacks.quack() + "... more quack quack";
    }

    public int getQuackCount() {
        return quackCount;
    }

}

class Goose
{
    public String getDescription() {
        return "I'm a goose";
    }

    public String honk() {
        return "Honk honk...";
    }

}


class GooselikeDuck extends QuackableEntity
{
    private Goose goose;

    public GooselikeDuck(Goose goose)
    {
        this.goose = goose;
    }

    @Override
    public String getDescription() {
        return "I'm a goose-like duck";
    }

    @Override
    public String quack() {
        notifyObservers();
        return goose.honk();
    }
}


class DuckFactory
{
    public static Quackable createDuck(String type)
    {
        type = type.toLowerCase();
        if ("mallard".equals(type)) {
            return new MallardDuck();
        } else if ("redhead".equals(type)) {
            return new RedheadDuck();
        } else {
            throw new IllegalArgumentException("Invalid Duck type: " + type);
        }
    }
}


class CountingDuckFactory
{
    public static Quackable createDuck(String type)
    {
        type = type.toLowerCase();
        if ("mallard".equals(type)) {
            return new QuackyDuck(new MallardDuck());
        } else if ("redhead".equals(type)) {
            return new QuackyDuck(new RedheadDuck());
        } else {
            throw new IllegalArgumentException("Invalid Duck type: " + type);
        }
    }
}




class Flock extends QuackableEntity        // Composite class
{
    private List<Quackable> components = new ArrayList<>();

    public void add(Quackable component) {
        components.add(component);
    }

    public void remove(Quackable component) {
        components.remove(component);
    }

    @Override
    public String getDescription() {
        return "This is a flock of ducks";
    }

    @Override
    public String quack() {
        StringBuilder quacks = new StringBuilder();
        Iterator<Quackable> iterator = components.iterator();

        while (iterator.hasNext()) {
            Quackable component = iterator.next();
            quacks.append(component.quack());
            if (iterator.hasNext()) {
                quacks.append(" and ");
            }
        }
        notifyObservers();
        return quacks.toString();
    }
}


class QuackEnthusiast implements Observer
{
    private Quackable duck;

    public QuackEnthusiast(Quackable duck)
    {
        this.duck = duck;
        duck.addObserver(this);
    }

    @Override
    public void update(Quackable duck)
    {
        System.out.println("QuackEnthusiast: " + duck.getDescription() + " just quacked.");
    }
}