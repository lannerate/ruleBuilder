package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;

public class RuleLogConditionToken extends MultiConditionToken
  implements IRuleContainer
{
  protected ConditionToken d()
  {
    LogConditionToken localLogConditionToken = new LogConditionToken();
    localLogConditionToken.init();
    addChildElement(localLogConditionToken);
    return localLogConditionToken;
  }

  public RuleLogConditionToken()
  {
  }

  public RuleLogConditionToken(int paramInt)
  {
    super(paramInt);
  }

  public RuleLogConditionToken(RuleLogConditionToken paramRuleLogConditionToken)
  {
    super(paramRuleLogConditionToken);
  }

  public boolean pasteElement(IElement paramIElement)
  {
    return super.pasteElement(paramIElement);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof ConditionToken))
    {
      int i = a().size();
      for (int j = 0; j < i; j++)
      {
        if ((!(a().get(j) instanceof ConditionToken)) || (!((ConditionToken)a().get(j)).getUuid().equals(paramIElement.getUuid())))
          continue;
        paramIElement.setUuid(null);
      }
    }
    super.addChildElement(paramIElement);
  }

  public IElement deepClone()
  {
    return new RuleLogConditionToken(this);
  }

  protected ConditionToken e()
  {
    LogConditionToken localLogConditionToken = new LogConditionToken();
    localLogConditionToken.init();
    addChildElement(localLogConditionToken);
    return localLogConditionToken;
  }

  public ModifyToken getConditionModifyToken()
  {
    if (this.a == null)
      setConditionModifyToken(new RuleLogConditionToken.AppendToken(this, "&addCondition", new r(this)));
    return this.a;
  }

  public String getName()
  {
    return "RuleLogConditionToken";
  }

  public IRuleContainer getRoot()
  {
    return this;
  }

  public IPackageElement getRuleTree()
  {
    if ((getParent() instanceof IPackageElement))
      return (IPackageElement)getParent();
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
    return super.pasteElement(paramIElement);
  }

  public void setModified(boolean paramBoolean)
  {
    if ((paramBoolean) && (getRuleTree() != null))
      getRuleTree().setModified(paramBoolean);
  }

  public String getNote()
  {
    return getText();
  }

  public void setNeedSave()
  {
    if (getRuleTree() != null)
      getRuleTree().setNeedSave();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.RuleLogConditionToken
 * JD-Core Version:    0.6.0
 */