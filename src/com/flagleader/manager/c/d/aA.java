package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class aA
  implements b
{
  public aA(ao paramao)
  {
  }

  public boolean a()
  {
    return this.a.h().isSyn();
  }

  public boolean a(boolean paramBoolean)
  {
    this.a.h().setSyn(paramBoolean);
    ((ITreeNode)this.a.h().getParent()).updateTree();
    this.a.h().setModified(true);
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aA
 * JD-Core Version:    0.6.0
 */