package com.flagleader.repository.lang.b;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;

class o
  implements ChildAcceptor
{
  o(j paramj)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRule)) || ((paramObject instanceof IRuleTree));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleSet)) || ((paramObject instanceof Envionment));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.o
 * JD-Core Version:    0.6.0
 */