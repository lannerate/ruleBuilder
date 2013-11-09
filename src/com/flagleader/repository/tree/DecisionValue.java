package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.NumberOperatorToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.CustomVariable;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.util.NumberUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DecisionValue extends AbstractRuleContainer
  implements ILineEditen, ILangToken, IRuleContainer
{
  private int x = 0;
  private int y = 0;
  private String conditionUuids = "";
  private String elementUuid = "";
  private String uniqueName = "";

  public DecisionValue()
  {
  }

  public DecisionValue(DecisionValue paramDecisionValue)
  {
    super(paramDecisionValue);
    this.elementUuid = paramDecisionValue.elementUuid;
    this.uniqueName = paramDecisionValue.uniqueName;
    this.conditionUuids = paramDecisionValue.conditionUuids;
  }

  public DecisionValue(int paramInt1, int paramInt2, String paramString)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    setDisplayName(paramString);
  }

  public DecisionValue(List paramList, IConditionToken paramIConditionToken)
  {
    for (int i = 0; (paramList != null) && (i < paramList.size()); i++)
      this.conditionUuids += ((IElement)paramList.get(i)).getUuid();
    if (paramIConditionToken != null)
    {
      this.elementUuid = paramIConditionToken.getUuid();
      this.uniqueName = paramIConditionToken.getText();
    }
  }

  public void setConditions(List paramList)
  {
    for (int i = 0; (paramList != null) && (i < paramList.size()); i++)
      this.conditionUuids += ((IElement)paramList.get(i)).getUuid();
  }

  public void setCondition(IConditionToken paramIConditionToken)
  {
    if (paramIConditionToken != null)
    {
      this.elementUuid = paramIConditionToken.getUuid();
      this.uniqueName = paramIConditionToken.getText();
    }
  }

  public boolean checkEqualsElementValue(List paramList, IConditionToken paramIConditionToken)
  {
    if (paramIConditionToken == null)
      return false;
    String str = "";
    for (int i = 0; i < paramList.size(); i++)
    {
      if (paramList.get(i) == null)
        continue;
      str = str + ((IElement)paramList.get(i)).getUuid();
    }
    return (getConditionUuids().equals(str)) && ((getElementUuid().equals(paramIConditionToken.getUuid())) || (getUniqueName().equals(paramIConditionToken.getText())));
  }

  public boolean checkMatchElementValue(List paramList, IConditionToken paramIConditionToken)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (getConditionUuids().indexOf(((IElement)paramList.get(i)).getUuid()) < 0)
        return false;
    return getElementUuid().equals(paramIConditionToken.getUuid());
  }

  public boolean checkEqualsElementValue(String paramString, IConditionToken paramIConditionToken)
  {
    return (getConditionUuids().equals(paramString)) && ((getElementUuid().equals(paramIConditionToken.getUuid())) || (getUniqueName().equals(paramIConditionToken.getText())));
  }

  public boolean checkElementValue(IConditionToken paramIConditionToken)
  {
    return (getElementUuid().equals(paramIConditionToken.getUuid())) || (getUniqueName().equals(paramIConditionToken.getText()));
  }

  public IValueContainerToken getAssignValue()
  {
    ValueToken localValueToken = null;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof ValueToken))
        continue;
      localValueToken = (ValueToken)localObject;
      break;
    }
    Object localObject = getMemberElement();
    if (localValueToken == null)
    {
      if (localObject != null)
      {
        localValueToken = new ValueToken(2, ((IBusinessObject)localObject).getJavaType().K(), "");
        localValueToken.setFieldType(2);
        addChildElement(localValueToken);
      }
    }
    else if ((localObject != null) && (!localValueToken.getJavaType().equals(((IBusinessObject)localObject).getJavaType())))
      localValueToken.changeValueType(((IBusinessObject)localObject).getJavaType().K());
    return (IValueContainerToken)localValueToken;
  }

  public IBusinessObject getMemberElement()
  {
    if ((getParent() != null) && ((getParent() instanceof DecisionRule)))
      return ((DecisionRule)getParent()).getMemberElement();
    return null;
  }

  public boolean isValid()
  {
    return (getParent() != null) && ((getParent() instanceof IDecision)) && (((IDecision)getParent()).isValidElement(this.conditionUuids));
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitDecisionValue(this);
  }

  public IElement deepClone()
  {
    return new DecisionValue(this);
  }

  public String getName()
  {
    return "DecisionValue";
  }

  public g getJavaType()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    if ((localIBusinessObject != null) && ((localIBusinessObject instanceof IBusinessObject)))
      return localIBusinessObject.getJavaType();
    return getTypeManager().a("string");
  }

  public String getConstantValue()
  {
    IValueContainerToken localIValueContainerToken = getAssignValue();
    if ((localIValueContainerToken != null) && (localIValueContainerToken.getNextValue() == null) && ((localIValueContainerToken.getValueElement() instanceof ConstantToken)))
      return ((ConstantToken)localIValueContainerToken.getValueElement()).getValue();
    return getValue();
  }

  public String getValue()
  {
    IValueContainerToken localIValueContainerToken = getAssignValue();
    if (localIValueContainerToken != null)
      return localIValueContainerToken.toString();
    return "";
  }

  public boolean isTextValue()
  {
    IValueContainerToken localIValueContainerToken = getAssignValue();
    return (localIValueContainerToken != null) && (localIValueContainerToken.getNextValue() == null) && ((localIValueContainerToken.getValueElement() instanceof ConstantToken));
  }

  public boolean isComboValue()
  {
    IValueContainerToken localIValueContainerToken = getAssignValue();
    return (localIValueContainerToken != null) && (localIValueContainerToken.getNextValue() == null) && ((localIValueContainerToken.getValueElement() instanceof ConstantSelectToken));
  }

  public void setValue(ConstantEnum paramConstantEnum)
  {
    if ((getAssignValue() != null) && (getAssignValue().getValueElement() != null) && ((getAssignValue().getValueElement() instanceof ConstantSelectToken)))
      ((ConstantSelectToken)getAssignValue().getValueElement()).setMemberElement(paramConstantEnum);
  }

  public List getComboEnums()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    if (localIBusinessObject != null)
    {
      Iterator localIterator = getEnvionment().getEnums(localIBusinessObject.getValueType(), localIBusinessObject.getDisplayName());
      if (localIterator.hasNext())
      {
        ArrayList localArrayList = new ArrayList();
        while (localIterator.hasNext())
          localArrayList.add(localIterator.next());
        return localArrayList;
      }
    }
    return null;
  }

  public void setValue(String paramString)
  {
    if ((getJavaType().b()) || (getJavaType().j()))
    {
      for (int i = getChildrenCount() - 1; i >= 0; i--)
      {
        if (!(a().get(i) instanceof ValueToken))
          continue;
        ((ValueToken)a().get(i)).dispose();
      }
      a(this, paramString, getJavaType().K());
    }
    else
    {
      if (paramString.equals(getLocalString("emptyValue.edit", "")))
        paramString = "";
      if ((getAssignValue() != null) && (getAssignValue().getValueElement() != null) && ((getAssignValue().getValueElement() instanceof ConstantToken)))
        ((ConstantToken)getAssignValue().getValueElement()).setText(paramString);
    }
  }

  private void a(IElement paramIElement, String paramString1, String paramString2)
  {
    NumberOperatorToken localNumberOperatorToken = new NumberOperatorToken();
    Object localObject1;
    Object localObject2;
    for (int i = localNumberOperatorToken.getCount() - 2; i > 0; i--)
    {
      int j = paramString1.indexOf(localNumberOperatorToken.getTypeName(i));
      if (j < 0)
        j = paramString1.indexOf(localNumberOperatorToken.getLanguageName(i));
      if (j <= 0)
        continue;
      localObject1 = paramString1.substring(0, j);
      if (NumberUtil.isParsedPercent((String)localObject1))
      {
        localObject2 = new ValueToken(2, paramString2, "");
        paramIElement.addChildElement((IElement)localObject2);
        ((ValueToken)localObject2).setFieldType(2);
        if (((String)localObject1).equals(getLocalString("emptyValue.edit", "")))
          localObject1 = "";
        ((ConstantToken)((ValueToken)localObject2).getValueElement()).setValue((String)localObject1);
        ((ValueToken)localObject2).getOperator().setType(i);
        a((IElement)localObject2, paramString1.substring(j + localNumberOperatorToken.getTypeName(i).length()), paramString2);
      }
      else
      {
        localObject2 = new ValueToken(1, paramString2, "");
        paramIElement.addChildElement((IElement)localObject2);
        ((ValueToken)localObject2).setFieldType(1);
        IPackageElement localIPackageElement = ((ValueToken)localObject2).getRoot().getRuleTree();
        if ((localIPackageElement instanceof IRuleTree))
        {
          IBusinessObject localIBusinessObject = ((IRuleTree)localIPackageElement).getBusinessObject((String)localObject1);
          if (localIBusinessObject != null)
            ((MemberToken)((ValueToken)localObject2).getValueElement()).setMemberElement(localIBusinessObject);
        }
        else
        {
          ((MemberToken)((ValueToken)localObject2).getValueElement()).setUniqueName((String)localObject1);
        }
        ((ValueToken)localObject2).getOperator().setType(i);
        a((IElement)localObject2, paramString1.substring(j + localNumberOperatorToken.getTypeName(i).length()), paramString2);
      }
      return;
    }
    String str = paramString1;
    ValueToken localValueToken;
    if (NumberUtil.isParsedPercent(str))
    {
      localValueToken = new ValueToken(2, paramString2, "");
      paramIElement.addChildElement(localValueToken);
      localValueToken.setFieldType(2);
      if (str.equals(getLocalString("emptyValue.edit", "")))
        str = "";
      ((ConstantToken)localValueToken.getValueElement()).setValue(str);
    }
    else
    {
      localValueToken = new ValueToken(1, paramString2, "");
      paramIElement.addChildElement(localValueToken);
      localValueToken.setFieldType(1);
      localObject1 = localValueToken.getRoot().getRuleTree();
      if ((localObject1 instanceof IRuleTree))
      {
        localObject2 = ((IRuleTree)localObject1).getBusinessObject(str);
        if (localObject2 != null)
          ((MemberToken)localValueToken.getValueElement()).setMemberElement((IElement)localObject2);
      }
      else
      {
        ((MemberToken)localValueToken.getValueElement()).setUniqueName(str);
      }
    }
  }

  public int getX()
  {
    return this.x;
  }

  public void setX(int paramInt)
  {
    this.x = paramInt;
  }

  public int getY()
  {
    return this.y;
  }

  public void setY(int paramInt)
  {
    this.y = paramInt;
  }

  public String getConditionUuids()
  {
    return this.conditionUuids;
  }

  public void setConditionUuids(String paramString)
  {
    this.conditionUuids = paramString;
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }

  public boolean isEmpty()
  {
    return getAssignValue() == null;
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
    return paramIElement instanceof IValueContainerToken;
  }

  public IElement copyElement()
  {
    return getElement(0).deepClone();
  }

  public IElement cutElement()
  {
    IElement localIElement = getElement(0);
    removeElement(0);
    setModified(true);
    return localIElement;
  }

  public boolean pasteElement(IElement paramIElement)
  {
    if ((paramIElement instanceof IValueContainerToken))
    {
      removeElement(0);
      addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    return false;
  }

  public String getNote()
  {
    return getValue();
  }

  public ILineEditen getParentLine()
  {
    return this;
  }

  public void findRelateObject(Map paramMap)
  {
    if (getMemberElement() != null)
      paramMap.put(getMemberElement(), getMemberElement());
  }

  public boolean isChanged()
  {
    return false;
  }

  public IPackageElement getRuleTree()
  {
    if ((getParent() != null) && ((getParent() instanceof IPackageElement)))
      return (IPackageElement)getParent();
    return null;
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof IValueContainerToken))
          return pasteElement((IValueContainerToken)localObject);
      }
    }
    else if ((paramIElement instanceof IValueContainerToken))
    {
      removeElement(0);
      addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionValue
 * JD-Core Version:    0.6.0
 */