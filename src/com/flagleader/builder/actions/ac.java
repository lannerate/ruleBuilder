package com.flagleader.builder.actions;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;

class ac
  implements ChildAcceptor
{
  ac(ab paramab)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof TestCaseLib)) || ((paramObject instanceof TestCase));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IRuleGroup)) || ((paramObject instanceof RulePackage)) || ((paramObject instanceof TestCaseLib));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ac
 * JD-Core Version:    0.6.0
 */