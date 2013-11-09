package com.flagleader.repository.rom;

import com.flagleader.util.TempID;

public class MethodParam
  implements IMethodParam
{
  private String paramName = "";
  private String typeName = "";
  private String defaultValue = "";
  public static final String ARGUMENT = "arg";
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public MethodParam(String paramString, int paramInt)
  {
    this.typeName = paramString;
    this.paramName = ("arg" + (paramInt + 1));
  }

  public MethodParam(String paramString1, int paramInt, String paramString2)
  {
    this.typeName = paramString1;
    this.paramName = ("arg" + (paramInt + 1));
    this.defaultValue = paramString2;
  }

  public MethodParam()
  {
  }

  public MethodParam(MethodParam paramMethodParam)
  {
    this.typeName = paramMethodParam.typeName;
    this.paramName = paramMethodParam.paramName;
    this.defaultValue = paramMethodParam.defaultValue;
  }

  public String getParamName()
  {
    return this.paramName;
  }

  public void setParamName(String paramString)
  {
    this.paramName = paramString;
  }

  public String getTypeName()
  {
    return this.typeName;
  }

  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public boolean hasDefaultValue()
  {
    return this.defaultValue.length() > 0;
  }

  public void changeDefaultValue(String paramString)
  {
    setDefaultValue(paramString);
  }

  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.MethodParam
 * JD-Core Version:    0.6.0
 */