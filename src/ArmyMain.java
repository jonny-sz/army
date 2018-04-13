import Exceptions.ArmyExceptions;
import Mages.*;
import Units.*;

public class ArmyMain {
    public static void printObservers(Unit unit) {
        StringBuilder out = new StringBuilder(unit.getName() + " observers:");

        if ( !unit.getObservers().isEmpty() ) {
            for ( Unit un: unit.getObservers() ) {
                out.append(" ").append(un.getName()).append("(").append(un.getTitle()).append(")");
            }
        } else {
            out.append(" Empty");
        }
        System.out.println(out);
    }

    public static void printObservables(Unit unit) {
        StringBuilder out = new StringBuilder(unit.getName() + " observables:");

        if ( !unit.getObservables().isEmpty() ) {
            for ( Unit un: unit.getObservables() ) {
                out.append(" ").append(un.getName()).append("(").append(un.getTitle()).append(")");
            }
        } else {
            out.append(" Empty");
        }
        System.out.println(out);
    }

    public static void main(String[] args) throws ArmyExceptions, CloneNotSupportedException {
        long start_time = System.currentTimeMillis();
        long time_result;

        Soldier kolya = new Soldier("Kolya");
        Rogue max = new Rogue("Max");
        Berserker ben = new Berserker("Ben");
        Wizard masha = new Wizard("Masha");
        Healer doc = new Healer("Doc");
        Priest mark = new Priest("Mark");
        Warlock den = new Warlock("Den");
        Necromancer marmont = new Necromancer("Marmont");
        Werewolf volk = new Werewolf("Volk");
        Vampire dracula = new Vampire("Dracula");

        System.out.println(kolya);
        System.out.println(max);
        System.out.println(ben);
        System.out.println(masha);
        System.out.println(doc);
        System.out.println(mark);
        System.out.println(den);
        System.out.println(marmont);
        System.out.println(volk);
        System.out.println(dracula);
        System.out.println("--------------------------------------------------------");



        System.out.println("--------------------------------------------------------");
        System.out.println(kolya);
        System.out.println(max);
        System.out.println(ben);
        System.out.println(masha);
        System.out.println(doc);
        System.out.println(mark);
        System.out.println(den);
        System.out.println(marmont);
//        System.out.println(den.daemon());
        System.out.println(volk);
        System.out.println(dracula);

        time_result = System.currentTimeMillis() - start_time;
        System.out.println("\n" + "Time: " + time_result);
    }
}
