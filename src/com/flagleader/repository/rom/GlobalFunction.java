package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GlobalFunction extends AbstractBOEditen
  implements ISubFunction
{
  private String valueName = "";
  private List params = new ArrayList(3);
  private String variableName = "";

  public GlobalFunction(GlobalFunction paramGlobalFunction)
  {
    super(paramGlobalFunction);
    this.valueName = paramGlobalFunction.valueName;
    this.variableName = paramGlobalFunction.variableName;
    Iterator localIterator = paramGlobalFunction.getParams().iterator();
    while (localIterator.hasNext())
      this.params.add(new MethodParam((MethodParam)localIterator.next()));
  }

  public GlobalFunction()
  {
  }

  public GlobalFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, String paramString5)
  {
    setDisplayName(sortedDisplayName(paramString4));
    this.valueName = paramString1;
    this.variableName = paramString3;
    this.groupName = paramString5;
    if (paramList != null)
      this.params.addAll(paramList);
    changeValueType(paramString2);
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

  public String getFunctionName()
  {
    return this.valueName;
  }

  public List getParams()
  {
    return this.params;
  }

  public String getShortFunctionName()
  {
    return this.valueName;
  }

  public int getParamCount()
  {
    return this.params.size();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitGlobalFunction(this);
  }

  public void addParam(MethodParam paramMethodParam)
  {
    this.params.add(paramMethodParam);
  }

  public String getValueName()
  {
    String str = this.valueName;
    if (str.indexOf("(") >= 0)
      str = str.substring(0, str.indexOf("("));
    StringBuffer localStringBuffer = new StringBuffer(str);
    localStringBuffer.append("(");
    for (int i = 1; i <= this.params.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.params.get(i - 1);
      if (localMethodParam.hasDefaultValue())
        localStringBuffer.append(localMethodParam.getDefaultValue());
      else
        localStringBuffer.append(localMethodParam.getTypeName());
      if (i == this.params.size())
        continue;
      localStringBuffer.append(",");
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  public String getVarValue()
  {
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
    if (localIBusinessObject != null)
      return localIBusinessObject;
    return this;
  }

  public String getVariableName()
  {
    return this.variableName;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    if (paramObject == this)
      return true;
    if (((paramObject instanceof GlobalFunction)) && (((GlobalFunction)paramObject).getUniqueName().equals(getUniqueName())))
      return true;
    return super.equals(paramObject);
  }

  public IElement deepClone()
  {
    return new GlobalFunction(this);
  }

  public String getName()
  {
    return "GlobalFunction";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.GlobalFunction
 * JD-Core Version:    0.6.0
 */