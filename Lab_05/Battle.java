import java.lang.reflect.Method;

/* The Interface: Duelist */
interface Duel
{
    void EnteringSite();
    void ClearingCorners();
    void TakingSpace();
    void EngageEnemies();
}

/* Classes that implements the Interface: Duelist */
class Duelist implements Duel
{
    @Override
    public void EnteringSite() {
        System.out.println("Entering Site");
    }

    @Override
    public void ClearingCorners() {
        System.out.println("Clearing Corners");
    }

    @Override
    public void TakingSpace() {
        System.out.println("Taking Space");
    }

    @Override
    public void EngageEnemies() {
        System.out.println("Engaging Enemies");
    }
}

/* The Interface: Initiator */
interface Initiate
{
    void InitiateAttack();
    void AssistTeam();
    void BlindEnemies();
    void FlushEnemiesFromCorners();
}

/* Classes that implements the Interface: Character */

class Initiator implements Initiate
{

    @Override
    public void InitiateAttack() {
        System.out.println("Initiating Attack");
    }

    @Override
    public void AssistTeam() {
        System.out.println("Assisting Team");
    }

    @Override
    public void BlindEnemies() {
        System.out.println("Blinding Enemies");
    }

    @Override
    public void FlushEnemiesFromCorners() {
        System.out.println("Flushing Enemies From Corners");
    }
}


class DuelingInitiator implements Duel
{
    Initiator initiator;

    public DuelingInitiator(Initiator initiator)
    {
        this.initiator = initiator;
    }

    @Override
    public void EnteringSite() {
        System.out.println("Entering Site as Initiator");
    }

    @Override
    public void ClearingCorners() {
        initiator.FlushEnemiesFromCorners();
    }

    @Override
    public void TakingSpace() {
        System.out.println("Taking Space as Initiator");
    }

    @Override
    public void EngageEnemies() {
        initiator.BlindEnemies();
    }
}


public class Battle
{
    public static void Let_Agent_Loose(Object obj)
    {
        Class<?> clazz = obj.getClass();

        Method[] methods = clazz.getDeclaredMethods();

        System.out.println( "\nActions performed by the Agent: " );

        for (Method method : methods)
        {
            if (method.getParameterCount() == 0)
            {
                try {
                    method.setAccessible(true);
                    method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Duelist jett = new Duelist();

        Initiator gekko = new Initiator();

        Duel KAY_O = new DuelingInitiator(gekko);

        Let_Agent_Loose(jett);
        Let_Agent_Loose(gekko);
        Let_Agent_Loose(KAY_O);
    }

}
