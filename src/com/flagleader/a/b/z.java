package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.C;
import com.flagleader.a.D;
import com.flagleader.a.L;
import com.flagleader.a.T;
import com.flagleader.a.V;
import com.flagleader.a.W;
import com.flagleader.a.X;
import com.flagleader.a.af;
import com.flagleader.a.aj;
import com.flagleader.a.al;
import com.flagleader.a.e;
import com.flagleader.a.m;
import com.flagleader.a.o;
import com.flagleader.a.w;
import com.flagleader.util.collection.ConcatenationList;
import com.flagleader.util.collection.IList;

public class z extends f
  implements V
{
  String a;
  String b;
  af c = null;
  e d = new e();
  o e = new o();

  z(g paramg, String paramString)
  {
    super(paramg);
    int i = (paramString != null) && (!paramString.equals("")) ? 0 : 1;
    z localz;
    if (i == 0)
    {
      int j = paramString.lastIndexOf(".");
      if (j >= 1)
      {
        String str = paramString.substring(0, j);
        this.a = paramString.substring(j + 1);
        localz = (z)paramg.h(str);
      }
      else
      {
        this.a = paramString;
        localz = (z)paramg.m();
      }
      this.b = paramString;
    }
    else
    {
      this.a = "";
      this.b = "";
      localz = null;
    }
    if (localz != null)
      localz.e.add(this);
    a(localz);
    paramg.a(this);
  }

  void a(B paramB)
  {
    this.d.add(paramB);
  }

  public C d()
  {
    return c().a(this);
  }

  public W e()
  {
    return c().b(this);
  }

  public B d(String paramString)
  {
    return f() == null ? null : f().a(paramString);
  }

  public D f()
  {
    return this.d;
  }

  public af J()
  {
    return this.c;
  }

  public V g()
  {
    return (V)J();
  }

  public String K()
  {
    return this.b;
  }

  public String L()
  {
    return this.a;
  }

  public V e(String paramString)
  {
    return h() == null ? null : h().a(paramString);
  }

  public X h()
  {
    return this.e;
  }

  public boolean i()
  {
    return this.b.equals("");
  }

  public T P()
  {
    m localm = new m();
    localm.setListData(new ConcatenationList(new IList[] { h(), f() }));
    return localm.d();
  }

  public void a(af paramaf)
  {
    this.c = paramaf;
  }

  public al j()
  {
    return new w(f().iterator());
  }

  public boolean a(L paramL)
  {
    return c().a(paramL, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.z
 * JD-Core Version:    0.6.0
 */