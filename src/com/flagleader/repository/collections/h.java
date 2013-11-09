package com.flagleader.repository.collections;

import com.flagleader.repository.IElement;
import java.util.Iterator;

public abstract interface h
{
  public abstract int getChildrenCount();

  public abstract IElement getElement(int paramInt);

  public abstract void removeElement(int paramInt);

  public abstract Iterator getChildrenIterator();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.collections.h
 * JD-Core Version:    0.6.0
 */