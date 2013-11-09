package org.agilemore.agilegrid;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

public class aB extends EventObject
{
  private static final long c = -2351169764483288361L;
  protected Set a;
  protected Set b;

  public aB(Object paramObject, Set paramSet1, Set paramSet2)
  {
    super(paramObject);
    this.a = paramSet2;
    this.b = paramSet1;
  }

  public Set a()
  {
    return this.a;
  }

  public Set b()
  {
    return this.b;
  }

  public Set c()
  {
    HashSet localHashSet = new HashSet(this.b);
    localHashSet.removeAll(this.a);
    return localHashSet;
  }

  public Set d()
  {
    HashSet localHashSet = new HashSet(this.a);
    localHashSet.removeAll(this.b);
    return localHashSet;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.aB
 * JD-Core Version:    0.6.0
 */