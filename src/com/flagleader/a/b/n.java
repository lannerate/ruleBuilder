package com.flagleader.a.b;

import com.flagleader.a.C;
import com.flagleader.a.D;
import com.flagleader.a.V;
import com.flagleader.a.W;
import com.flagleader.a.d;
import com.flagleader.util.collection.IIterator;

class n
  implements IIterator
{
  C a = a(paramV);
  W b;

  n(h paramh, V paramV)
  {
    this.b = paramV.e();
  }

  void a()
  {
    while ((this.a == null) || (!this.a.hasNext()))
    {
      if ((this.b == null) || (!this.b.hasNext()))
        break;
      this.a = a(this.b.a());
    }
  }

  C a(V paramV)
  {
    return paramV.f() == null ? null : new d(new x(paramV.f().a()));
  }

  public boolean hasNext()
  {
    a();
    return (this.a != null) && (this.a.hasNext());
  }

  public Object next()
  {
    if (hasNext())
      return this.a.a();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.n
 * JD-Core Version:    0.6.0
 */