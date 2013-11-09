package com.flagleader.a.b;

import com.flagleader.a.A;
import com.flagleader.a.B;
import com.flagleader.a.D;
import com.flagleader.a.E;
import com.flagleader.a.F;
import com.flagleader.a.H;
import com.flagleader.a.I;
import com.flagleader.a.K;
import com.flagleader.a.L;
import com.flagleader.a.N;
import com.flagleader.a.P;
import com.flagleader.a.Q;
import com.flagleader.a.R;
import com.flagleader.a.S;
import com.flagleader.a.T;
import com.flagleader.a.ab;
import com.flagleader.a.af;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.a.al;
import com.flagleader.a.c.n;
import com.flagleader.a.d;
import com.flagleader.a.k;
import com.flagleader.a.m;
import com.flagleader.a.y;
import com.flagleader.util.collection.ConcatenationList;
import com.flagleader.util.collection.IList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class b extends C
  implements B
{
  private String c;
  private String d;
  private af e = null;
  private Class f;
  private D g = null;
  private D h = null;
  private H i = null;
  protected R a = null;
  protected A b = null;
  private C j = null;

  b(g paramg, Class paramClass)
  {
    super(paramg);
    this.f = paramClass;
    this.d = paramClass.getName();
    Object localObject1;
    if (paramClass.isArray())
    {
      localObject1 = null;
      Class localClass1 = paramClass.getComponentType();
      this.j = ((C)paramg.d(localClass1));
      this.d = (this.j.K() + "[]");
      this.c = this.d;
      this.j.a(this);
    }
    else
    {
      int k = this.d.lastIndexOf("$");
      int m = 1;
      if (k < 0)
      {
        m = 0;
        k = this.d.lastIndexOf(".");
      }
      if (k >= 1)
      {
        this.c = this.d.substring(k + 1);
        String str1 = this.d.substring(0, k);
        if (str1.indexOf("$") > 0)
          str1 = str1.replace('$', '.');
        localObject1 = paramg.f(str1);
        if (localObject1 == null)
        {
          Class localClass2 = paramClass.getDeclaringClass();
          if ((localClass2 == null) && (m != 0))
          {
            String str2 = this.d.substring(0, k);
            try
            {
              if (paramClass.getClassLoader() != null)
                localClass2 = paramClass.getClassLoader().loadClass(str2);
              else
                localClass2 = Class.forName(str2);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              localClass2 = null;
            }
          }
          if (localClass2 != null)
            localObject1 = paramg.d(localClass2);
          else
            localObject1 = paramg.h(str1);
        }
        if (localObject1 != null)
          this.d = (((S)localObject1).K() + "." + this.c);
        else
          throw new RuntimeException("Could not find java class " + str1);
      }
      else
      {
        this.c = this.d;
        localObject1 = paramg.m();
      }
    }
    if ((localObject1 instanceof af))
    {
      Object localObject2;
      if ((localObject1 instanceof z))
      {
        localObject2 = (z)localObject1;
        ((z)localObject2).a(this);
      }
      else if ((localObject1 instanceof b))
      {
        localObject2 = (b)localObject1;
        if (((b)localObject2).g == null)
          ((b)localObject2).g = new com.flagleader.a.e();
        ((b)localObject2).g.add(this);
      }
      a((af)localObject1);
    }
    else if (!paramClass.isArray())
    {
      throw new RuntimeException("Unexpected");
    }
    paramg.a(this);
  }

  public com.flagleader.a.z d()
  {
    return c().a(this);
  }

  public com.flagleader.a.z e()
  {
    return c().b(this);
  }

  public N f()
  {
    return c().c(this);
  }

  public Q g()
  {
    return c().d(this);
  }

  public com.flagleader.a.C h()
  {
    return new d(n.b(k(), n.d));
  }

  public N i()
  {
    return c().e(this);
  }

  public N a(E paramE)
  {
    return c().a(this, paramE, null);
  }

  public N a(E paramE, K paramK)
  {
    return c().a(this, paramE, paramK);
  }

  public Q j()
  {
    return c().f(this);
  }

  public com.flagleader.a.C k()
  {
    return c().g(this);
  }

  public String G()
  {
    return I();
  }

  public y d(String paramString)
  {
    if (l() != null)
      return l().a(paramString);
    return null;
  }

  public y e(String paramString)
  {
    if (l() != null)
      return l().b(paramString);
    return null;
  }

  public A l()
  {
    if (this.b == null)
    {
      this.b = new com.flagleader.a.c();
      Field[] arrayOfField = this.f.getFields();
      for (int k = 0; k < arrayOfField.length; k++)
        this.b.add(new a(this, arrayOfField[k]));
    }
    return this.b;
  }

  public A m()
  {
    if (this.b == null)
    {
      this.b = new com.flagleader.a.c();
      Field[] arrayOfField = this.f.getDeclaredFields();
      for (int k = 0; k < arrayOfField.length; k++)
        this.b.add(new a(this, arrayOfField[k]));
    }
    return this.b;
  }

  public ak T()
  {
    return this.j;
  }

  public F a(ak[] paramArrayOfak)
  {
    return c().a(n(), paramArrayOfak);
  }

  public H n()
  {
    if (this.i == null)
    {
      this.i = new com.flagleader.a.g();
      Constructor[] arrayOfConstructor = this.f.getDeclaredConstructors();
      for (int k = 0; k < arrayOfConstructor.length; k++)
        this.i.add(new c(this, arrayOfConstructor[k]));
    }
    return this.i;
  }

  public String I()
  {
    if (W())
      return T().I() + "[ ]";
    return K();
  }

  public I U()
  {
    return null;
  }

  public af J()
  {
    return this.e;
  }

  public B o()
  {
    return c().h(this);
  }

  public B p()
  {
    return c().i(this);
  }

  public String K()
  {
    return this.d;
  }

  public Class V()
  {
    return this.f;
  }

  public P a(String paramString, ak[] paramArrayOfak)
  {
    return c().a(q(), paramString, paramArrayOfak);
  }

  public P b(String paramString, ak[] paramArrayOfak)
  {
    return c().b(q(), paramString, paramArrayOfak);
  }

  public R q()
  {
    if (this.a == null)
    {
      this.a = new k();
      Method[] arrayOfMethod = this.f.getMethods();
      for (int k = 0; k < arrayOfMethod.length; k++)
        this.a.add(new e(this, arrayOfMethod[k]));
    }
    return this.a;
  }

  protected int aa()
  {
    return this.f.getModifiers();
  }

  public String L()
  {
    return this.c;
  }

  public D r()
  {
    if (this.g == null)
      this.g = new com.flagleader.a.e();
    return this.g;
  }

  public String N()
  {
    if (W())
      return T().N() + "[ ]";
    return L();
  }

  public D s()
  {
    if (this.h == null)
    {
      this.h = new com.flagleader.a.e();
      if (this.f.getSuperclass() != null)
      {
        localObject = (B)ab().d(this.f.getSuperclass());
        this.h.add(localObject);
      }
      Object localObject = this.f.getInterfaces();
      for (int k = 0; k < localObject.length; k++)
      {
        B localB = (B)ab().d(localObject[k]);
        this.h.add(localB);
      }
    }
    return (D)this.h;
  }

  public ab t()
  {
    return null;
  }

  public com.flagleader.a.C u()
  {
    return new d(n.b(s(), n.d));
  }

  public boolean v()
  {
    return Modifier.isAbstract(aa());
  }

  public boolean W()
  {
    return this.j != null;
  }

  public boolean X()
  {
    return true;
  }

  public boolean w()
  {
    return Modifier.isFinal(aa());
  }

  public boolean x()
  {
    return true;
  }

  public boolean y()
  {
    return this.f.isInterface();
  }

  public boolean z()
  {
    return false;
  }

  public boolean A()
  {
    return Modifier.isPrivate(aa());
  }

  public boolean B()
  {
    return Modifier.isProtected(aa());
  }

  public boolean C()
  {
    return Modifier.isPublic(aa());
  }

  public boolean D()
  {
    return Modifier.isStatic(aa());
  }

  public boolean a(B paramB)
  {
    return c().a(this, paramB);
  }

  public N E()
  {
    return c().j(this);
  }

  public N b(E paramE)
  {
    return c().b(this, paramE, null);
  }

  public N b(E paramE, K paramK)
  {
    return c().b(this, paramE, paramK);
  }

  public T P()
  {
    m localm = new m();
    localm.setListData(new ConcatenationList(new IList[] { r(), q(), l() }));
    return localm.d();
  }

  public al F()
  {
    return c().k(this);
  }

  void a(af paramaf)
  {
    this.e = paramaf;
  }

  public boolean d_()
  {
    return true;
  }

  public boolean a(L paramL)
  {
    return c().a(paramL, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.b
 * JD-Core Version:    0.6.0
 */