package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;
import java.util.List;

public class DecisionMultiConditionToken extends MultiConditionToken
  implements IRuleContainer
{
  protected ConditionToken d()
  {
    DecisionConditionToken localDecisionConditionToken = new DecisionConditionToken();
    localDecisionConditionToken.init();
    addChildElement(localDecisionConditionToken);
    return localDecisionConditionToken;
  }

  public DecisionMultiConditionToken()
  {
  }

  public DecisionMultiConditionToken(int paramInt)
  {
    super(paramInt);
  }

  public DecisionMultiConditionToken(DecisionMultiConditionToken paramDecisionMultiConditionToken)
  {
    super(paramDecisionMultiConditionToken);
  }

  public boolean pasteElement(IElement paramIElement)
  {
    return super.pasteElement(paramIElement);
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    String str = paramIElement.getUuid();
    if ((paramIElement instanceof ConditionToken))
    {
      IPackageElement localIPackageElement = getRuleTree();
      if ((localIPackageElement != null) && ((localIPackageElement instanceof IRule)))
      {
        Iterator localIterator = ((IRule)localIPackageElement).getAcceptElements(new g(this, str));
        if (localIterator.hasNext())
          paramIElement.setUuid(null);
      }
      else
      {
        int i = a().size();
        for (int j = 0; j < i; j++)
        {
          if ((!(a().get(j) instanceof ConditionToken)) || (!((ConditionToken)a().get(j)).getUuid().equals(paramIElement.getUuid())))
            continue;
          paramIElement.setUuid(null);
        }
      }
    }
    super.addChildElement(paramIElement, paramInt);
  }

  public IElement deepClone()
  {
    return new DecisionMultiConditionToken(this);
  }

  protected ConditionToken e()
  {
    DecisionConditionToken localDecisionConditionToken = new DecisionConditionToken();
    localDecisionConditionToken.init();
    addChildElement(localDecisionConditionToken);
    return localDecisionConditionToken;
  }

  public ModifyToken getConditionModifyToken()
  {
    if (this.a == null)
      setConditionModifyToken(new DecisionMultiConditionToken.AppendToken(this, "&addCondition", new h(this)));
    return this.a;
  }

  public String getName()
  {
    return "DecisionMultiConditionToken";
  }

  public IRuleContainer getRoot()
  {
    return this;
  }

  public IPackageElement getRuleTree()
  {
    if ((getParent() instanceof IPackageElement))
      return (IPackageElement)getParent();
    if ((getParent() instanceof IRuleContainer))
      return ((IRuleContainer)getParent()).getRuleTree();
    return null;
  }

  public boolean isChangeLine(String paramString)
  {
    return false;
  }

  public boolean isEmpty()
  {
    return getConditionList().size() == 0;
  }

  public boolean paste(IElement paramIElement)
  {
    return pasteElement(paramIElement);
  }

  public void setModified(boolean paramBoolean)
  {
    if ((paramBoolean) && (getRuleTree() != null))
      getRuleTree().setModified(paramBoolean);
  }

  public void setNeedSave()
  {
    if (getRuleTree() != null)
      getRuleTree().setNeedSave();
  }

  public String getNote()
  {
    return getText();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.DecisionMultiConditionToken
 * JD-Core Version:    0.6.0
 */