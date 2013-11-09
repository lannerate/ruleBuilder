package com.flagleader.a.c;

import com.flagleader.a.B;
import com.flagleader.a.K;
import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.S;
import com.flagleader.a.V;
import com.flagleader.a.Y;
import com.flagleader.a.aa;
import com.flagleader.a.af;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import com.flagleader.util.collection.DynamicStringIterator;
import com.flagleader.util.collection.EnumerationIterator;
import com.flagleader.util.collection.IStringIterator;
import java.util.Hashtable;

public class f
  implements K
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 15;
  private boolean f = true;
  private Hashtable g = new Hashtable();
  private Hashtable h = new Hashtable();
  private int i = 15;

  public f()
  {
  }

  public f(int paramInt)
  {
    this.i = paramInt;
  }

  public boolean a(y paramy)
  {
    String str = b(paramy.h());
    return (a(paramy)) && ((this.f) || (a(str))) && (!b(b(paramy))) && (a(paramy.e()));
  }

  public boolean a(B paramB)
  {
    return (b(paramB)) && (a(paramB));
  }

  public boolean a(P paramP)
  {
    if (!a(paramP))
      return false;
    String str = b(paramP.h());
    if ((!this.f) && (!a(str)))
      return false;
    if (b(b(paramP)))
      return false;
    aa localaa = paramP.g();
    if (localaa != null)
      for (int j = 0; j < localaa.size(); j++)
      {
        ak localak2 = localaa.a(j).e();
        if (!a(localak2))
          return false;
      }
    if (!paramP.p())
    {
      ak localak1 = paramP.n();
      if (!a(localak1))
        return false;
    }
    return true;
  }

  private boolean a(S paramS)
  {
    String str1 = b(paramS);
    if (b(str1))
      return false;
    for (af localaf = paramS.J(); localaf != null; localaf = localaf.J())
    {
      if (!(localaf instanceof V))
        continue;
      String str2 = b(localaf);
      if ((str2 != null) && (b(str2)))
        return false;
    }
    return true;
  }

  private boolean a(ak paramak)
  {
    return paramak.X() ? a((B)paramak) : paramak.Z();
  }

  public boolean b(B paramB)
  {
    if (paramB.C())
      return g();
    if (paramB.B())
      return f();
    if (paramB.A())
      return e();
    return d();
  }

  public boolean a(M paramM)
  {
    if (paramM.l())
      return g();
    if (paramM.k())
      return f();
    if (paramM.j())
      return e();
    return d();
  }

  private String b(S paramS)
  {
    return paramS.K();
  }

  public int a()
  {
    return this.i;
  }

  public int b()
  {
    return this.h.size();
  }

  public int c()
  {
    return this.g.size();
  }

  public final boolean d()
  {
    return (this.i & 0x8) != 0;
  }

  public final boolean e()
  {
    return (this.i & 0x2) != 0;
  }

  public final boolean f()
  {
    return (this.i & 0x4) != 0;
  }

  public final boolean g()
  {
    return (this.i & 0x1) != 0;
  }

  public boolean a(String paramString)
  {
    return this.g.containsKey(paramString);
  }

  public boolean b(String paramString)
  {
    return this.h.containsKey(paramString);
  }

  public void c(String paramString)
  {
    this.h.put(paramString, paramString);
  }

  public IStringIterator h()
  {
    EnumerationIterator localEnumerationIterator = new EnumerationIterator(this.h.elements());
    return new DynamicStringIterator(localEnumerationIterator);
  }

  public void a(int paramInt)
  {
    this.i = paramInt;
  }

  public void d(String paramString)
  {
    this.f = false;
    this.g.put(paramString, paramString);
  }

  public IStringIterator i()
  {
    EnumerationIterator localEnumerationIterator = new EnumerationIterator(this.g.elements());
    return new DynamicStringIterator(localEnumerationIterator);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.f
 * JD-Core Version:    0.6.0
 */