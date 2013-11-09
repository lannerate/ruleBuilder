package com.flagleader.repository.rlm;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.condition.ForEachConditionToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.CustomVariable;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;
import java.util.List;

public class RuleSetToken extends AbstractRuleContainer
  implements IRuleContainer
{
  public RuleSetToken(RuleSetToken paramRuleSetToken)
  {
    super(paramRuleSetToken);
  }

  public RuleSetToken()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleSetToken(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IMultiActionToken)) || ((paramIElement instanceof IMultiConditionToken)) || ((paramIElement instanceof ForEachConditionToken));
  }

  public IElement deepClone()
  {
    return new RuleSetToken(this);
  }

  public String getName()
  {
    return "RuleSetToken";
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
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
      if (((localList.get(j) instanceof IMultiActionToken)) && (((IMultiActionToken)localList.get(j)).getType() == paramInt))
        return (IMultiActionToken)localList.get(j);
    return null;
  }

  public boolean isEmpty()
  {
    if (getTestConditions().getConditions().hasNext())
      return false;
    if (getInitActions().getActions().hasNext())
      return false;
    if (getBlockActions().getActions().hasNext())
      return false;
    return !getFirstActions().getActions().hasNext();
  }

  public IMultiActionToken getInitActions()
  {
    if (a(2) != null)
      return a(2);
    MultiActionToken localMultiActionToken = new MultiActionToken(2);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
  }

  public IMultiActionToken getBlockActions()
  {
    Object localObject = a(5);
    if (localObject != null)
      return localObject;
    localObject = new MultiActionToken(5);
    super.addChildElement((IElement)localObject);
    return (IMultiActionToken)localObject;
  }

  public IMultiActionToken getCatchActions()
  {
    Object localObject = a(4);
    if (localObject != null)
      return localObject;
    localObject = new MultiActionToken(4);
    super.addChildElement((IElement)localObject);
    return (IMultiActionToken)localObject;
  }

  public IMultiActionToken getFirstActions()
  {
    if (a(6) != null)
      return a(6);
    MultiActionToken localMultiActionToken = new MultiActionToken(6);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
  }

  public IMultiConditionToken getTestConditions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof IMultiConditionToken))
        return (IMultiConditionToken)localList.get(i);
    MultiConditionToken localMultiConditionToken = new MultiConditionToken();
    super.addChildElement(localMultiConditionToken);
    return localMultiConditionToken;
  }

  public ForEachConditionToken getForEachConditionToken()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof ForEachConditionToken))
        return (ForEachConditionToken)localList.get(i);
    ForEachConditionToken localForEachConditionToken = new ForEachConditionToken();
    localForEachConditionToken.init();
    super.addChildElement(localForEachConditionToken);
    return localForEachConditionToken;
  }

  public AbstractRuleSet getRuleSet()
  {
    if ((getParent() instanceof AbstractRuleSet))
      return (AbstractRuleSet)getParent();
    return (AbstractRuleSet)getRoot();
  }

  public void addVariableDebug(CustomVariable paramCustomVariable)
  {
  }

  public void clearDebug()
  {
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      initUndoable();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof IConditionToken))
        {
          getTestConditions().addChildElement((IElement)localObject);
          i = 1;
        }
        else
        {
          if (!(localObject instanceof StatementContainerToken))
            continue;
          getInitActions().addChildElement((IElement)localObject);
          i = 1;
        }
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      return true;
    }
    if ((paramIElement instanceof IConditionToken))
    {
      initUndoable();
      getTestConditions().addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof StatementContainerToken))
    {
      initUndoable();
      getInitActions().addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    return false;
  }

  public IRuleContainer getRoot()
  {
    return this;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.RuleSetToken
 * JD-Core Version:    0.6.0
 */