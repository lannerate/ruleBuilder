package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.List;

public class RuleHistory extends AbstractPackageElement
{
  public RuleHistory(RuleHistory paramRuleHistory)
  {
    super(paramRuleHistory);
  }

  public RuleHistory()
  {
  }

  public String getName()
  {
    return "RuleHistory";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleHistory(this);
  }

  public IElement deepClone()
  {
    return new RuleHistory(this);
  }

  public IPackageElement getTreeNode()
  {
    if ((getChildrenCount() > 0) && ((a().get(0) instanceof IPackageElement)))
      return (IPackageElement)a().get(0);
    return null;
  }

  public void save()
  {
  }

  public boolean isLocked()
  {
    return true;
  }

  public boolean isVisible()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleHistory
 * JD-Core Version:    0.6.0
 */