package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.condition.DecisionConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.DecisionRule;
import java.util.List;

public class ax extends a
{
  public ax(af paramaf)
  {
  }

  public void a()
  {
    List localList = af.a(this.a).getSecondConditions().getConditionList();
    if (localList.size() == 0)
    {
      p localp = new p(af.b(this.a).getShell(), af.b(this.a), af.a(this.a).getSecondConditions());
      localp.open();
    }
    else
    {
      af.a(this.a).getSecondConditions().addChildElement(new DecisionConditionToken((DecisionConditionToken)localList.get(localList.size() - 1)));
      af.a(this.a).setModified(true);
    }
    this.a.update();
  }

  public boolean b()
  {
    return !af.c(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ax
 * JD-Core Version:    0.6.0
 */