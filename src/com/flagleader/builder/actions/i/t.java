package com.flagleader.builder.actions.i;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.IOpenNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;

class t
  implements ChildAcceptor
{
  t(s params)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof TestCaseLib)) || ((paramObject instanceof TestCase));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IOpenNode)) || ((paramObject instanceof RulePackage)) || ((paramObject instanceof TestCaseLib));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.t
 * JD-Core Version:    0.6.0
 */