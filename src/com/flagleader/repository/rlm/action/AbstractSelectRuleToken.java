package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractSelectRuleToken extends AbstractRuleObject
  implements ISelectRulePackageEditen
{
  private String exeRuleName = "";
  private String exeRuleDisplay = "";
  private IRuleClass dbRule = null;

  public AbstractSelectRuleToken()
  {
  }

  public AbstractSelectRuleToken(AbstractSelectRuleToken paramAbstractSelectRuleToken)
  {
    super(paramAbstractSelectRuleToken);
    this.exeRuleName = paramAbstractSelectRuleToken.exeRuleName;
    this.exeRuleDisplay = paramAbstractSelectRuleToken.exeRuleDisplay;
  }

  public IRuleClass getSourceSheet()
  {
    if (this.dbRule != null)
      return this.dbRule;
    IRuleClass localIRuleClass = null;
    if ((getExeRuleName().length() > 0) || (getExeRuleDisplay().length() > 0))
      localIRuleClass = a(getExeRuleName(), getExeRuleDisplay());
    if (localIRuleClass != null)
    {
      setExeRuleName(localIRuleClass.getVisitExeName());
      setExeRuleDisplay(localIRuleClass.getDisplayName());
      this.dbRule = localIRuleClass;
    }
    return localIRuleClass;
  }

  public void setSourceSheet(IRuleClass paramIRuleClass)
  {
    if (paramIRuleClass != null)
    {
      this.exeRuleName = paramIRuleClass.getVisitExeName();
      this.exeRuleDisplay = paramIRuleClass.getDisplayName();
      this.dbRule = paramIRuleClass;
    }
    else
    {
      this.exeRuleName = "";
      this.exeRuleDisplay = "";
    }
  }

  protected IRuleClass a(String paramString1, String paramString2)
  {
    IElement localIElement = getRootParent();
    Iterator localIterator = null;
    if (((localIElement instanceof RuleRepository)) || ((localIElement instanceof RuleProject)))
    {
      localIterator = localIElement.getAcceptElements(new a(this, paramString1));
      if (localIterator.hasNext())
        return (IRuleClass)localIterator.next();
      localIterator = localIElement.getAcceptElements(new b(this, paramString2));
      if (localIterator.hasNext())
        return (IRulePackage)localIterator.next();
    }
    return null;
  }

  public List getSelectedFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof PackageFieldGet))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public List getSelectedWheres()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof PackageFieldSet))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public void resetFieldMappings(boolean paramBoolean)
  {
    List localList1 = getCanSelectSourceFields();
    if ((localList1 != null) && (localList1.size() > 0))
    {
      for (int i = getChildrenCount() - 1; i >= 0; i--)
      {
        localObject1 = (AbstractPackageField)a().get(i);
        if (paramBoolean)
        {
          if (!(localObject1 instanceof PackageFieldSet))
            continue;
          ((AbstractPackageField)localObject1).dispose();
        }
        else
        {
          if (!(localObject1 instanceof PackageFieldGet))
            continue;
          ((AbstractPackageField)localObject1).dispose();
        }
      }
      List localList2 = getCanSelectFields();
      Object localObject1 = new HashMap(localList2.size());
      Object localObject2;
      for (int j = 0; j < localList1.size(); j++)
      {
        localObject2 = ((IBusinessObject)localList1.get(j)).getValueName();
        for (int k = 0; k < localList2.size(); k++)
        {
          if (!((IBusinessObject)localList2.get(k)).getValueName().equalsIgnoreCase((String)localObject2))
            continue;
          ((HashMap)localObject1).put(localList1.get(j), localList2.remove(k));
          break;
        }
      }
      for (j = 0; j < localList1.size(); j++)
      {
        if ((((HashMap)localObject1).get(localList1.get(j)) != null) || (localList2.size() <= 0))
          continue;
        ((HashMap)localObject1).put(localList1.get(j), localList2.remove(0));
      }
      for (j = 0; j < localList1.size(); j++)
      {
        if (((HashMap)localObject1).get(localList1.get(j)) == null)
          continue;
        if (paramBoolean)
        {
          localObject2 = new PackageFieldSet((IBusinessObject)localList1.get(j), (IBusinessObject)((HashMap)localObject1).get(localList1.get(j)));
          addChildElement((IElement)localObject2);
        }
        else
        {
          localObject2 = new PackageFieldGet((IBusinessObject)localList1.get(j), (IBusinessObject)((HashMap)localObject1).get(localList1.get(j)), "");
          addChildElement((IElement)localObject2);
        }
      }
      setModified(true);
    }
  }

  public List getCanSelectFields()
  {
    Iterator localIterator = getEnvionment().getAcceptElements(new c(this));
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    return localArrayList;
  }

  public List getCanSelectSourceFields()
  {
    IRuleClass localIRuleClass = getSourceSheet();
    if (localIRuleClass != null)
    {
      Iterator localIterator = localIRuleClass.getEnvionment().getAcceptElements(new d(this));
      ArrayList localArrayList = new ArrayList();
      while (localIterator.hasNext())
        localArrayList.add(localIterator.next());
      return localArrayList;
    }
    return null;
  }

  public List getCanSelectSources()
  {
    IElement localIElement = getRootParent();
    Iterator localIterator = null;
    if (((localIElement instanceof IRuleRepository)) || ((localIElement instanceof IRuleProject)))
      localIterator = localIElement.getAcceptElements(new e(this));
    ArrayList localArrayList = new ArrayList();
    if (localIterator != null)
      while (localIterator.hasNext())
        localArrayList.add(localIterator.next());
    return localArrayList;
  }

  public String getText()
  {
    return getDisplayName();
  }

  public boolean hasSelects()
  {
    return true;
  }

  public void setText(String paramString)
  {
  }

  public String getDisplayName()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (getSourceSheet() != null)
      localStringBuffer.append(getSourceSheet().getDisplayName());
    else if (StringUtil.isEmpty(this.exeRuleDisplay))
      localStringBuffer.append(this.exeRuleDisplay);
    else
      localStringBuffer.append(this.exeRuleName);
    int i = 0;
    for (int j = 0; j < getChildrenCount(); j++)
    {
      if (!(a().get(j) instanceof PackageFieldSet))
        continue;
      if (i == 0)
      {
        localStringBuffer.append(" " + getLocalString("exeBack.edit") + " ");
        i = 1;
      }
      PackageFieldSet localPackageFieldSet = (PackageFieldSet)a().get(j);
      localStringBuffer.append(localPackageFieldSet.getValue()).append(" ");
    }
    if (localStringBuffer.length() > 0)
      return localStringBuffer.substring(0, localStringBuffer.length());
    return getLocalString("selectAction.edit");
  }

  public boolean canEdit()
  {
    return true;
  }

  public String getColorType()
  {
    return "value";
  }

  public String getHint()
  {
    return "";
  }

  public boolean hasGetAndSet()
  {
    for (int i = 0; i < getChildrenCount(); i++)
      if ((a().get(i) instanceof AbstractPackageField))
        return true;
    return false;
  }

  public String getNote()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof AbstractPackageField))
        continue;
      AbstractPackageField localAbstractPackageField = (AbstractPackageField)a().get(i);
      localStringBuffer.append(localAbstractPackageField.toString()).append("\n");
    }
    return localStringBuffer.toString();
  }

  public boolean hasHint()
  {
    return false;
  }

  public String getExeRuleName()
  {
    return this.exeRuleName;
  }

  public void setExeRuleName(String paramString)
  {
    this.exeRuleName = paramString;
  }

  public String getShowRuleDisplay()
  {
    if (!StringUtil.isEmpty(this.exeRuleDisplay))
      return this.exeRuleDisplay;
    if ((this.exeRuleName.startsWith("{")) && (this.exeRuleName.endsWith("}")))
    {
      IBusinessObject localIBusinessObject = getEnvionment().getBusinessDisName(this.exeRuleName.substring(1, this.exeRuleName.length() - 1));
      if (localIBusinessObject != null)
        return this.exeRuleName.substring(1, this.exeRuleName.length() - 1);
    }
    return this.exeRuleName;
  }

  public String getExeRuleDisplay()
  {
    return this.exeRuleDisplay;
  }

  public void setExeRuleDisplay(String paramString)
  {
    this.exeRuleDisplay = paramString;
  }

  public IRuleClass getDbRule()
  {
    return this.dbRule;
  }

  public void setDbRule(IRuleClass paramIRuleClass)
  {
    this.dbRule = paramIRuleClass;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.AbstractSelectRuleToken
 * JD-Core Version:    0.6.0
 */