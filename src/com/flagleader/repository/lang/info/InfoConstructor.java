package com.flagleader.repository.lang.info;

import com.flagleader.repository.IElement;

public class InfoConstructor extends InfoMethod
{
  public InfoConstructor()
  {
  }

  public InfoConstructor(InfoConstructor paramInfoConstructor)
  {
    super(paramInfoConstructor);
  }

  public InfoConstructor(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new InfoConstructor(this);
  }

  public String getName()
  {
    return "InfoConstructor";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.InfoConstructor
 * JD-Core Version:    0.6.0
 */