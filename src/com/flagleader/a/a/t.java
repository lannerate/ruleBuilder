package com.flagleader.a.a;

import java.util.Hashtable;

public class t
  implements n
{
  private Hashtable a = new Hashtable();
  private n b;
  private Object c = null;

  public t(n paramn)
  {
    this.b = paramn;
  }

  final void c()
  {
    while ((this.c == null) && (this.b.a()))
    {
      Object localObject = this.b.b();
      if (this.a.containsKey(localObject))
        continue;
      this.a.put(localObject, localObject);
      this.c = localObject;
    }
  }

  public boolean a()
  {
    c();
    return this.c != null;
  }

  public Object b()
  {
    c();
    Object localObject = this.c;
    this.c = null;
    return localObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.t
 * JD-Core Version:    0.6.0
 */