package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.export.IPage;

class at
  implements ChildAcceptor
{
  at(RulePackage paramRulePackage)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof ITreeNode)) && (!(paramObject instanceof IPage)) && (!(paramObject instanceof TestCaseLib));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ITreeNode)) && (!(paramObject instanceof IPage)) && (!(paramObject instanceof TestCaseLib));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.at
 * JD-Core Version:    0.6.0
 */