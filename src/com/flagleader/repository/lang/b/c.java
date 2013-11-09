package com.flagleader.repository.lang.b;

import com.flagleader.engine.Property;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.m;
import com.flagleader.util.DateUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements g, Serializable
{
  private String a = "";
  private List b = new ArrayList();

  c(String paramString)
  {
    g(paramString);
  }

  c(c paramc)
  {
    g(paramc.a);
  }

  public String K()
  {
    return this.a;
  }

  public void g(String paramString)
  {
    this.a = paramString.trim();
    this.b.clear();
    String[] arrayOfString = this.a.split(";");
    for (int i = 0; i < arrayOfString.length; i++)
      this.b.add(i.d().a(arrayOfString[i]));
  }

  protected Object clone()
  {
    return new c(this);
  }

  public boolean a()
  {
    return true;
  }

  public boolean n()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).n())
        return true;
    return false;
  }

  public boolean H()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).H())
        return true;
    return false;
  }

  public boolean e()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).e())
        return true;
    return false;
  }

  public boolean E()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).E())
        return true;
    return false;
  }

  public boolean p()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).p())
        return true;
    return false;
  }

  public boolean r()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).r())
        return true;
    return false;
  }

  public boolean v()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).v())
        return true;
    return false;
  }

  public boolean G()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).G())
        return true;
    return false;
  }

  public boolean F()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).F())
        return true;
    return false;
  }

  public boolean w()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).w())
        return true;
    return false;
  }

  public boolean x()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).x())
        return true;
    return false;
  }

  public boolean q()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).q())
        return true;
    return false;
  }

  public boolean s()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).s())
        return true;
    return false;
  }

  public boolean P()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).P())
        return true;
    return false;
  }

  public boolean t()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).t())
        return true;
    return false;
  }

  public boolean o()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).o())
        return true;
    return false;
  }

  public boolean O()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).O())
        return true;
    return false;
  }

  public boolean b()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).b())
        return true;
    return false;
  }

  public boolean m()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).m())
        return true;
    return false;
  }

  public boolean l()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).l())
        return true;
    return false;
  }

  public boolean A()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).A())
        return true;
    return false;
  }

  public boolean B()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).B())
        return true;
    return false;
  }

  public boolean C()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).C())
        return true;
    return false;
  }

  public boolean D()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).D())
        return true;
    return false;
  }

  public boolean a(String paramString)
  {
    if (k())
      try
      {
        Integer.parseInt(paramString);
        return true;
      }
      catch (Exception localException1)
      {
        return false;
      }
    if (h())
      try
      {
        Long.parseLong(paramString);
        return true;
      }
      catch (Exception localException2)
      {
        return false;
      }
    if (g())
      try
      {
        Short.parseShort(paramString);
        return true;
      }
      catch (Exception localException3)
      {
        return false;
      }
    if ((i()) || (c()))
      return NumberUtil.isParsedPercent(paramString);
    if (e())
      try
      {
        new Boolean(NumberUtil.formatBoolean(paramString)).booleanValue();
        return true;
      }
      catch (Exception localException4)
      {
        return false;
      }
    if (f())
      try
      {
        Byte.parseByte(paramString);
        return true;
      }
      catch (Exception localException5)
      {
        return false;
      }
    if (d())
      return paramString.length() == 1;
    if (j())
    {
      if (StringUtil.isEmpty(paramString))
        return true;
      try
      {
        new BigDecimal(paramString);
        return true;
      }
      catch (Exception localException6)
      {
        return false;
      }
    }
    if (v())
      try
      {
        DateUtil.formatDate(paramString);
        return true;
      }
      catch (ParseException localParseException1)
      {
        return false;
      }
    if (w())
      try
      {
        DateUtil.formatTime(paramString);
        return true;
      }
      catch (ParseException localParseException2)
      {
        return false;
      }
    if (x())
      try
      {
        DateUtil.formatDatetime(paramString);
        return true;
      }
      catch (ParseException localParseException3)
      {
        return false;
      }
    return true;
  }

  public boolean e(String paramString)
  {
    if (a(paramString))
      return true;
    if (v())
      try
      {
        DateUtil.formatDate(paramString);
        return true;
      }
      catch (ParseException localParseException1)
      {
        return false;
      }
    if (w())
      try
      {
        DateUtil.formatTime(paramString);
        return true;
      }
      catch (ParseException localParseException2)
      {
        return false;
      }
    if (x())
      try
      {
        DateUtil.formatDatetime(paramString);
        return true;
      }
      catch (ParseException localParseException3)
      {
        return false;
      }
    return false;
  }

  public boolean a(g paramg)
  {
    if (equals(paramg))
      return true;
    if ((l()) || (paramg.l()))
      return false;
    if ((E()) || (paramg.E()))
      return false;
    if ((b()) && (paramg.b()))
      return true;
    if ((G()) && (paramg.G()))
      return true;
    if ((s()) && (paramg.s()) && (J().a(paramg.J())))
      return true;
    if ((o()) && (paramg.o()))
      return true;
    if ((q()) && (paramg.q()))
      return true;
    if ((C()) && (paramg.C()))
      return true;
    if ((D()) && (paramg.D()))
      return true;
    if ((m()) && (paramg.m()))
      return true;
    if ((A()) && (paramg.A()))
      return true;
    if ((B()) && (paramg.B()))
      return true;
    if ((F()) && (paramg.p()))
      return true;
    if ((p()) && (paramg.F()))
      return true;
    if ((p()) && (paramg.p()))
      try
      {
        Class localClass1 = getClass().getClassLoader().loadClass(i.d().d(paramg));
        Class localClass2 = getClass().getClassLoader().loadClass(i.d().d(this));
        if ((localClass2.isAssignableFrom(localClass1)) || (localClass1.isAssignableFrom(localClass2)))
          return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return false;
      }
    return (n()) && (paramg.n()) && (J().a(paramg.J()));
  }

  public boolean b(g paramg)
  {
    if (equals(paramg))
      return true;
    if ((l()) || (paramg.l()))
      return false;
    if ((E()) || (paramg.E()))
      return false;
    if ((i()) && ((paramg.c()) || (paramg.h()) || (paramg.k()) || (paramg.g())))
      return true;
    if ((c()) && ((paramg.h()) || (paramg.k()) || (paramg.g())))
      return true;
    if ((h()) && ((paramg.k()) || (paramg.g())))
      return true;
    if ((k()) && (paramg.g()))
      return true;
    if ((G()) && (paramg.G()))
      return true;
    if ((s()) && (paramg.s()) && (J().a(paramg.J())))
      return true;
    if ((o()) && (paramg.o()))
      return true;
    if ((q()) && (paramg.q()))
      return true;
    if ((C()) && (paramg.C()))
      return true;
    if ((D()) && (paramg.D()))
      return true;
    if ((m()) && (paramg.m()))
      return true;
    if ((A()) && (paramg.A()))
      return true;
    if ((B()) && (paramg.B()))
      return true;
    if ((F()) && (paramg.p()))
      return true;
    if ((p()) && (paramg.F()))
      return true;
    if ((p()) && (paramg.p()))
      try
      {
        Class localClass1 = getClass().getClassLoader().loadClass(i.d().d(paramg));
        Class localClass2 = getClass().getClassLoader().loadClass(i.d().d(this));
        if ((localClass2.isAssignableFrom(localClass1)) || (localClass1.isAssignableFrom(localClass2)))
          return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return false;
      }
    return (n()) && (paramg.n()) && (J().a(paramg.J()));
  }

  public boolean b(String paramString)
  {
    return a(i.d().a(paramString));
  }

  public boolean c(String paramString)
  {
    return i.d().a(paramString).a(this, false);
  }

  public boolean d(String paramString)
  {
    return i.d().a(paramString).a(this, true);
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

  public int I()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).n())
        return ((Serializable)this.b.get(i)).I();
    return 0;
  }

  public g J()
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      if (((Serializable)this.b.get(i)).s())
        return ((Serializable)this.b.get(i)).J();
      if (((Serializable)this.b.get(i)).n())
        return ((Serializable)this.b.get(i)).J();
    }
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof c))
      return false;
    c localc = (c)paramObject;
    if (this.a.equals(localc.K()))
      return true;
    if ((n()) && (J().equals(localc.J())))
      return true;
    return super.equals(paramObject);
  }

  public Object f(String paramString)
  {
    if (paramString.length() == 0)
      return null;
    if (e())
      return Boolean.valueOf(paramString);
    if (f())
      return Byte.valueOf(paramString);
    if (d())
      return new Character(paramString.charAt(0));
    if (g())
      return Short.valueOf(paramString);
    if (k())
      return Integer.valueOf(paramString);
    if (h())
      return Long.valueOf(paramString);
    if (c())
      return Float.valueOf(paramString);
    if (i())
      return Double.valueOf(paramString);
    if (j())
      return new BigDecimal(paramString);
    if (v())
      try
      {
        return Property.getInstance().parseDate(paramString);
      }
      catch (ParseException localParseException1)
      {
        return null;
      }
    if (w())
      try
      {
        return Property.getInstance().parseTime(paramString);
      }
      catch (ParseException localParseException2)
      {
        return null;
      }
    if (x())
      try
      {
        return Property.getInstance().parseDatetime(paramString);
      }
      catch (ParseException localParseException3)
      {
        return null;
      }
    if (m())
      return paramString;
    if (q())
      return new File(paramString);
    String[] arrayOfString1;
    ArrayList localArrayList1;
    int i;
    if (u())
    {
      arrayOfString1 = paramString.split(";");
      localArrayList1 = new ArrayList(arrayOfString1.length);
      for (i = 0; (i < arrayOfString1.length) && (arrayOfString1[i].length() > 0); i++)
      {
        String[] arrayOfString2 = StringUtil.split(arrayOfString1[i], ",");
        ArrayList localArrayList2 = new ArrayList(arrayOfString2.length);
        for (int j = 0; j < arrayOfString2.length; j++)
          localArrayList2.add(arrayOfString2[j]);
        localArrayList1.add(localArrayList2);
      }
      return localArrayList1;
    }
    if (s())
    {
      arrayOfString1 = paramString.split(",");
      localArrayList1 = new ArrayList(arrayOfString1.length);
      for (i = 0; i < arrayOfString1.length; i++)
        localArrayList1.add(arrayOfString1[i]);
      return localArrayList1;
    }
    return null;
  }

  public boolean d()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).d())
        return true;
    return false;
  }

  public boolean f()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).f())
        return true;
    return false;
  }

  public boolean i()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).i())
        return true;
    return false;
  }

  public boolean c()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).c())
        return true;
    return false;
  }

  public boolean k()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).k())
        return true;
    return false;
  }

  public boolean h()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).h())
        return true;
    return false;
  }

  public boolean g()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).g())
        return true;
    return false;
  }

  public boolean z()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).z())
        return true;
    return false;
  }

  public boolean y()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).y())
        return true;
    return false;
  }

  public boolean j()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).j())
        return true;
    return false;
  }

  public boolean u()
  {
    for (int i = 0; i < this.b.size(); i++)
      if (((Serializable)this.b.get(i)).u())
        return true;
    return false;
  }

  public String toString()
  {
    return this.a;
  }

  public String N()
  {
    return i.d().a(this);
  }

  public String L()
  {
    return i.d().b(this);
  }

  public String M()
  {
    return i.d().d(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.c
 * JD-Core Version:    0.6.0
 */