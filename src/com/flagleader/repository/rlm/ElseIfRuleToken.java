package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.Rule;
import java.util.Iterator;
import java.util.List;

public class ElseIfRuleToken extends AbstractRuleObject
{
  public ElseIfRuleToken(ElseIfRuleToken paramElseIfRuleToken)
  {
    super(paramElseIfRuleToken);
  }

  public ElseIfRuleToken()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitElseIfRuleToken(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IMultiActionToken)) || ((paramIElement instanceof IMultiConditionToken));
  }

  public IElement deepClone()
  {
    return new ElseIfRuleToken(this);
  }

  public String getName()
  {
    return "ElseIfRuleToken";
  }

  public String toString()
  {
    if (getParent() != null)
      return getParent().toString();
    return super.toString();
  }

  private IMultiActionToken a(int paramInt)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof IMultiActionToken)) && (((IMultiActionToken)localList.get(i)).getType() == paramInt))
        return (IMultiActionToken)localList.get(i);
    return null;
  }

  public IMultiActionToken getThenActions()
  {
    if (a(0) != null)
      return a(0);
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IMultiActionToken))
        continue;
      ((IMultiActionToken)localList.get(i)).setType(0);
      return (IMultiActionToken)localList.get(i);
    }
    MultiActionToken localMultiActionToken = new MultiActionToken(0);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
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
 * Qualified Name:     com.flagleader.repository.rlm.ElseIfRuleToken
 * JD-Core Version:    0.6.0
 */