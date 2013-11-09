package com.flagleader.repository.flow;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;

class c
  implements ChildAcceptor
{
  c(RulePoolNode paramRulePoolNode, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRuleClass)) && (((IRuleClass)paramObject).getVisitExeName().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRulePackage)) || ((paramObject instanceof IRuleRepository)) || ((paramObject instanceof IRuleGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.flow.c
 * JD-Core Version:    0.6.0
 */