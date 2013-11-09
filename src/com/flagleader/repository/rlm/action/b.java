package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;

class b
  implements ChildAcceptor
{
  b(AbstractSelectRuleToken paramAbstractSelectRuleToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof RulePackage)) && (((RulePackage)paramObject).getDisplayName().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleProject)) || ((paramObject instanceof RuleRepository)) || ((paramObject instanceof IRuleGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.b
 * JD-Core Version:    0.6.0
 */