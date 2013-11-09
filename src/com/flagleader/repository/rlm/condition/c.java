package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.tree.IRuleContainer;

public class c extends a
{
  public c(ConditionToken paramConditionToken)
  {
  }

  public void a()
  {
    IMultiLineEditen localIMultiLineEditen = this.a.getContainer();
    IRuleContainer localIRuleContainer = this.a.getRoot();
    localIRuleContainer.initUndoable();
    this.a.dispose();
    localIRuleContainer.setModified(true);
    localIRuleContainer.takeSnapshot();
    if (localIMultiLineEditen != null)
      localIMultiLineEditen.update();
  }

  public String c()
  {
    return "remove";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.c
 * JD-Core Version:    0.6.0
 */