package com.flagleader.a.b;

import com.flagleader.a.J;
import com.flagleader.a.K;
import com.flagleader.a.L;
import com.flagleader.a.S;
import com.flagleader.a.V;
import com.flagleader.a.W;
import com.flagleader.a.a;
import com.flagleader.a.ab;
import com.flagleader.a.ad;
import com.flagleader.a.ae;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.a.t;
import com.flagleader.util.collection.DynamicStringIterator;
import com.flagleader.util.collection.IStringIterator;
import com.flagleader.util.exception.UnsupportOperationException;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;

public class g extends a
  implements J
{
  private ClassLoader a = null;
  private V b = null;
  private com.flagleader.a.B c = null;
  private com.flagleader.a.B d = null;
  private com.flagleader.a.B e = null;
  private com.flagleader.a.B f = null;
  private Hashtable g = new Hashtable();
  private Hashtable h = new Hashtable();
  private Hashtable i = new Hashtable();
  private ad j = null;
  private B k = null;
  private B l = null;
  private B m = null;
  private B n = null;
  private B o = null;
  private B p = null;
  private B q = null;
  private B r = null;
  private B s = null;

  public g()
  {
    E();
  }

  public ak a(Class paramClass)
  {
    return d(paramClass);
  }

  public void a(PropertyChangeListener paramPropertyChangeListener)
  {
  }

  public com.flagleader.a.C b()
  {
    return c().a(this);
  }

  public W d()
  {
    return c().b(this);
  }

  protected static Class n(String paramString)
  {
    try
    {
      return Class.forName(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
  }

  public com.flagleader.a.B e()
  {
    return f().d();
  }

  public ab f()
  {
    return this.l;
  }

  public com.flagleader.a.B g()
  {
    return h().d();
  }

  public ab h()
  {
    return this.m;
  }

  public ab i()
  {
    return this.n;
  }

  public com.flagleader.a.B j()
  {
    return i().d();
  }

  ak d(Class paramClass)
  {
    Object localObject = null;
    if (paramClass != null)
    {
      localObject = e(paramClass);
      if (localObject == null)
        localObject = new b(this, paramClass);
    }
    return (ak)(ak)localObject;
  }

  public com.flagleader.a.B d(String paramString)
  {
    S localS = f(paramString);
    if ((localS instanceof com.flagleader.a.B))
      return (com.flagleader.a.B)localS;
    return null;
  }

  public com.flagleader.a.B e(String paramString)
  {
    S localS = g(paramString);
    if ((localS instanceof com.flagleader.a.B))
      return (com.flagleader.a.B)localS;
    return null;
  }

  public ClassLoader k()
  {
    return this.a;
  }

  public com.flagleader.a.B l()
  {
    if (this.e == null)
      this.e = ((com.flagleader.a.B)d(n("java.lang.Cloneable")));
    return this.e;
  }

  public V m()
  {
    return this.b;
  }

  public com.flagleader.a.B n()
  {
    return o().d();
  }

  public ab o()
  {
    return this.p;
  }

  public com.flagleader.a.B p()
  {
    return q().d();
  }

  public ab q()
  {
    return this.o;
  }

  public ab r()
  {
    return this.r;
  }

  public com.flagleader.a.B s()
  {
    return r().d();
  }

  ak e(Class paramClass)
  {
    return (ak)this.h.get(paramClass);
  }

  V o(String paramString)
  {
    return (V)this.i.get(paramString);
  }

  public com.flagleader.a.B t()
  {
    return u().d();
  }

  public ab u()
  {
    return this.s;
  }

  public S f(String paramString)
  {
    return c().b(this, paramString);
  }

  public S g(String paramString)
  {
    return f(paramString);
  }

  public com.flagleader.a.B v()
  {
    if (this.c == null)
      this.c = ((com.flagleader.a.B)d(n("java.lang.Object")));
    return this.c;
  }

  public aj c()
  {
    return h.a();
  }

  public V h(String paramString)
  {
    Object localObject = null;
    if ((paramString != null) && (!paramString.equals("")))
    {
      localObject = o(paramString);
      if (localObject == null)
        localObject = new z(this, paramString);
    }
    else
    {
      localObject = m();
    }
    return (V)(V)localObject;
  }

  public V i(String paramString)
  {
    S localS = g(paramString);
    if ((localS instanceof V))
      return (V)localS;
    return null;
  }

  public ab j(String paramString)
  {
    return (ab)this.g.get(paramString);
  }

  public ad w()
  {
    return this.j;
  }

  public Object a(String paramString)
  {
    return null;
  }

  public com.flagleader.a.B x()
  {
    if (this.f == null)
      this.f = ((com.flagleader.a.B)d(n("java.io.Serializable")));
    return this.f;
  }

  public com.flagleader.a.B y()
  {
    return z().d();
  }

  public ab z()
  {
    return this.q;
  }

  public com.flagleader.a.B A()
  {
    if (this.d == null)
      this.d = ((com.flagleader.a.B)d(n("java.lang.String")));
    return this.d;
  }

  public ak k(String paramString)
  {
    S localS = f(paramString);
    if ((localS instanceof ak))
      return (ak)localS;
    return null;
  }

  public com.flagleader.a.B B()
  {
    return C().d();
  }

  public ab C()
  {
    return this.k;
  }

  private void E()
  {
    this.b = new z(this, "");
    v();
    this.j = new t();
    this.k = new B(this, Void.TYPE, n("java.lang.Void"));
    this.l = new B(this, Boolean.TYPE, n("java.lang.Boolean"), 'Z');
    this.m = new B(this, Byte.TYPE, n("java.lang.Byte"), 'B');
    this.n = new B(this, Character.TYPE, n("java.lang.Character"), 'C');
    this.o = new B(this, Float.TYPE, n("java.lang.Float"), 'F');
    this.p = new B(this, Double.TYPE, n("java.lang.Double"), 'D');
    this.q = new B(this, Short.TYPE, n("java.lang.Short"), 'S');
    this.r = new B(this, Integer.TYPE, n("java.lang.Integer"), 'I');
    this.s = new B(this, Long.TYPE, n("java.lang.Long"), 'J');
  }

  void a(C paramC)
  {
    this.h.put(paramC.V(), paramC);
    if (paramC.Z())
    {
      this.g.put(paramC.L(), paramC);
      this.j.add(paramC);
    }
  }

  void a(V paramV)
  {
    this.i.put(paramV.K(), paramV);
  }

  public boolean a(com.flagleader.a.B paramB)
  {
    return (paramB != null) && (paramB == this.e);
  }

  public boolean D()
  {
    return true;
  }

  public boolean b(com.flagleader.a.B paramB)
  {
    return (paramB != null) && (paramB == this.c);
  }

  public boolean b(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public boolean c(com.flagleader.a.B paramB)
  {
    return (paramB != null) && (paramB == this.f);
  }

  public boolean d(com.flagleader.a.B paramB)
  {
    return (paramB != null) && (paramB == this.d);
  }

  public com.flagleader.a.B b(Class paramClass)
  {
    ak localak = c(paramClass);
    if ((localak instanceof com.flagleader.a.B))
      return (com.flagleader.a.B)localak;
    return null;
  }

  public com.flagleader.a.B l(String paramString)
  {
    ak localak = m(paramString);
    if ((localak instanceof com.flagleader.a.B))
      return (com.flagleader.a.B)localak;
    return null;
  }

  public ak c(Class paramClass)
  {
    return a(paramClass);
  }

  public ak m(String paramString)
  {
    S localS = f(paramString);
    if (localS != null)
    {
      if ((localS instanceof ak))
        return (ak)localS;
      return null;
    }
    String str = h.b(paramString);
    try
    {
      Class localClass;
      if (k() != null)
        localClass = k().loadClass(str);
      else
        localClass = Class.forName(str);
      return c(localClass);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }

  public IStringIterator a()
  {
    return new DynamicStringIterator();
  }

  public void a(K paramK)
  {
    throw new UnsupportOperationException();
  }

  public void e(com.flagleader.a.B paramB)
  {
    throw new UnsupportOperationException();
  }

  public void c(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public void b(PropertyChangeListener paramPropertyChangeListener)
  {
  }

  public void a(ClassLoader paramClassLoader)
  {
    this.a = paramClassLoader;
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new UnsupportOperationException();
  }

  public void a(String paramString, ae paramae)
  {
    throw new UnsupportOperationException();
  }

  public void a(String paramString1, String paramString2)
  {
    throw new UnsupportOperationException();
  }

  public void a(String paramString, Object paramObject)
  {
    throw new UnsupportOperationException();
  }

  public boolean a(L paramL)
  {
    return c().a(paramL, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.g
 * JD-Core Version:    0.6.0
 */