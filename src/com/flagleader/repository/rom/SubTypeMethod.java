package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.util.StringUtil;
import java.util.List;

public class SubTypeMethod extends AbstractSubFunction
  implements IFunctionObject
{
  public SubTypeMethod(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
  }

  public SubTypeMethod(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramList);
  }

  public SubTypeMethod()
  {
  }

  public String getVarValue()
  {
    if (getParentObject() != null)
      return StringUtil.replace("$p", getParentObject().getVarValue(), getVariableName());
    return getVarPre() + super.getVarValue();
  }

  public IElement deepClone()
  {
    return new SubTypeMethod(this);
  }

  public String getName()
  {
    return "SubTypeMethod";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.SubTypeMethod
 * JD-Core Version:    0.6.0
 */