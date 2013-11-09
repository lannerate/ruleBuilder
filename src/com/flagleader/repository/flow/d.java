package com.flagleader.repository.flow;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RuleRepository;

class d
  implements ChildAcceptor
{
  d(RulePoolNode paramRulePoolNode, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRulePackage)) && (((IRulePackage)paramObject).getDisplayName().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleProject)) || ((paramObject instanceof RuleRepository)) || ((paramObject instanceof IRuleGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.flow.d
 * JD-Core Version:    0.6.0
 */