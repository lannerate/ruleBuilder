package com.flagleader.repository.rlm;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.Rule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleToken extends AbstractRuleContainer
  implements IRuleContainer
{
  public RuleToken(RuleToken paramRuleToken)
  {
    super(paramRuleToken);
  }

  public RuleToken()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleToken(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IMultiActionToken)) || ((paramIElement instanceof IMultiConditionToken)) || ((paramIElement instanceof ElseIfRuleToken)) || ((paramIElement instanceof RuleEnterToken));
  }

  public IElement deepClone()
  {
    return new RuleToken(this);
  }

  public String getName()
  {
    return "RuleToken";
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

  public List getElseIfTokens()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    List localList = a();
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof ElseIfRuleToken))
        continue;
      localArrayList.add(localList.get(j));
    }
    return localArrayList;
  }

  public void addElseIfToken()
  {
    List localList = getElseIfTokens();
    ElseIfRuleToken localElseIfRuleToken;
    if (localList.size() > 0)
    {
      localElseIfRuleToken = new ElseIfRuleToken((ElseIfRuleToken)localList.get(localList.size() - 1));
      addChildElement(localElseIfRuleToken);
    }
    else
    {
      localElseIfRuleToken = new ElseIfRuleToken();
      addChildElement(localElseIfRuleToken);
      localElseIfRuleToken.addChildElement(getWhenCondition().deepClone());
      localElseIfRuleToken.addChildElement(getThenActions().deepClone());
    }
  }

  public IMultiActionToken getInitActions()
  {
    if (a(1) != null)
      return a(1);
    MultiActionToken localMultiActionToken = new MultiActionToken(1);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
  }

  public IMultiActionToken getElseActions()
  {
    if (a(3) != null)
      return a(3);
    List localList = a();
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof IMultiActionToken))
        continue;
      if ((i > 0) && (((IMultiActionToken)localList.get(j)).getType() == 0))
      {
        ((IMultiActionToken)localList.get(j)).setType(3);
        return (IMultiActionToken)localList.get(j);
      }
      i++;
    }
    MultiActionToken localMultiActionToken = new MultiActionToken(3);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
  }

  public IMultiActionToken getCatchActions()
  {
    if (a(4) != null)
      return a(4);
    List localList = a();
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof IMultiActionToken))
        continue;
      if ((i > 1) && (((IMultiActionToken)localList.get(j)).getType() == 0))
      {
        ((IMultiActionToken)localList.get(j)).setType(4);
        return (IMultiActionToken)localList.get(j);
      }
      i++;
    }
    MultiActionToken localMultiActionToken = new MultiActionToken(4);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
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
    return (Rule)getRoot();
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

  public RuleEnterToken getEnterCondition()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof RuleEnterToken))
        return (RuleEnterToken)localList.get(i);
    RuleEnterToken localRuleEnterToken = new RuleEnterToken();
    super.addChildElement(localRuleEnterToken);
    return localRuleEnterToken;
  }

  public boolean isEmpty()
  {
    if (hasCondition())
      return false;
    if (hasThenAction())
      return false;
    if (hasElseAction())
      return false;
    return !hasInitAction();
  }

  public boolean hasCondition()
  {
    return getWhenCondition().getConditions().hasNext();
  }

  public boolean hasEnterCondition()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof RuleEnterToken))
        return ((RuleEnterToken)localList.get(i)).hasCondition();
    return false;
  }

  public boolean hasThenOrElseifAction()
  {
    return getAcceptElements(new f(this)).hasNext();
  }

  public boolean hasElseAction()
  {
    return getElseActions().getActions().hasNext();
  }

  public boolean hasCatchAction()
  {
    return getCatchActions().getActions().hasNext();
  }

  public boolean hasThenAction()
  {
    return getThenActions().getActions().hasNext();
  }

  public boolean hasInitAction()
  {
    return getInitActions().getActions().hasNext();
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
          getWhenCondition().addChildElement((IElement)localObject);
          i = 1;
        }
        else
        {
          if (!(localObject instanceof StatementContainerToken))
            continue;
          getThenActions().addChildElement((IElement)localObject);
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
      getWhenCondition().addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof StatementContainerToken))
    {
      initUndoable();
      getThenActions().addChildElement(paramIElement);
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

  public List getRuleTableInfos()
  {
    Rule localRule = getRule();
    ArrayList localArrayList = new ArrayList();
    if (localRule.isSupportEnter())
      localArrayList.add(new e(2, getEnterCondition()));
    if (localRule.isSupportInit())
      localArrayList.add(new e(3, getInitActions()));
    localArrayList.add(new e(0, this));
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof ElseIfRuleToken))
        continue;
      localArrayList.add(new e(1, (ElseIfRuleToken)localList.get(i)));
    }
    if (localRule.isSupportElse())
      localArrayList.add(new e(4, getElseActions()));
    if (localRule.isSupportCatch())
      localArrayList.add(new e(5, getCatchActions()));
    return localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.RuleToken
 * JD-Core Version:    0.6.0
 */