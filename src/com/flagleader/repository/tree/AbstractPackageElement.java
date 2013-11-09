package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.rlm.AbstractElementToken;
import com.flagleader.repository.rlm.value.SheetAndFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetAndWheresSelectToken;
import com.flagleader.repository.rlm.value.SheetDynamicSelectToken;
import com.flagleader.repository.rlm.value.SheetFentanMapping;
import com.flagleader.repository.rlm.value.SheetFentanSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rlm.value.SheetFieldSelectToken;
import com.flagleader.repository.rlm.value.SheetFieldsSelectToken;
import com.flagleader.repository.rlm.value.SheetFunction;
import com.flagleader.repository.rlm.value.SheetFunctionsSelectToken;
import com.flagleader.repository.rlm.value.SheetWhere;
import com.flagleader.repository.rlm.value.SheetWheresSelectToken;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractPackageElement extends AbstractTreeNode
  implements IPackageElement
{
  public AbstractPackageElement(AbstractPackageElement paramAbstractPackageElement)
  {
    super(paramAbstractPackageElement);
  }

  public AbstractPackageElement()
  {
  }

  public AbstractPackageElement(String paramString)
  {
    super(paramString);
  }

  public IRulePackage getMainPackage()
  {
    for (Object localObject = this; (localObject != null) && (!(localObject instanceof RulePackage)); localObject = ((IElement)localObject).getParent());
    if ((localObject != null) && ((localObject instanceof RulePackage)))
      return (RulePackage)localObject;
    return (IRulePackage)null;
  }

  public Envionment getEnvionment()
  {
    if ((this instanceof Envionment))
      return (Envionment)this;
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return (Envionment)getParent();
    if (getMainPackage() != null)
      return getMainPackage().getEnvionment();
    return null;
  }

  public boolean isDevelopModel()
  {
    return (getMainPackage() == null) || (getMainPackage().isDeveloper());
  }

  public boolean isChangedshint()
  {
    if ((getMainPackage() != null) && (getMainPackage().canFindHistory()))
    {
      IPackageElement localIPackageElement = getMainPackage().findRuleHistory(getUuid(), toString());
      if ((localIPackageElement == null) || (!(localIPackageElement instanceof AbstractPackageElement)) || (!getText().equals(((AbstractPackageElement)localIPackageElement).getText())))
        return true;
    }
    return this.e;
  }

  public List getAllVars()
  {
    if (getEnvionment() != null)
      return getEnvionment().getAllVars();
    return new ArrayList(0);
  }

  public List getAllVarDisplays()
  {
    if (getEnvionment() != null)
      return getEnvionment().getAllVarDisplays();
    return new ArrayList(0);
  }

  public IPackageElement findTreeNode(String paramString)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof IPackageElement))
        continue;
      IPackageElement localIPackageElement = (IPackageElement)a().get(i);
      if (localIPackageElement.getUuid().equals(paramString))
        return localIPackageElement;
      if (localIPackageElement.findTreeNode(paramString) != null)
        return localIPackageElement.findTreeNode(paramString);
    }
    return null;
  }

  public boolean isVisible()
  {
    return (getMainPackage() == null) || (canVmlShow()) || (getMainPackage().isDeveloper());
  }

  public String getCurrentUser()
  {
    if (getMainPackage() != null)
      return getMainPackage().getCurrentUser();
    return RuleRepository.getLocalip();
  }

  public void setNeedSave()
  {
    this.d = true;
  }

  public long getReloadTime()
  {
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
    {
      long l = localEnvionment.getMaxModifyTime();
      if (l > getModifyTime())
        return l;
    }
    return getModifyTime();
  }

  protected void a(List paramList, IElement paramIElement, IBusinessObject paramIBusinessObject)
  {
    if (((paramIBusinessObject instanceof IBOAndContainer)) || ((paramIBusinessObject instanceof IExcelObject)) || ((paramIBusinessObject instanceof TreeValueNode)) || ((paramIBusinessObject instanceof XmlNode)) || ((paramIBusinessObject instanceof SoapService)))
    {
      if ((paramIElement instanceof AbstractElementToken))
      {
        localObject = ((AbstractElementToken)paramIElement).getMemberElement();
        if ((localObject != null) && (((IElement)localObject).getParent().equals(paramIBusinessObject)))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof DecisionElement))
      {
        localObject = ((DecisionElement)paramIElement).getMemberElement();
        if ((localObject != null) && (((IElement)localObject).getParent().equals(paramIBusinessObject)))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof DecisionElementValue))
      {
        localObject = ((DecisionElementValue)paramIElement).getMemberElement();
        if ((localObject != null) && (((IElement)localObject).getParent().equals(paramIBusinessObject)))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof SheetAndFieldsSelectToken))
      {
        if (paramIBusinessObject.equals(((SheetAndFieldsSelectToken)paramIElement).getSourceSheet()))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof SheetFentanSelectToken))
      {
        if (paramIBusinessObject.equals(((SheetFentanSelectToken)paramIElement).getSourceSheet(true)))
          paramList.add(paramIElement);
        if (paramIBusinessObject.equals(((SheetFentanSelectToken)paramIElement).getSourceSheet(false)))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof SheetDynamicSelectToken))
      {
        if (paramIBusinessObject.equals(((SheetDynamicSelectToken)paramIElement).getSourceSheet()))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof SheetAndWheresSelectToken))
      {
        if (paramIBusinessObject.equals(((SheetAndWheresSelectToken)paramIElement).getSourceSheet()))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof SheetWheresSelectToken))
      {
        if (paramIBusinessObject.equals(((SheetWheresSelectToken)paramIElement).getMemberElement()))
          paramList.add(paramIElement);
      }
      else if ((paramIElement instanceof SheetFunctionsSelectToken))
      {
        if (paramIBusinessObject.equals(((SheetFunctionsSelectToken)paramIElement).getMemberElement()))
          paramList.add(paramIElement);
      }
      else if (((paramIElement instanceof SheetFieldsSelectToken)) && (paramIBusinessObject.equals(((SheetFieldsSelectToken)paramIElement).getMemberElement())))
      {
        paramList.add(paramIElement);
      }
    }
    else if ((paramIElement instanceof AbstractElementToken))
    {
      localObject = ((AbstractElementToken)paramIElement).getMemberElement();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof DecisionElement))
    {
      localObject = ((DecisionElement)paramIElement).getMemberElement();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof DecisionElementValue))
    {
      localObject = ((DecisionElementValue)paramIElement).getMemberElement();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof SheetFieldMapping))
    {
      localObject = ((SheetFieldMapping)paramIElement).getMemberElement();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
      localObject = ((SheetFieldMapping)paramIElement).getMappingField();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof SheetFentanMapping))
    {
      localObject = ((SheetFentanMapping)paramIElement).getMemberElement();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
      localObject = ((SheetFentanMapping)paramIElement).getMappingField();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
      localObject = ((SheetFentanMapping)paramIElement).getBField();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof RulePoolValue))
    {
      localObject = ((RulePoolValue)paramIElement).getSelected();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof SheetFieldSelectToken))
    {
      localObject = ((SheetFieldSelectToken)paramIElement).getSelected();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof SheetFieldsSelectToken))
    {
      localObject = ((SheetFieldsSelectToken)paramIElement).getSelectedElements();
      for (int i = 0; i < ((List)localObject).size(); i++)
      {
        if ((((List)localObject).get(i) == null) || (!((IBusinessObject)((List)localObject).get(i)).equals(paramIBusinessObject)))
          continue;
        paramList.add(paramIElement);
        break;
      }
    }
    else if ((paramIElement instanceof SheetFunction))
    {
      localObject = ((SheetFunction)paramIElement).getField();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    else if ((paramIElement instanceof SheetWhere))
    {
      localObject = ((SheetWhere)paramIElement).getField();
      if ((localObject != null) && (localObject.equals(paramIBusinessObject)))
        paramList.add(paramIElement);
    }
    Object localObject = paramIElement.getChildrenIterator();
    while (((Iterator)localObject).hasNext())
      a(paramList, (IElement)((Iterator)localObject).next(), paramIBusinessObject);
  }

  public List getAllElementSelect(IBusinessObject paramIBusinessObject)
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, this, paramIBusinessObject);
    if (((this instanceof DecisionRule)) && (((DecisionRule)this).getMemberElement() != null) && (((DecisionRule)this).getMemberElement().equals(paramIBusinessObject)))
      localArrayList.add(this);
    return localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractPackageElement
 * JD-Core Version:    0.6.0
 */