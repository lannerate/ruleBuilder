package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.al;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;

public class u extends bl
{
  public u(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    this.a.getRulesManager().c().f();
    this.a.getMenuAndToolBar().b();
  }

  public String a()
  {
    return "Undo";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return this.a.getRulesManager().c().h();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.u
 * JD-Core Version:    0.6.0
 */