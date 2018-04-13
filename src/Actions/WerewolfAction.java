package Actions;

import Exceptions.ArmyExceptions;
import Exceptions.UnitIsImmuneToTurnException;
import Units.Unit;

public class WerewolfAction extends Action {
    @Override
    public void transform(Unit owner) throws ArmyExceptions {
        String tmp = owner.getTitle();

        owner.swapStates();
        owner.swapActions();

        System.out.println(tmp + " " + owner.getName() + " turn to " + owner.getTitle());
    }

    @Override
    public void turnToWerewolf(Unit owner) throws ArmyExceptions {
        throw new UnitIsImmuneToTurnException();
    }

    @Override
    public void turnToVampire(Unit owner) throws ArmyExceptions {
        throw new UnitIsImmuneToTurnException();
    }
}
