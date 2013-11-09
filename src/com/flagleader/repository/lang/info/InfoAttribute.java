package com.flagleader.repository.lang.info;

import com.flagleader.repository.IElement;

public class InfoAttribute extends InfoMember
{
  public InfoAttribute()
  {
  }

  public InfoAttribute(InfoAttribute paramInfoAttribute)
  {
    super(paramInfoAttribute);
  }

  public InfoAttribute(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new InfoAttribute(this);
  }

  public String getName()
  {
    return "InfoAttribute";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.InfoAttribute
 * JD-Core Version:    0.6.0
 */