package com.flagleader.repository.rom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractSubVariable extends AbstractBOEditen
  implements ISubVariable
{
  private String valueName = "";
  private List params = new ArrayList(2);
  private String variableName = "";
  private String varPre = "";

  public AbstractSubVariable(AbstractSubVariable paramAbstractSubVariable)
  {
    super(paramAbstractSubVariable);
    this.valueName = paramAbstractSubVariable.valueName;
    this.variableName = paramAbstractSubVariable.variableName;
    this.varPre = paramAbstractSubVariable.varPre;
    Iterator localIterator = paramAbstractSubVariable.getParams().iterator();
    while (localIterator.hasNext())
      this.params.add(new MethodParam((MethodParam)localIterator.next()));
  }

  public AbstractSubVariable()
  {
  }

  public AbstractSubVariable(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    setDisplayName(sortedDisplayName(paramString4));
    this.valueName = paramString1;
    this.variableName = paramString3;
    if (paramList != null)
      this.params.addAll(paramList);
    changeValueType(paramString2);
  }

  public AbstractSubVariable(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    setDisplayName(sortedDisplayName(paramString5));
    this.valueName = paramString1;
    this.variableName = paramString4;
    this.varPre = paramString3;
    if (paramList != null)
      this.params.addAll(paramList);
    changeValueType(paramString2);
  }

  public String getFunctionName()
  {
    return null;
  }

  public List getParams()
  {
    return this.params;
  }

  public String getShortFunctionName()
  {
    return null;
  }

  public int getParamCount()
  {
    return this.params.size();
  }

  public void addParam(MethodParam paramMethodParam)
  {
    this.params.add(paramMethodParam);
  }

  public String getValueName()
  {
    return this.valueName;
  }

  public String getVarValue()
  {
    if (getParentObject() != null)
      return getParentObject().getVarValue() + getVariableName();
    return this.variableName;
  }

  public void setValueName(String paramString)
  {
    this.valueName = paramString;
  }

  public void setVariableName(String paramString)
  {
    this.variableName = paramString;
  }

  public void setParams(List paramList)
  {
    this.params = paramList;
  }

  public IBusinessObject getParentObject()
  {
    if ((getParent() != null) && ((getParent() instanceof IBusinessObject)))
      return (IBusinessObject)getParent();
    return null;
  }

  public IBusinessObject getRootMember()
  {
    IBusinessObject localIBusinessObject = getParentObject();
    if ((localIBusinessObject instanceof ISubFunction))
      return ((ISubFunction)localIBusinessObject).getRootMember();
    if ((localIBusinessObject instanceof ISubVariable))
      return ((ISubVariable)localIBusinessObject).getRootMember();
    if (localIBusinessObject != null)
      return localIBusinessObject;
    return this;
  }

  public String getVariableName()
  {
    return this.variableName;
  }

  public String getVarPre()
  {
    return this.varPre;
  }

  public void setVarPre(String paramString)
  {
    this.varPre = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    if (paramObject == this)
      return true;
    if (((paramObject instanceof AbstractSubVariable)) && (((AbstractSubVariable)paramObject).getUniqueName().equals(getUniqueName())))
      return true;
    return super.equals(paramObject);
  }

  public boolean canSetLoged()
  {
    return false;
  }

  public boolean isLoged()
  {
    return false;
  }

  public void setLoged(boolean paramBoolean)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.AbstractSubVariable
 * JD-Core Version:    0.6.0
 */