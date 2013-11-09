package com.flagleader.repository.rlm;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;

public abstract class AbstractValueToken extends AbstractRuleObject
{
  private String valueType = "";

  public AbstractValueToken()
  {
  }

  public AbstractValueToken(String paramString)
  {
    this.valueType = paramString;
  }

  public AbstractValueToken(AbstractValueToken paramAbstractValueToken)
  {
    super(paramAbstractValueToken);
    this.valueType = paramAbstractValueToken.valueType;
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public g getJavaType()
  {
    return getTypeManager().a(this.valueType);
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractValueToken
 * JD-Core Version:    0.6.0
 */