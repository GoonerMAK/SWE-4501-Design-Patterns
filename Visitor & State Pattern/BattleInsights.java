import java.util.ArrayList;
import java.util.List;

public class BattleInsights
{
    public static void main(String[] args)
    {
        //   State Pattern
        Attacker paladin = new Paladin(new StandingByState());

        paladin.changeState(new EngagingState());        // Change state to ACTIVE

        paladin.changeState(new ObservingState());        // Change state to OBSERVE

        paladin.changeState(new StandingByState());        // Change state to IDLE

        //   Visitor Pattern
        List<Attacker> attackers = new ArrayList<>(List.of(paladin, new Warlock(new StandingByState()), new Ranger(new EngagingState()) ));

        AttackerVisitor visitor = new AttackManager();

        for(Attacker attacker : attackers)
        {
            attacker.getDescription();
            attacker.damage(visitor);
            System.out.println();
        }
    }
}

enum StateType {
    OBSERVE, ACTIVE, IDLE
}

abstract class Attacker {
    protected State currentState;

    public Attacker(State state) {
        this.currentState = state;
    }

    public abstract void getDescription();

    public abstract void damage(AttackerVisitor visitor);           // accept method

    public void changeState(State state) {
        this.currentState = state;
        StateHandler.handleStateChange(this);
    }

    public String getCurrentStateName() {
        return currentState.getClass().getSimpleName().toLowerCase();
    }

    public State getCurrentState() {
        return currentState;
    }
}


class Paladin extends Attacker {
    public Paladin(State state) {
        super(state);
    }

    @Override
    public void getDescription() {
        System.out.println("Paladin is on its duty");
    }

    @Override
    public void damage(AttackerVisitor visitor)     // accept method --> invoking visit method
    {
        visitor.attack(this);
    }
}

class Warlock extends Attacker {
    public Warlock(State state) {
        super(state);
    }

    @Override
    public void getDescription() {
        System.out.println("Warlock is on the loose");
    }

    @Override
    public void damage(AttackerVisitor visitor)        // accept method --> invoking visit method
    {
        visitor.attack(this);
    }
}

class Ranger extends Attacker {
    public Ranger(State state) {
        super(state);
    }

    @Override
    public void getDescription() {
        System.out.println("Ranger is leading the bunch");
    }

    @Override
    public void damage(AttackerVisitor visitor)    // accept method --> invoking visit method
    {
        visitor.attack(this);
    }
}


interface State
{
    StateType getStateType();
}

interface IdleState extends State
{
    void standBy(Attacker attacker);
}

interface ObserverState extends State
{
    void observe(Attacker attacker);
}

interface AttackerState extends State
{
    void engage(Attacker attacker);
}



class StandingByState implements IdleState
{
    @Override
    public void standBy(Attacker attacker) {
        attacker.getDescription();
        System.out.println(attacker.getCurrentStateName() + " --- standing by.\n");
    }

    @Override
    public StateType getStateType() {
        return StateType.IDLE;
    }
}

class ObservingState implements ObserverState
{

    @Override
    public void observe(Attacker attacker) {
        attacker.getDescription();
        System.out.println(attacker.getCurrentStateName() + " --- observing.\n");
    }

    @Override
    public StateType getStateType() {
        return StateType.OBSERVE;
    }
}

class EngagingState implements AttackerState
{
    @Override
    public void engage(Attacker attacker) {
        attacker.getDescription();
        System.out.println(attacker.getCurrentStateName() + " --- engaging.\n");

    }

    @Override
    public StateType getStateType() {
        return StateType.ACTIVE;
    }
}


interface AttackerVisitor                   // Visitor Interface
{
    void attack(Paladin paladin);           // Visit methods
    void attack(Warlock warlock);
    void attack(Ranger ranger);
}

class AttackManager implements AttackerVisitor
{

    @Override
    public void attack(Paladin paladin) {
        System.out.println("Paladin Deals 80 Damage");
    }

    @Override
    public void attack(Warlock warlock) {
        System.out.println("Warlock Deals 120 Damage");
    }

    @Override
    public void attack(Ranger ranger) {
        System.out.println("Ranger Deals 45 Damage");
    }
}

class StateHandler {
    public static void handleStateChange(Attacker attacker) {
        StateType stateType = attacker.getCurrentState().getStateType();

        switch (stateType) {
            case OBSERVE:
                ObserverState observerState = (ObserverState) attacker.getCurrentState();
                observerState.observe(attacker);
                break;
            case ACTIVE:
                AttackerState attackerState = (AttackerState) attacker.getCurrentState();
                attackerState.engage(attacker);
                break;
            case IDLE:
                IdleState idleState = (IdleState) attacker.getCurrentState();
                idleState.standBy(attacker);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + stateType);
        }
    }
}