package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.Rule;
import java.util.Iterator;
import java.util.List;

public class RuleEnterToken extends AbstractRuleObject
{
  public RuleEnterToken(RuleEnterToken paramRuleEnterToken)
  {
    super(paramRuleEnterToken);
  }

  public RuleEnterToken()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleEnterToken(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof IMultiConditionToken);
  }

  public IElement deepClone()
  {
    return new RuleEnterToken(this);
  }

  public String getName()
  {
    return "RuleEnterToken";
  }

  public String toString()
  {
    return getParent().toString();
  }

  public Rule getRule()
  {
    if ((getParent() instanceof Rule))
      return (Rule)getParent();
    return (Rule)getRoot().getRuleTree();
  }

  public IMultiConditionToken getWhenCondition()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof IMultiConditionToken))
        return (IMultiConditionToken)localList.get(i);
    MultiConditionToken localMultiConditionToken = new MultiConditionToken();
    super.addChildElement(localMultiConditionToken);
    return localMultiConditionToken;
  }

  public boolean hasCondition()
  {
    return getWhenCondition().getConditions().hasNext();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.RuleEnterToken
 * JD-Core Version:    0.6.0
 */