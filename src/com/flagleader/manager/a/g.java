package com.flagleader.manager.a;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IEnvionment;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleSet;

class g
  implements ChildAcceptor
{
  g(e parame)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IRule;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleSet)) || ((paramObject instanceof IEnvionment));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.g
 * JD-Core Version:    0.6.0
 */