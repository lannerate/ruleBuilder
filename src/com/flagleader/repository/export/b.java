package com.flagleader.repository.export;

import com.flagleader.repository.collections.ChildAcceptor;

class b
  implements ChildAcceptor
{
  b(AbstractPage paramAbstractPage)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof PageFieldModel;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof PageFieldModel;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.b
 * JD-Core Version:    0.6.0
 */