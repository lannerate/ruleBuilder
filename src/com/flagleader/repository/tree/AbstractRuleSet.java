package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.e.m;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.IVariableObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractRuleSet extends AbstractRuleTree
  implements IRuleSet
{
  public static final int NOTEST = 0;
  public static final int TESTTYPE = 3;
  public static final int FORTYPE = 2;
  public static final int INITTESTTYPE = 1;
  public static final int FOREACHTYPE = 4;
  private int editType = 0;
  private boolean first = false;
  private boolean supportCatch = false;
  private String errorMsg = "";
  private int exceptionType = 1;
  public static final int NOTCATCH = 0;
  public static final int THROWNEW = 1;
  public static final int THROWINCLUDE = 2;
  public static final int STOPTHROW = 3;
  private int checktype = 0;
  public static final int CHECKSUBNONE = 0;
  public static final int CHECKSUBWHOLE = 1;
  public static final int CHECKSUBCONFLICT = 2;
  public static final int CHECKSUBRIGHT = 3;
  private long getAllRuleElementTime = 0L;
  private ArrayList allRules = null;

  public AbstractRuleSet()
  {
  }

  public AbstractRuleSet(AbstractRuleSet paramAbstractRuleSet)
  {
    super(paramAbstractRuleSet);
    this.editType = paramAbstractRuleSet.editType;
    this.first = paramAbstractRuleSet.first;
    this.supportCatch = paramAbstractRuleSet.supportCatch;
    this.errorMsg = paramAbstractRuleSet.errorMsg;
    this.exceptionType = paramAbstractRuleSet.exceptionType;
    this.checktype = paramAbstractRuleSet.checktype;
  }

  public AbstractRuleSet(String paramString)
  {
    super(paramString);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof IRuleTree))
      super.addChildElement(paramIElement, getRuleAndSetCount());
    else
      super.addChildElement(paramIElement, getChildrenCount());
  }

  public boolean canUpdate()
  {
    return true;
  }

  public List getAllRuleElement()
  {
    if ((this.getAllRuleElementTime == getMaxModifyTime()) && (this.allRules != null))
      return this.allRules;
    this.allRules = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IRule))
        this.allRules.add(localObject);
      if (!(localObject instanceof IRuleSet))
        continue;
      this.allRules.addAll(((IRuleSet)localObject).getAllRuleElement());
    }
    this.getAllRuleElementTime = getMaxModifyTime();
    return this.allRules;
  }

  public int getEditType()
  {
    return this.editType;
  }

  public Envionment getEnvionment()
  {
    if ((getParent() != null) && ((getParent() instanceof RuleSet)))
      return ((RuleSet)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleSetFlow)))
      return ((RuleSetFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RuleTreeFlow)))
      return ((RuleTreeFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RulePoolFlow)))
      return ((RulePoolFlow)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof RulePackage)))
      return ((RulePackage)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof Envionment)))
      return (Envionment)getParent();
    if ((getParent() != null) && ((getParent() instanceof RuleHistory)))
      return ((RuleHistory)getParent()).getEnvionment();
    if ((getParent() != null) && ((getParent() instanceof PackageHistory)))
      return ((PackageHistory)getParent()).getEnvionment();
    return super.getEnvionment();
  }

  public int getMaxPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)) && (((IRuleSet)getParent()).getRuleAndSetCount() > 0))
      return ((IRuleSet)getParent()).getRuleAndSetCount();
    return 0;
  }

  public int getMinPos()
  {
    return 0;
  }

  public int getPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)) && (getParent().getElementPos(this) >= 0))
      return getParent().getElementPos(this);
    return 0;
  }

  public Iterator getRuleAndSets()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList.iterator();
  }

  public int getRuleTableCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      i += ((IRuleTree)localObject).getRuleTableCount();
    }
    return i;
  }

  public int getMaxDeepin()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IRuleSet))
      {
        int j = ((IRuleSet)localObject).getMaxDeepin();
        if (j <= i)
          continue;
        i = j;
      }
      else
      {
        if ((!(localObject instanceof IRule)) || (i != 0))
          continue;
        i = 1;
      }
    }
    return i + 1;
  }

  public List getRulesList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public boolean isForType()
  {
    return this.editType == 2;
  }

  public boolean isForEachType()
  {
    return this.editType == 4;
  }

  public boolean isTestType()
  {
    return this.editType == 3;
  }

  public boolean isInitTestType()
  {
    return this.editType == 1;
  }

  protected boolean b()
  {
    return super.b();
  }

  public void setEditType(int paramInt)
  {
    this.editType = paramInt;
  }

  public void setPos(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleSet)))
    {
      if (paramInt < 0)
        return;
      if (getParent().getElementPos(this) == paramInt)
        return;
      getParent().removeChildElement(this);
      getParent().addChildElement(this, paramInt);
    }
  }

  public String toString()
  {
    if (getParent() != null)
      return getParent().toString() + "-" + getDisplayName();
    return getDisplayName();
  }

  public int getRuleAndSetCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      i++;
    }
    return i;
  }

  public String getInfo()
  {
    return new m().b(getRuleSetToken().getTestConditions());
  }

  protected String d()
  {
    return new m().b(getRuleSetToken());
  }

  public void removeChildElement(IElement paramIElement)
  {
    super.removeChildElement(paramIElement);
  }

  public RuleSetToken getRuleSetToken()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((localObject instanceof RuleSetToken))
        return (RuleSetToken)localObject;
    }
    Object localObject = new RuleSetToken();
    addChildElement((IElement)localObject);
    return (RuleSetToken)localObject;
  }

  public void setRuleSetToken(RuleSetToken paramRuleSetToken)
  {
    getRuleSetToken().setElementEditor(null);
    getRuleSetToken().dispose();
    super.addChildElement(paramRuleSetToken);
  }

  public boolean addVariableDebug(IVariableObject paramIVariableObject)
  {
    boolean bool = false;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IDebugNode))
        continue;
      bool = ((IDebugNode)localObject).addVariableDebug(paramIVariableObject);
    }
    return bool;
  }

  public boolean clearDebug()
  {
    boolean bool = false;
    if (getRuleSetToken().getInitActions().clearDebug())
      bool = true;
    if (getRuleSetToken().getBlockActions().clearDebug())
      bool = true;
    if (getRuleSetToken().getFirstActions().clearDebug())
      bool = true;
    if (getRuleSetToken().getCatchActions().clearDebug())
      bool = true;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IDebugNode))
        continue;
      bool = ((IDebugNode)localObject).clearDebug();
    }
    return bool;
  }

  public boolean isEmpty()
  {
    if (getRuleSetToken().getTestConditions().getConditions().hasNext())
      return false;
    if (getRuleSetToken().getInitActions().getActions().hasNext())
      return false;
    if (getRuleSetToken().getBlockActions().getActions().hasNext())
      return false;
    if (getRuleSetToken().getFirstActions().getActions().hasNext())
      return false;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IRuleContainer)) && (!((IRuleContainer)localObject).isEmpty()))
        return false;
      if (((localObject instanceof IRuleTree)) && (!((IRuleTree)localObject).isEmpty()))
        return false;
    }
    return true;
  }

  public boolean canVmlShow()
  {
    List localList = getAllRuleElement();
    for (int i = 0; i < localList.size(); i++)
      if (((IRule)localList.get(i)).canVmlShow())
        return true;
    return super.canVmlShow();
  }

  public Map getRelateObjectMap(Map paramMap)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    for (int i = 0; i < a().size(); i++)
      if ((a().get(i) instanceof IRuleObject))
      {
        ((IRuleObject)a().get(i)).findRelateObject(paramMap);
      }
      else
      {
        if (!(a().get(i) instanceof IRuleTree))
          continue;
        ((IRuleTree)a().get(i)).getRelateObjectMap(paramMap);
      }
    return paramMap;
  }

  public Map getAssignObjectMap(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    for (int i = 0; i < a().size(); i++)
      if ((a().get(i) instanceof IRuleObject))
      {
        ((IRuleObject)a().get(i)).findAssignObject(paramMap, paramBoolean);
      }
      else
      {
        if (!(a().get(i) instanceof IRuleTree))
          continue;
        ((IRuleTree)a().get(i)).getAssignObjectMap(paramMap, paramBoolean);
      }
    return paramMap;
  }

  public List getRelateVarNames()
  {
    List localList = getEnvionment().getRelateVarNames();
    HashMap localHashMap = new HashMap();
    getRelateObjectMap(localHashMap);
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (localHashMap.get(localList.get(i)) != null)
        continue;
      localList.remove(i);
    }
    localHashMap.clear();
    return localList;
  }

  public boolean replaceVariable(Map paramMap)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IRuleTree))
      {
        ((IRuleTree)localObject).replaceVariable(paramMap);
      }
      else
      {
        if ((!(localObject instanceof RuleFlowTransition)) || (!super.a(paramMap, (RuleFlowTransition)localObject)))
          continue;
        setModified(true);
      }
    }
    if (super.a(paramMap, getRuleSetToken()))
    {
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean isFirst()
  {
    return this.first;
  }

  public void setFirst(boolean paramBoolean)
  {
    this.first = paramBoolean;
  }

  public String getErrorMsg()
  {
    return this.errorMsg;
  }

  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }

  public int getExceptionType()
  {
    return this.exceptionType;
  }

  public void setExceptionType(int paramInt)
  {
    this.exceptionType = paramInt;
  }

  public boolean isSupportCatch()
  {
    return this.supportCatch;
  }

  public void setSupportCatch(boolean paramBoolean)
  {
    this.supportCatch = paramBoolean;
  }

  public int getChecktype()
  {
    return this.checktype;
  }

  public void setChecktype(int paramInt)
  {
    this.checktype = paramInt;
  }

  public CheckRuleInfo getCheckRuleInfo()
  {
    List localList = a();
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
      if ((localList.get(j) instanceof CheckRuleInfo))
        return (CheckRuleInfo)localList.get(j);
    CheckRuleInfo localCheckRuleInfo = new CheckRuleInfo();
    localCheckRuleInfo.initTestInfo();
    addChildElement(localCheckRuleInfo);
    return localCheckRuleInfo;
  }

  public boolean supportVisitRule()
  {
    if (super.supportVisitRule())
      return true;
    return needCheckSubRule();
  }

  public boolean needCheckSubRule()
  {
    return this.checktype > 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractRuleSet
 * JD-Core Version:    0.6.0
 */