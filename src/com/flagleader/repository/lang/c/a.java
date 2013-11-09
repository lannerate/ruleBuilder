package com.flagleader.repository.lang.c;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.m;

public abstract class a
  implements g
{
  h a;

  public a(h paramh)
  {
    this.a = paramh;
  }

  public boolean a()
  {
    return false;
  }

  public boolean b()
  {
    return false;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d()
  {
    return false;
  }

  public boolean e()
  {
    return false;
  }

  public boolean f()
  {
    return false;
  }

  public boolean g()
  {
    return false;
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    return false;
  }

  public boolean j()
  {
    return false;
  }

  public boolean k()
  {
    return false;
  }

  public boolean l()
  {
    return false;
  }

  public boolean m()
  {
    return false;
  }

  public boolean n()
  {
    return false;
  }

  public boolean o()
  {
    return false;
  }

  public boolean O()
  {
    return false;
  }

  public boolean P()
  {
    return false;
  }

  public boolean p()
  {
    return false;
  }

  public boolean q()
  {
    return false;
  }

  public boolean r()
  {
    return false;
  }

  public boolean s()
  {
    return false;
  }

  public boolean t()
  {
    return false;
  }

  public boolean u()
  {
    return false;
  }

  public boolean v()
  {
    return false;
  }

  public boolean w()
  {
    return false;
  }

  public boolean x()
  {
    return false;
  }

  public boolean y()
  {
    return false;
  }

  public boolean z()
  {
    return false;
  }

  public boolean A()
  {
    return false;
  }

  public boolean B()
  {
    return false;
  }

  public boolean C()
  {
    return false;
  }

  public boolean D()
  {
    return false;
  }

  public boolean E()
  {
    return false;
  }

  public boolean F()
  {
    return false;
  }

  public boolean G()
  {
    return false;
  }

  public boolean H()
  {
    return false;
  }

  public int I()
  {
    return 0;
  }

  public g J()
  {
    return null;
  }

  public boolean e(String paramString)
  {
    return a(paramString);
  }

  public String L()
  {
    return this.a.b(this);
  }

  public String M()
  {
    return this.a.d(this);
  }

  public String N()
  {
    return this.a.a(this);
  }

  public boolean b(String paramString)
  {
    return a(this.a.a(paramString));
  }

  public boolean b(g paramg)
  {
    return a(paramg);
  }

  public boolean a(g paramg)
  {
    return equals(paramg);
  }

  public String toString()
  {
    return K();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof g))
      return false;
    g localg = (g)paramObject;
    if (K().equals(localg.K()))
      return true;
    if ((n()) && (J().equals(localg.J())))
      return true;
    return super.equals(paramObject);
  }

  public boolean c(String paramString)
  {
    return this.a.a(paramString).a(this, false);
  }

  public boolean d(String paramString)
  {
    return this.a.a(paramString).a(this, true);
  }

  public boolean a(g paramg, boolean paramBoolean)
  {
    if (a(paramg))
      return true;
    if ((paramg.F()) && ((m.a().d() == 1) || (paramBoolean)))
      return true;
    if (j())
    {
      if ((paramg.b()) || (paramg.m()))
        return true;
    }
    else if ((b()) && ((paramg.b()) || (paramg.j())))
      return true;
    if (m())
    {
      if ((m.a().d() == 1) || (paramBoolean))
        return (paramg.b()) || (paramg.v()) || (paramg.x()) || (paramg.w()) || (paramg.e()) || (paramg.d()) || (paramg.z()) || (paramg.y()) || (paramg.A()) || (paramg.B()) || (paramg.j());
      return false;
    }
    if (((g()) || (k()) || (h()) || (c()) || (i()) || (e()) || (paramg.j())) && ((m.a().c() == 1) || (paramBoolean)))
    {
      if (paramg.m())
        return true;
      if (paramg.j())
        return true;
      if (paramg.b())
        return true;
    }
    else if ((v()) && ((m.a().b() == 1) || (paramBoolean)))
    {
      if (paramg.m())
        return true;
    }
    else if ((w()) && ((m.a().b() == 1) || (paramBoolean)))
    {
      if (paramg.m())
        return true;
    }
    else if ((x()) && ((m.a().b() == 1) || (paramBoolean)))
    {
      if (paramg.m())
        return true;
    }
    else if (F())
    {
      return true;
    }
    return false;
  }

  public Object f(String paramString)
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c.a
 * JD-Core Version:    0.6.0
 */