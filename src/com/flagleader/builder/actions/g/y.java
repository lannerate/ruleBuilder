package com.flagleader.builder.actions.g;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;

class y
  implements ChildAcceptor
{
  y(x paramx)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRulePackage)) && (((IRulePackage)paramObject).getRuletypeid() == 5);
  }

  public boolean hasChildren(Object paramObject)
  {
    return (paramObject instanceof IRuleGroup);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.y
 * JD-Core Version:    0.6.0
 */