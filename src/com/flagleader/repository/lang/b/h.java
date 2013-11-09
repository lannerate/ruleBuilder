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
import java.util.Map;

public final class h
  implements g, Serializable
{
  private String a = "";

  h(String paramString)
  {
    g(paramString);
  }

  h(h paramh)
  {
    g(paramh.a);
  }

  public boolean a()
  {
    return false;
  }

  public String K()
  {
    return this.a;
  }

  public void g(String paramString)
  {
    this.a = paramString.trim();
  }

  protected Object clone()
  {
    return new h(this);
  }

  public boolean n()
  {
    return (!this.a.equals("binary")) && (this.a.trim().endsWith("]"));
  }

  public boolean H()
  {
    return (this.a.endsWith("]")) && (this.a.toLowerCase().startsWith("string["));
  }

  public boolean e()
  {
    return this.a.equals("boolean");
  }

  public boolean E()
  {
    return this.a.length() == 0;
  }

  public boolean p()
  {
    return (!b()) && (!e()) && (!f()) && (!d()) && (!n()) && (!z()) && (!l()) && (!E());
  }

  public boolean r()
  {
    if ((m()) || (v()) || (w()) || (x()) || (q()) || (s()) || (o()) || (y()) || (F()) || (C()) || (D()) || (j()))
      return false;
    return p();
  }

  public boolean v()
  {
    return (this.a.equalsIgnoreCase("date")) || (this.a.equals("java.util.Date")) || (this.a.equals("java.sql.Date"));
  }

  public boolean G()
  {
    return (v()) || (w()) || (x());
  }

  public boolean F()
  {
    return (this.a.equalsIgnoreCase("object")) || (this.a.equals("java.lang.Object"));
  }

  public boolean w()
  {
    return (this.a.equalsIgnoreCase("time")) || (this.a.equals("java.util.Date")) || (this.a.equals("java.sql.Time"));
  }

  public boolean x()
  {
    return (this.a.equalsIgnoreCase("datetime")) || (this.a.equals("java.util.Date")) || (this.a.equals("java.sql.Timestamp")) || (this.a.equalsIgnoreCase("timestamp"));
  }

  public boolean q()
  {
    return (this.a.equalsIgnoreCase("file")) || (this.a.equals("java.io.File"));
  }

  public boolean s()
  {
    try
    {
      return (this.a.equals("list")) || (this.a.startsWith("list<")) || (List.class.isAssignableFrom(getClass().getClassLoader().loadClass(this.a)));
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean P()
  {
    try
    {
      return (this.a.equals("list")) || (this.a.startsWith("list<")) || (this.a.equals("ArrayList")) || (this.a.equals("java.util.ArrayList"));
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean t()
  {
    try
    {
      return this.a.startsWith("list<");
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean o()
  {
    try
    {
      return (this.a.equals("map")) || (this.a.startsWith("map<")) || (Map.class.isAssignableFrom(getClass().getClassLoader().loadClass(this.a)));
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean O()
  {
    try
    {
      return (this.a.equals("map")) || (this.a.startsWith("map<")) || (this.a.equals("HashMap")) || (this.a.equals("java.util.HashMap"));
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean b()
  {
    return (k()) || (g()) || (h()) || (c()) || (i());
  }

  public boolean m()
  {
    return (this.a.equalsIgnoreCase("string")) || (this.a.equalsIgnoreCase("java.lang.String")) || (this.a.equalsIgnoreCase("text"));
  }

  public boolean l()
  {
    return (this.a.length() == 0) || (this.a.equalsIgnoreCase("void"));
  }

  public boolean A()
  {
    return (this.a.equalsIgnoreCase("xml")) || (this.a.equalsIgnoreCase("Node")) || (this.a.equalsIgnoreCase("com.flagleader.xml.Node")) || (this.a.equalsIgnoreCase("com.flagleader.xml.JDomNode"));
  }

  public boolean B()
  {
    return (this.a.equalsIgnoreCase("tree")) || (this.a.equalsIgnoreCase("TreeValue")) || (this.a.equalsIgnoreCase("com.flagleader.xml.TreeValue")) || (this.a.equalsIgnoreCase("com.flagleader.xml.SingleTreeValue")) || (this.a.equalsIgnoreCase("com.flagleader.xml.MultiTreeValue"));
  }

  public boolean C()
  {
    return (this.a.equalsIgnoreCase("excel")) || (this.a.equalsIgnoreCase("IExcelBook")) || (this.a.equalsIgnoreCase("com.flagleader.excel.IExcelBook")) || (this.a.equalsIgnoreCase("com.flagleader.excel.poi.PoiExcelBook"));
  }

  public boolean D()
  {
    return (this.a.equalsIgnoreCase("sheet")) || (this.a.equalsIgnoreCase("Sheet")) || (this.a.equalsIgnoreCase("com.flagleader.db.Sheet")) || (this.a.equalsIgnoreCase("com.flagleader.sql.ArraySheet"));
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
    if ((n()) && (this.a.lastIndexOf("[") > 0) && (this.a.lastIndexOf("]") > this.a.lastIndexOf("[") + 1))
      return Integer.parseInt(this.a.substring(this.a.lastIndexOf("[") + 1, this.a.lastIndexOf("]")));
    return 0;
  }

  public g J()
  {
    if (s())
    {
      if ((this.a.lastIndexOf("<") > 0) && (this.a.lastIndexOf(">") > this.a.lastIndexOf("<")))
        return i.d().a(this.a.substring(this.a.lastIndexOf("<") + 1, this.a.lastIndexOf(">")));
      return i.d().a("Object");
    }
    if (n())
    {
      if (this.a.lastIndexOf("[") > this.a.indexOf("["))
        return i.d().a(this.a.substring(0, this.a.indexOf("[")) + this.a.substring(this.a.indexOf("]") + 1));
      return i.d().a(this.a.substring(0, this.a.lastIndexOf("[")));
    }
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof h))
      return false;
    h localh = (h)paramObject;
    if (this.a.equals(localh.K()))
      return true;
    if ((n()) && (J().equals(localh.J())))
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

  public boolean Q()
  {
    return (m()) || (v()) || (w()) || (x()) || (q()) || (s()) || (o()) || (p()) || (y()) || (j());
  }

  private boolean R()
  {
    if ((s()) || (o()) || (D()))
      return true;
    if (p())
      try
      {
        return Serializable.class.isAssignableFrom(getClass().getClassLoader().loadClass(this.a));
      }
      catch (Exception localException)
      {
        return false;
      }
    return false;
  }

  public boolean d()
  {
    return this.a.equals("char");
  }

  public boolean f()
  {
    return this.a.equals("byte");
  }

  public boolean i()
  {
    return this.a.equals("double");
  }

  public boolean c()
  {
    return this.a.equals("float");
  }

  public boolean k()
  {
    return this.a.equals("int");
  }

  public boolean h()
  {
    return this.a.equals("long");
  }

  public boolean g()
  {
    return this.a.equals("short");
  }

  public boolean z()
  {
    return (this.a.equals("byte[]")) || (this.a.equals("binary"));
  }

  public boolean y()
  {
    return this.a.equals("text");
  }

  public boolean j()
  {
    return (this.a.equals("decimal")) || (this.a.equals("java.math.BigDecimal"));
  }

  public boolean u()
  {
    return (J() != null) && (s()) && (J().s());
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
 * Qualified Name:     com.flagleader.repository.lang.b.h
 * JD-Core Version:    0.6.0
 */