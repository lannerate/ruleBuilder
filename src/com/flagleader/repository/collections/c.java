package com.flagleader.repository.collections;

import java.util.Iterator;

public class c extends j
  implements Iterator
{
  public c(Iterator paramIterator, ChildAcceptor paramChildAcceptor)
  {
    super(paramIterator, paramChildAcceptor);
  }

  public Iterator a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof h)))
      return ((h)paramObject).getChildrenIterator();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.c
 * JD-Core Version:    0.6.0
 */