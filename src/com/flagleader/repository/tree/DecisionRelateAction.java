package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rom.CustomVariable;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class DecisionRelateAction extends AbstractRuleContainer
  implements IRuleContainer
{
  private String conditionUuids = "";

  public DecisionRelateAction()
  {
  }

  public DecisionRelateAction(DecisionRelateAction paramDecisionRelateAction)
  {
    super(paramDecisionRelateAction);
    this.conditionUuids = paramDecisionRelateAction.conditionUuids;
  }

  public DecisionRelateAction(String paramString)
  {
    this.conditionUuids = paramString;
  }

  public DecisionRelateAction(List paramList)
  {
    for (int i = 0; (paramList != null) && (i < paramList.size()); i++)
      this.conditionUuids += ((IElement)paramList.get(i)).getUuid();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitDecisionRelateAction(this);
  }

  public MultiActionToken getThenActions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IMultiActionToken))
        continue;
      ((IMultiActionToken)localList.get(i)).setType(0);
      return (MultiActionToken)localList.get(i);
    }
    MultiActionToken localMultiActionToken = new MultiActionToken(0);
    super.addChildElement(localMultiActionToken);
    return localMultiActionToken;
  }

  public boolean checkEqualsElementValue(String paramString)
  {
    return getConditionUuids().equals(paramString);
  }

  public boolean checkEqualsElementValue(List paramList)
  {
    String str = "";
    for (int i = 0; i < paramList.size(); i++)
    {
      if (paramList.get(i) == null)
        continue;
      str = str + ((IElement)paramList.get(i)).getUuid();
    }
    return getConditionUuids().equals(str);
  }

  public IDecision getDecisionRelateRule()
  {
    if ((getParent() != null) && ((getParent() instanceof IDecision)))
      return (IDecision)getParent();
    return null;
  }

  public int getHeight()
  {
    return StringUtils.countMatches(getThenActions().getText(), "\n");
  }

  public boolean isValid()
  {
    return (getParent() != null) && ((getParent() instanceof IDecision)) && (((IDecision)getParent()).isValidElement(this.conditionUuids));
  }

  public IElement deepClone()
  {
    return new DecisionRelateAction(this);
  }

  public String getName()
  {
    return "DecisionRelateAction";
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
    return !getThenActions().getActions().hasNext();
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
 * Qualified Name:     com.flagleader.repository.tree.DecisionRelateAction
 * JD-Core Version:    0.6.0
 */