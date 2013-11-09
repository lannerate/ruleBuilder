package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class ap
  implements b
{
  public ap(ao paramao)
  {
  }

  public boolean a()
  {
    return this.a.h().isActived();
  }

  public boolean a(boolean paramBoolean)
  {
    this.a.h().setActived(paramBoolean);
    ((ITreeNode)this.a.h().getParent()).updateTree();
    this.a.h().setModified(true);
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ap
 * JD-Core Version:    0.6.0
 */