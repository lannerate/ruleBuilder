package com.flagleader.repository.rom;

import com.flagleader.repository.f;
import java.io.Serializable;

public abstract interface IMethodParam extends f, Serializable
{
  public abstract boolean hasDefaultValue();

  public abstract String getDefaultValue();

  public abstract String getParamName();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IMethodParam
 * JD-Core Version:    0.6.0
 */