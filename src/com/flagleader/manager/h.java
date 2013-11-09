package com.flagleader.manager;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.TestCaseLib;

class h
  implements ChildAcceptor
{
  h(a parama)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IRulePackage)) && (((IRulePackage)paramObject).isNeedSave()))
      return true;
    return ((paramObject instanceof TestCaseLib)) && (((TestCaseLib)paramObject).isNeedSave());
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleGroup)) || ((paramObject instanceof IRuleProject));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.h
 * JD-Core Version:    0.6.0
 */