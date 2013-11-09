package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import java.util.List;

public class SubFunction extends AbstractSubFunction
  implements IFunctionObject
{
  public SubFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
  }

  public SubFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
  }

  public SubFunction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramList);
  }

  public SubFunction()
  {
  }

  public String getVarValue()
  {
    return getVarPre() + super.getVarValue();
  }

  public IElement deepClone()
  {
    return new SubFunction(this);
  }

  public String getName()
  {
    return "SubFunction";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.SubFunction
 * JD-Core Version:    0.6.0
 */