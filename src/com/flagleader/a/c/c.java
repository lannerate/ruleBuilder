package com.flagleader.a.c;

import com.flagleader.a.B;
import com.flagleader.a.J;
import com.flagleader.a.K;
import com.flagleader.a.L;
import com.flagleader.a.P;
import com.flagleader.a.V;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.a.al;
import com.flagleader.a.w;
import com.flagleader.a.y;
import com.flagleader.util.collection.EnumerationIterator;
import java.util.Hashtable;

public class c
  implements L
{
  Hashtable a = new Hashtable();
  Hashtable b = new Hashtable();
  Hashtable c = new Hashtable();
  J d;
  K e;
  boolean f = true;
  boolean g = true;
  final boolean h = false;
  int i = 0;

  public boolean a(ak paramak)
  {
    return this.b.containsKey(paramak);
  }

  public boolean b(ak paramak)
  {
    return this.c.containsKey(paramak);
  }

  public boolean c(ak paramak)
  {
    return this.a.containsKey(paramak);
  }

  public al a()
  {
    EnumerationIterator localEnumerationIterator = new EnumerationIterator(this.b.keys());
    return new w(localEnumerationIterator);
  }

  void d(ak paramak)
  {
    this.b.put(paramak, paramak);
  }

  public al b()
  {
    EnumerationIterator localEnumerationIterator = new EnumerationIterator(this.c.keys());
    return new w(localEnumerationIterator);
  }

  void e(ak paramak)
  {
    this.c.put(paramak, paramak);
  }

  public boolean a(y paramy)
  {
    if (this.e.a(paramy))
      return paramy.a(this);
    return true;
  }

  public boolean a(B paramB)
  {
    if (this.e.a(paramB))
    {
      if (!this.f)
      {
        if ((!a(paramB)) && (!c(paramB)) && (!b(paramB)))
        {
          d(paramB);
          this.g = true;
          this.i += 1;
          paramB.c().g(this, paramB);
          if (this.g)
            paramB.c().d(this, paramB);
          if ((this.g) && (paramB.T() != null))
            f(paramB.T());
          this.i -= 1;
          if (!this.g)
          {
            e(paramB);
            this.b.remove(paramB);
          }
        }
      }
      else
      {
        if ((c(paramB)) && (!b(paramB)))
        {
          this.f = false;
          this.i += 1;
          this.g = true;
          paramB.a(this);
          if (this.g)
            paramB.c().d(this, paramB);
          if (!this.g)
          {
            e(paramB);
            this.a.remove(paramB);
          }
          this.i -= 1;
          this.f = true;
        }
        paramB.c().f(this, paramB);
      }
    }
    else
      this.g = false;
    return true;
  }

  public boolean a(P paramP)
  {
    if (this.e.a(paramP))
      return paramP.a(this);
    return true;
  }

  public boolean a(V paramV)
  {
    return paramV.a(this);
  }

  public boolean f(ak paramak)
  {
    if (paramak == null)
      return true;
    if (paramak.X())
      return a((B)paramak);
    return true;
  }

  public al c()
  {
    EnumerationIterator localEnumerationIterator = new EnumerationIterator(this.a.keys());
    return new w(localEnumerationIterator);
  }

  void g(ak paramak)
  {
    this.a.put(paramak, paramak);
  }

  public c(J paramJ, K paramK)
  {
    this(paramJ, paramK, null);
  }

  public c(J paramJ, K paramK, al paramal)
  {
    this.d = paramJ;
    this.e = paramK;
    if (paramal == null)
      paramJ.a(new d(this));
    else
      do
      {
        ak localak = paramal.b();
        if (localak.Z())
          continue;
        g(localak);
      }
      while (paramal.hasNext());
    paramJ.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.c
 * JD-Core Version:    0.6.0
 */