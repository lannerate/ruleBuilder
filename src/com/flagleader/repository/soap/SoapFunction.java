package com.flagleader.repository.soap;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.AbstractSubFunction;
import java.util.List;

public class SoapFunction extends AbstractSubFunction
{
  public static final String NAME = "SoapFunction";

  public SoapFunction(SoapFunction paramSoapFunction)
  {
    super(paramSoapFunction);
  }

  public SoapFunction()
  {
  }

  public SoapFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
  }

  public SoapFunction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramList);
  }

  public IElement deepClone()
  {
    return new SoapFunction(this);
  }

  public String getName()
  {
    return "SoapFunction";
  }

  public String getVarValue()
  {
    if ((getParent() != null) && ((getParent() instanceof SoapService)))
    {
      if (getValueName().equals("init"))
        return ((SoapService)getParent()).getVarName() + getVariableName();
      return ((SoapService)getParent()).getVarName() + "." + getVariableName();
    }
    return getVariableName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.soap.SoapFunction
 * JD-Core Version:    0.6.0
 */