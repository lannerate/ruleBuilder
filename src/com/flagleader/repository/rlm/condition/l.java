package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import java.util.Iterator;

class l extends a
{
  l(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    IConditionToken localIConditionToken1 = this.a.getParentCondition();
    Object localObject;
    if ((localIConditionToken1.getParent() != null) && ((localIConditionToken1.getParent() instanceof IConditionToken)))
    {
      LogicalJudgeToken.access$1(this.a);
      localObject = (IConditionToken)localIConditionToken1.getParent();
      localIConditionToken1.getParent().removeChildElement(localIConditionToken1);
      ((IConditionToken)localObject).getParent().addChildElement(localIConditionToken1, ((IConditionToken)localObject).getParent().getElementPos((IElement)localObject) + 1);
      LogicalJudgeToken.access$2(this.a);
      ((IConditionToken)localObject).getConditionContainer().update();
    }
    else if ((localIConditionToken1.getParent() != null) && ((localIConditionToken1.getParent() instanceof IMultiConditionToken)) && (!localIConditionToken1.isFirstCondition()))
    {
      LogicalJudgeToken.access$1(this.a);
      localObject = (IMultiConditionToken)localIConditionToken1.getParent();
      IConditionToken localIConditionToken2 = ((IMultiConditionToken)localObject).getPreviousCondition(localIConditionToken1);
      ((IMultiConditionToken)localObject).removeChildElement(localIConditionToken1);
      localIConditionToken2.addChildElement(localIConditionToken1);
      Iterator localIterator = localIConditionToken1.getNextTests();
      while (localIterator.hasNext())
      {
        IConditionToken localIConditionToken3 = (IConditionToken)localIterator.next();
        localIConditionToken1.removeChildElement(localIConditionToken3);
        localIConditionToken2.addChildElement(localIConditionToken3);
      }
      LogicalJudgeToken.access$2(this.a);
      ((IMultiConditionToken)localObject).update();
    }
  }

  public String c()
  {
    return "setLoc";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.l
 * JD-Core Version:    0.6.0
 */