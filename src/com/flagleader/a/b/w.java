package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.C;
import com.flagleader.a.M;
import com.flagleader.a.N;
import com.flagleader.util.collection.IIterator;

abstract class w
  implements IIterator
{
  private B a;
  private C b;
  private N c;

  private final void c()
  {
    while (((this.c == null) || (!this.c.hasNext())) && (this.b != null) && (this.b.hasNext()))
    {
      B localB = this.b.a();
      this.c = a(localB);
    }
    if ((this.b != null) && (!this.b.hasNext()))
      this.b = null;
    if ((this.c != null) && (!this.c.hasNext()))
      this.c = null;
  }

  abstract N a(B paramB);

  h a()
  {
    return (h)this.a.c();
  }

  B b()
  {
    return this.a;
  }

  public final boolean hasNext()
  {
    return this.c != null;
  }

  public final Object next()
  {
    M localM = this.c == null ? null : this.c.b();
    c();
    return localM;
  }

  w(C paramC)
  {
    this(null, paramC);
  }

  w(B paramB)
  {
    this.a = paramB;
    this.b = paramB.k();
    this.c = a(paramB);
    c();
  }

  w(B paramB, C paramC)
  {
    this(paramB, paramC, null);
  }

  w(B paramB, C paramC, N paramN)
  {
    this.a = paramB;
    this.b = paramC;
    this.c = paramN;
    c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.w
 * JD-Core Version:    0.6.0
 */