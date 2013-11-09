package com.flagleader.repository.collections;

import java.util.Iterator;

public class d extends i
  implements Iterator
{
  public d(Iterator paramIterator)
  {
    super(paramIterator);
  }

  public Iterator a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof h)))
      return ((h)paramObject).getChildrenIterator();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.d
 * JD-Core Version:    0.6.0
 */