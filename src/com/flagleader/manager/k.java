package com.flagleader.manager;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;

class k
  implements ChildAcceptor
{
  k(j paramj, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRulePackage)) && (((IRulePackage)paramObject).getExeRulePackageName().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleGroup)) || ((paramObject instanceof IRuleRepository));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.k
 * JD-Core Version:    0.6.0
 */