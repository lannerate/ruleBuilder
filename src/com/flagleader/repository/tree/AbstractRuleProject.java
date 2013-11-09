package com.flagleader.repository.tree;

public abstract class AbstractRuleProject extends AbstractTreeNode
  implements IRuleProject
{
  public AbstractRuleProject()
  {
  }

  public AbstractRuleProject(AbstractTreeNode paramAbstractTreeNode)
  {
    super(paramAbstractTreeNode);
  }

  public AbstractRuleProject(String paramString)
  {
    super(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractRuleProject
 * JD-Core Version:    0.6.0
 */