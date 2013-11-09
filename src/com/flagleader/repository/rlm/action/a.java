package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;

class a
  implements ChildAcceptor
{
  a(AbstractSelectRuleToken paramAbstractSelectRuleToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((this.b != null) && (this.b.indexOf("@") > 0))
      return ((paramObject instanceof IRuleClass)) && (((IRuleClass)paramObject).getVisitExeName().equals(this.b));
    return ((paramObject instanceof RulePackage)) && (((RulePackage)paramObject).getExeRulePackageName().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    if ((this.b != null) && (this.b.indexOf("@") > 0))
      return ((paramObject instanceof IRuleProject)) || ((paramObject instanceof RuleRepository)) || ((paramObject instanceof IRuleGroup)) || ((paramObject instanceof IRuleSet));
    return ((paramObject instanceof IRuleProject)) || ((paramObject instanceof RuleRepository)) || ((paramObject instanceof IRuleGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.a
 * JD-Core Version:    0.6.0
 */