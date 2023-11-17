public class StateCheck
{
    public static void main(String[] args)
    {
        Attacker paladin = new Paladin(new StandingByState());

        paladin.changeState(new EngagingState());        // Change state to ACTIVE

        paladin.changeState(new ObservingState());        // Change state to OBSERVE

        paladin.changeState(new StandingByState());        // Change state to IDLE
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
}

class Warlock extends Attacker {
    public Warlock(State state) {
        super(state);
    }

    @Override
    public void getDescription() {
        System.out.println("Warlock is on the loose");
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