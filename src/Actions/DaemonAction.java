package Actions;

import Exceptions.ArmyExceptions;
import Exceptions.UnitIsImmuneToTurnException;
import Units.Unit;

public class DaemonAction extends Action {
    @Override
    public void turnToWerewolf(Unit owner) throws ArmyExceptions {
        throw new UnitIsImmuneToTurnException();
    }

    @Override
    public void turnToVampire(Unit owner) throws ArmyExceptions {
        throw new UnitIsImmuneToTurnException();
    }
}
