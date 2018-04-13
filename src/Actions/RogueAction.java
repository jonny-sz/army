package Actions;

import Exceptions.ArmyExceptions;
import Units.Unit;

public class RogueAction extends Action {
    @Override
    public void attack(Unit owner, Unit target) throws ArmyExceptions {
        System.out.print(owner.getTitle() + " " + owner.getName() + " attack ");
        System.out.println(target.getTitle() + " " + target.getName());

        target.takeDamage(owner.getDamage());
    }
}
