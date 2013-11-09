package com.flagleader.repository.tree;

import java.util.Iterator;

public abstract interface IRuleGroup extends ITreeNode
{
  public abstract Iterator getRulePackages();

  public abstract void updateTableDisplayNames();

  public abstract int getRuleGroupCount();

  public abstract int getRulePackageCount();

  public abstract void save();

  public abstract IRuleProject getProject();

  public abstract RulePackage exitsPackage(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleGroup
 * JD-Core Version:    0.6.0
 */