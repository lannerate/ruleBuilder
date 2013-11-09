package com.flagleader.repository.tree;

import java.util.Iterator;
import java.util.List;

public abstract interface IRuleSet extends IPackageElement
{
  public abstract int getRuleAndSetCount();

  public abstract Iterator getRuleAndSets();

  public abstract Envionment getEnvionment();

  public abstract int getVmlFlowType();

  public abstract List getAllRuleElement();

  public abstract int getRuleTableCount();

  public abstract int getMaxDeepin();

  public abstract CheckRuleInfo getCheckRuleInfo();

  public abstract boolean needCheckSubRule();

  public abstract int getChecktype();

  public abstract String getChildDefaultName(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleSet
 * JD-Core Version:    0.6.0
 */