package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.tree.IRuleContainer;

public class P extends a
{
  public P(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    IMultiLineEditen localIMultiLineEditen = this.a.getContainer();
    localIMultiLineEditen.getRoot().initUndoable();
    this.a.dispose();
    localIMultiLineEditen.getRoot().takeSnapshot();
    localIMultiLineEditen.getRoot().setModified(true);
    if (localIMultiLineEditen != null)
      localIMultiLineEditen.update();
  }

  public String c()
  {
    return "remove";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.P
 * JD-Core Version:    0.6.0
 */