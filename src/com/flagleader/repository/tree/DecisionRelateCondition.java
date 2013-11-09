package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.CustomVariable;
import java.util.List;

public class DecisionRelateCondition extends AbstractRuleContainer
  implements IRuleContainer
{
  private String conditionUuids = "";
  private int conditionPos = 2;

  public DecisionRelateCondition()
  {
  }

  public DecisionRelateCondition(DecisionRelateCondition paramDecisionRelateCondition)
  {
    super(paramDecisionRelateCondition);
    this.conditionUuids = paramDecisionRelateCondition.conditionUuids;
    this.conditionPos = paramDecisionRelateCondition.conditionPos;
  }

  public DecisionRelateCondition(String paramString, int paramInt)
  {
    this.conditionUuids = paramString;
    this.conditionPos = paramInt;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitDecisionRelateCondition(this);
  }

  public IMultiConditionToken getConditions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof IMultiConditionToken))
        return (IMultiConditionToken)localList.get(i);
    DecisionMultiConditionToken localDecisionMultiConditionToken = new DecisionMultiConditionToken(this.conditionPos);
    super.addChildElement(localDecisionMultiConditionToken);
    return localDecisionMultiConditionToken;
  }

  public boolean checkEqualsElementValue(String paramString)
  {
    return getConditionUuids().equals(paramString);
  }

  public IDecision getDecisionRelateRule()
  {
    if ((getParent() != null) && ((getParent() instanceof IDecision)))
      return (IDecision)getParent();
    return null;
  }

  public boolean isValid()
  {
    return (getParent() != null) && ((getParent() instanceof IDecision)) && (((IDecision)getParent()).isValidElement2(this.conditionUuids));
  }

  public IElement deepClone()
  {
    return new DecisionRelateCondition(this);
  }

  public String getName()
  {
    return "DecisionRelateCondition";
  }

  public String getConditionUuids()
  {
    return this.conditionUuids;
  }

  public void setConditionUuids(String paramString)
  {
    this.conditionUuids = paramString;
  }

  public boolean isEmpty()
  {
    return getChildrenCount() == 0;
  }

  public boolean addVariableDebug(CustomVariable paramCustomVariable)
  {
    return false;
  }

  public boolean clearDebug()
  {
    return false;
  }

  public boolean isVisible()
  {
    return false;
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return false;
  }

  public IElement copyElement()
  {
    return null;
  }

  public IElement cutElement()
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement)
  {
    return false;
  }

  public int getConditionPos()
  {
    return this.conditionPos;
  }

  public void setConditionPos(int paramInt)
  {
    this.conditionPos = paramInt;
  }

  public IPackageElement getRuleTree()
  {
    return getDecisionRelateRule();
  }

  public boolean paste(IElement paramIElement)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionRelateCondition
 * JD-Core Version:    0.6.0
 */