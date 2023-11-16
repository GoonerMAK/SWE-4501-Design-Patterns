import java.util.ArrayList;
import java.util.List;

public class DamageTest
{
    public static void main(String[] args)
    {
        List<Attacker> attackers = new ArrayList<>(List.of(new Paladin(), new Warlock(), new Ranger()));

        AttackerVisitor visitor = new AttackManager();

        for(Attacker attacker : attackers)
        {
            attacker.getDescription();
            attacker.damage(visitor);
            System.out.println();
        }
    }
}

interface Attacker
{
    void getDescription();
    void damage(AttackerVisitor visitor);           // accept method
}

class Paladin implements Attacker
{
    @Override
    public void getDescription() {
        System.out.println("Paladin is on its duty");
    }

    @Override
    public void damage(AttackerVisitor visitor) {
        visitor.attack(this);
    }

}


class Warlock implements Attacker
{
    @Override
    public void getDescription() {
        System.out.println("Warlock is on the loose");
    }

    @Override
    public void damage(AttackerVisitor visitor) {
        visitor.attack(this);
    }
}

class Ranger implements Attacker
{
    @Override
    public void getDescription() {
        System.out.println("Ranger is leading the bunch");
    }

    @Override
    public void damage(AttackerVisitor visitor) {
        visitor.attack(this);
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