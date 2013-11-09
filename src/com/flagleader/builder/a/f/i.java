package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.condition.DecisionConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.DecisionMultiRule;
import java.util.List;

public class i extends com.flagleader.builder.a.c.a
{
  public i(a parama)
  {
  }

  public void a()
  {
    List localList = a.b(this.a).getConditions(1).getConditionList();
    if (localList.size() == 0)
    {
      p localp = new p(a.c(this.a).getShell(), a.c(this.a), a.b(this.a).getConditions(1));
      localp.open();
    }
    else
    {
      a.b(this.a).getConditions(1).addChildElement(new DecisionConditionToken((DecisionConditionToken)localList.get(localList.size() - 1)));
      a.b(this.a).setModified(true);
    }
    a.b(this.a).setModified(true);
    this.a.update();
  }

  public boolean b()
  {
    return !a.d(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.i
 * JD-Core Version:    0.6.0
 */