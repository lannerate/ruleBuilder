package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.builder.b.p;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.condition.DecisionConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.DecisionRelateCondition;
import com.flagleader.repository.tree.DecisionRelateRule;
import java.util.List;

public class H extends a
{
  public H(o paramo)
  {
  }

  public void a()
  {
    List localList = o.a(this.a).getConditions().getConditionList();
    Object localObject;
    if (localList.size() == 0)
    {
      localObject = new p(o.b(this.a).getShell(), o.b(this.a), o.a(this.a).getConditions());
      ((p)localObject).open();
    }
    else
    {
      localObject = new DecisionConditionToken((DecisionConditionToken)localList.get(localList.size() - 1));
      ((DecisionConditionToken)localObject).setUuid(null);
      if (o.a(this.a).getConditionNum() > 1)
      {
        DecisionRelateCondition localDecisionRelateCondition1 = o.a(this.a).getRelateCondition((DecisionConditionToken)localList.get(localList.size() - 1), 2);
        if (localDecisionRelateCondition1 != null)
        {
          DecisionRelateCondition localDecisionRelateCondition2 = new DecisionRelateCondition(localDecisionRelateCondition1);
          localDecisionRelateCondition2.setUuid(null);
          localDecisionRelateCondition2.setConditionUuids(((DecisionConditionToken)localObject).getUuid());
          o.a(this.a).addChildElement(localDecisionRelateCondition2);
        }
      }
      o.a(this.a).getConditions().addChildElement((IElement)localObject);
      o.a(this.a).setModified(true);
    }
    o.a(this.a).setModified(true);
    this.a.update();
  }

  public boolean b()
  {
    return !o.c(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.H
 * JD-Core Version:    0.6.0
 */