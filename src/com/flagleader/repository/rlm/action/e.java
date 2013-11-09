package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;

class e
  implements ChildAcceptor
{
  e(AbstractSelectRuleToken paramAbstractSelectRuleToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof RulePackage;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof RulePackage)) || ((paramObject instanceof RuleRepository)) || ((paramObject instanceof IRuleGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.e
 * JD-Core Version:    0.6.0
 */