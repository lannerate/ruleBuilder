package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.al;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;

public class n extends bl
{
  public n(BuilderManager paramBuilderManager)
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
    return "Redo";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return this.a.getRulesManager().c().i();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.n
 * JD-Core Version:    0.6.0
 */