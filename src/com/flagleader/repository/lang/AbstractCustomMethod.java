package com.flagleader.repository.lang;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;

public abstract class AbstractCustomMethod
  implements f
{
  private String funcName;
  private String disName;
  private String returnType;
  private String typeName;
  private String funcBody;
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public String getFuncName()
  {
    return this.funcName;
  }

  public void setFuncName(String paramString)
  {
    this.funcName = paramString;
  }

  public String getDisName()
  {
    return this.disName;
  }

  public void setDisName(String paramString)
  {
    this.disName = paramString;
  }

  public String getReturnType()
  {
    return this.returnType;
  }

  public void setReturnType(String paramString)
  {
    this.returnType = paramString;
  }

  public String getTypeName()
  {
    return this.typeName;
  }

  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }

  public String getFuncBody()
  {
    return this.funcBody;
  }

  public void setFuncBody(String paramString)
  {
    this.funcBody = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.AbstractCustomMethod
 * JD-Core Version:    0.6.0
 */