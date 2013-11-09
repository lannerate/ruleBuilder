package com.flagleader.builder.actions;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleTree;

class be
  implements ChildAcceptor
{
  be(bd parambd)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof IRuleTree;
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IRuleTree;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.be
 * JD-Core Version:    0.6.0
 */