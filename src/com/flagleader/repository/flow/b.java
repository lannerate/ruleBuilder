package com.flagleader.repository.flow;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;

class b
  implements ChildAcceptor
{
  b(RulePoolFlow paramRulePoolFlow)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleProject)) || ((paramObject instanceof IRulePackage)) || ((paramObject instanceof IRuleSet));
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IRuleTree)) || ((paramObject instanceof IRulePackage));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.flow.b
 * JD-Core Version:    0.6.0
 */