package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import java.util.Iterator;

class f extends a
{
  f(DecisionConditionToken paramDecisionConditionToken)
  {
  }

  public void a()
  {
    DecisionConditionToken localDecisionConditionToken = this.a;
    Object localObject;
    if ((localDecisionConditionToken.getParent() != null) && ((localDecisionConditionToken.getParent() instanceof IConditionToken)))
    {
      DecisionConditionToken.access$0(this.a);
      localObject = (IConditionToken)localDecisionConditionToken.getParent();
      localDecisionConditionToken.getParent().removeChildElement(localDecisionConditionToken);
      ((IConditionToken)localObject).getParent().addChildElement(localDecisionConditionToken, ((IConditionToken)localObject).getParent().getElementPos((IElement)localObject) + 1);
      DecisionConditionToken.access$1(this.a);
      ((IConditionToken)localObject).getConditionContainer().update();
    }
    else if ((localDecisionConditionToken.getParent() != null) && ((localDecisionConditionToken.getParent() instanceof IMultiConditionToken)))
    {
      localObject = (IMultiConditionToken)localDecisionConditionToken.getParent();
      IConditionToken localIConditionToken1 = ((IMultiConditionToken)localObject).getPreviousCondition(localDecisionConditionToken);
      if (localIConditionToken1 == null)
        return;
      DecisionConditionToken.access$0(this.a);
      ((IMultiConditionToken)localObject).removeChildElement(localDecisionConditionToken);
      localIConditionToken1.addChildElement(localDecisionConditionToken);
      Iterator localIterator = localDecisionConditionToken.getNextTests();
      while (localIterator.hasNext())
      {
        IConditionToken localIConditionToken2 = (IConditionToken)localIterator.next();
        localDecisionConditionToken.removeChildElement(localIConditionToken2);
        localIConditionToken1.addChildElement(localIConditionToken2);
      }
      DecisionConditionToken.access$1(this.a);
      ((IMultiConditionToken)localObject).update();
    }
  }

  public String c()
  {
    return "setLoc";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.f
 * JD-Core Version:    0.6.0
 */