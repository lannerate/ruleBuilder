package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MappingFunction extends AbstractBOEditen
  implements IFunctionObject
{
  private String functionName = "";
  private List params = new ArrayList(3);

  public MappingFunction(MappingFunction paramMappingFunction)
  {
    super(paramMappingFunction);
    this.functionName = paramMappingFunction.functionName;
    Iterator localIterator = paramMappingFunction.getParams().iterator();
    while (localIterator.hasNext())
      this.params.add(new MethodParam((MethodParam)localIterator.next()));
  }

  public MappingFunction()
  {
  }

  public MappingFunction(String paramString)
  {
    setFunctionName(paramString);
    f();
  }

  public String getFunctionName()
  {
    return this.functionName;
  }

  public List getParams()
  {
    return this.params;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMappingFunction(this);
  }

  public IElement deepClone()
  {
    return new MappingFunction(this);
  }

  private void f()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.functionName);
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      this.params.add(new MethodParam(localStringBuffer.substring(i + 1, j).trim(), k++));
    }
  }

  public void setFunctionName(String paramString)
  {
    this.functionName = paramString;
  }

  public void addParam(MethodParam paramMethodParam)
  {
    this.params.add(paramMethodParam);
  }

  public int getParamCount()
  {
    return this.params.size();
  }

  public String getValueName()
  {
    return getFunctionName();
  }

  public void setValueName(String paramString)
  {
    setFunctionName(paramString);
  }

  public String getVarValue()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.functionName);
    int i = 1;
    int j = 0;
    int k = 0;
    while (true)
    {
      j = localStringBuffer.indexOf("{", k);
      k = localStringBuffer.indexOf("}", j);
      if ((j >= k) || (j < 0))
        break;
      localStringBuffer.replace(j + 1, k, "arg" + i++);
    }
    String str = localStringBuffer.toString();
    for (int m = 1; m <= this.params.size(); m++)
    {
      MethodParam localMethodParam = (MethodParam)this.params.get(m - 1);
      if (!localMethodParam.hasDefaultValue())
        continue;
      str = StringUtil.replace("{" + localMethodParam.getParamName() + "}", localMethodParam.getDefaultValue(), str);
    }
    return localStringBuffer.toString();
  }

  public void changeParams()
  {
    for (int i = 1; i <= this.params.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.params.get(i - 1);
      if (!localMethodParam.hasDefaultValue())
        continue;
      changeDisplayName(getDisplayName(), StringUtil.replace("{" + localMethodParam.getParamName() + "}", localMethodParam.getDefaultValue(), getDisplayName()));
    }
  }

  public boolean isTypeEditable()
  {
    return true;
  }

  public boolean isValueEditable()
  {
    return true;
  }

  public String getName()
  {
    return "MappingFunction";
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() == 0)
      return getVarValue();
    return super.getDisplayName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.MappingFunction
 * JD-Core Version:    0.6.0
 */