package com.flagleader.repository.rlm;

import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public abstract class AbstractClassToken extends AbstractBOToken
{
  public AbstractClassToken()
  {
    setDisplayName("&selectClass");
  }

  public AbstractClassToken(String paramString)
  {
    super(paramString);
    setDisplayName("&selectClass");
  }

  public AbstractClassToken(AbstractClassToken paramAbstractClassToken)
  {
    super(paramAbstractClassToken);
  }

  protected Iterator e()
  {
    return getEnvionment().getAcceptElements(new a(this));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractClassToken
 * JD-Core Version:    0.6.0
 */