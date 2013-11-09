package com.flagleader.repository.lang.info;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;

public class InfoParameter extends AbstractElement
{
  String a;
  String b;

  public InfoParameter()
  {
  }

  public InfoParameter(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.b = paramString3;
    this.a = paramString2;
  }

  public InfoParameter(InfoParameter paramInfoParameter)
  {
    super(paramInfoParameter);
    this.a = paramInfoParameter.a;
    this.b = paramInfoParameter.b;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new InfoParameter(this);
  }

  public String getName()
  {
    return "InfoParameter";
  }

  public String getArgName()
  {
    return this.a;
  }

  public void setArgName(String paramString)
  {
    this.a = paramString;
  }

  public String getTypeName()
  {
    return this.b;
  }

  public void setTypeName(String paramString)
  {
    this.b = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.InfoParameter
 * JD-Core Version:    0.6.0
 */