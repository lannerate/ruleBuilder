package com.flagleader.manager.dialog.d;

import com.flagleader.repository.tree.IOpenNode;
import java.util.List;

public class c extends d
{
  private boolean b = false;

  public c(com.flagleader.manager.dialog.d paramd, List paramList)
  {
    super(paramd, paramList);
  }

  public c(IOpenNode paramIOpenNode)
  {
    super(new b(paramIOpenNode), paramIOpenNode.getAutoSavedPack());
  }

  public boolean a()
  {
    return this.b;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.d.c
 * JD-Core Version:    0.6.0
 */