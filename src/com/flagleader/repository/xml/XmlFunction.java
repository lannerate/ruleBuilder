package com.flagleader.repository.xml;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.AbstractSubFunction;
import com.flagleader.util.StringUtil;
import java.util.List;

public class XmlFunction extends AbstractSubFunction
{
  public static final String NAME = "XmlFunction";

  public XmlFunction(XmlFunction paramXmlFunction)
  {
    super(paramXmlFunction);
  }

  public XmlFunction()
  {
  }

  public XmlFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
  }

  public XmlFunction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramList);
  }

  public IElement deepClone()
  {
    return new XmlFunction(this);
  }

  public String getName()
  {
    return "XmlFunction";
  }

  public String getVarValue()
  {
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
    {
      if (getValueName().equals("init"))
        return ((XmlNode)getParent()).getVarName() + StringUtil.replace("$p", ((XmlNode)getParent()).getVarName(), getVariableName());
      return ((XmlNode)getParent()).getVarName() + "." + getVariableName();
    }
    return getVariableName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.XmlFunction
 * JD-Core Version:    0.6.0
 */