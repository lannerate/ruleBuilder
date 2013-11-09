package com.flagleader.repository.rom;

import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractSubFunction extends AbstractBOEditen
  implements ISubFunction
{
  protected String a = "";
  private List params = new ArrayList(3);
  private String variableName = "";
  private String varPre = "";

  public AbstractSubFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
    this.a = paramAbstractSubFunction.a;
    this.variableName = paramAbstractSubFunction.variableName;
    this.varPre = paramAbstractSubFunction.varPre;
    Iterator localIterator = paramAbstractSubFunction.getParams().iterator();
    while (localIterator.hasNext())
      this.params.add(new MethodParam((MethodParam)localIterator.next()));
  }

  public AbstractSubFunction()
  {
  }

  public AbstractSubFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    setDisplayName(sortedDisplayName(paramString4));
    this.a = paramString1;
    this.variableName = paramString3;
    if (paramList != null)
      this.params.addAll(paramList);
    changeValueType(paramString2);
  }

  public AbstractSubFunction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    setDisplayName(sortedDisplayName(paramString5));
    this.a = paramString1;
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

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSubFunction(this);
  }

  public void addParam(MethodParam paramMethodParam)
  {
    this.params.add(paramMethodParam);
  }

  public String getValueName()
  {
    return this.a;
  }

  public String getVarValue()
  {
    if (getParentObject() != null)
      return getParentObject().getVarValue() + getVariableName();
    return this.variableName;
  }

  public void setValueName(String paramString)
  {
    this.a = paramString;
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
    if (((paramObject instanceof AbstractSubFunction)) && (((AbstractSubFunction)paramObject).getUniqueName().equals(getUniqueName())))
      return true;
    return super.equals(paramObject);
  }

  public void changeParams()
  {
    for (int i = 1; i <= this.params.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.params.get(i - 1);
      if (!localMethodParam.hasDefaultValue())
        continue;
      changeDisplayName(getDisplayName(), StringUtil.replace("{" + localMethodParam.getParamName() + "}", localMethodParam.getDefaultValue(), getDisplayName()));
      this.variableName = StringUtil.replace("{" + localMethodParam.getParamName() + "}", localMethodParam.getDefaultValue(), this.variableName);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.AbstractSubFunction
 * JD-Core Version:    0.6.0
 */