package Actions;

import Exceptions.ArmyExceptions;
import Units.Unit;

public class WolfAction extends WerewolfAction {
    @Override
    public void infect(Unit owner, Unit target) throws ArmyExceptions {
        String tmp = target.getTitle();

        target.turnToWerewolf();

        System.out.print(owner.getTitle() + " " + owner.getName() + " infect ");
        System.out.println(tmp + " " + target.getName());
    }
}
