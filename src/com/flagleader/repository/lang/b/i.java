package com.flagleader.repository.lang.b;

import com.flagleader.repository.lang.c.A;
import com.flagleader.repository.lang.c.B;
import com.flagleader.repository.lang.c.C;
import com.flagleader.repository.lang.c.D;
import com.flagleader.repository.lang.c.b;
import com.flagleader.repository.lang.c.d;
import com.flagleader.repository.lang.c.e;
import com.flagleader.repository.lang.c.f;
import com.flagleader.repository.lang.c.j;
import com.flagleader.repository.lang.c.k;
import com.flagleader.repository.lang.c.l;
import com.flagleader.repository.lang.c.m;
import com.flagleader.repository.lang.c.n;
import com.flagleader.repository.lang.c.o;
import com.flagleader.repository.lang.c.q;
import com.flagleader.repository.lang.c.r;
import com.flagleader.repository.lang.c.s;
import com.flagleader.repository.lang.c.t;
import com.flagleader.repository.lang.c.u;
import com.flagleader.repository.lang.c.v;
import com.flagleader.repository.lang.c.w;
import com.flagleader.repository.lang.c.x;
import com.flagleader.repository.lang.c.y;
import com.flagleader.repository.lang.c.z;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Hashtable;

public class i
  implements com.flagleader.repository.lang.h
{
  private static i d = new i();
  public static String[] a = { "string", "int", "double", "boolean", "long", "short", "float", "Object", "byte", "char", "date", "time", "datetime", "decimal", "file", "string[]", "byte[]", "list", "list<list>", "map", "list<string>", "list<int>", "list<double>", "xml", "tree", "sheet", "excel", "void" };
  public static String[] b = { "void", "string", "int", "double", "boolean", "long", "short", "float", "decimal", "date", "time", "datetime", "byte[]", "file", "xml", "tree", "sheet", "excel" };
  public static String[] c = { "string", "int", "double", "boolean", "long", "short", "float", "Object", "byte", "char", "date", "time", "datetime", "decimal", "string[]", "byte[]", "file", "list", "map", "xml", "tree", "sheet", "excel" };
  private static final Hashtable e = new Hashtable();

  static
  {
    i(new com.flagleader.repository.lang.c.c(d));
    i(new f(d));
    a("java.util.Date", new f(d));
    i(new com.flagleader.repository.lang.c.g(d));
    i(new A(d));
    i(new y(d));
    a("java.lang.String", new y(d));
    a("String", new y(d));
    i(new w(d));
    i(new m(d));
    i(new s(d));
    i(new l(d));
    i(new com.flagleader.repository.lang.c.i(d));
    i(new b(d));
    i(new d(d));
    i(new com.flagleader.repository.lang.c.h(d));
    a("java.math.BigDecimal", new com.flagleader.repository.lang.c.h(d));
    i(new j(d));
    a("com.flagleader.excel.IExcelBook", new j(d));
    i(new k(d));
    a("java.io.File", new k(d));
    i(new e(d));
    i(new n(d));
    i(new o(d));
    i(new q(d));
    i(new r(d));
    a("java.util.List", new r(d));
    a("java.util.ArrayList", new r(d));
    a("ArrayList", new r(d));
    i(new t(d));
    a("java.util.Map", new t(d));
    a("java.util.HashMap", new t(d));
    a("HashMap", new t(d));
    i(new u(d));
    a("java.lang.Object", new u(d));
    i(new v(d));
    a("com.flagleader.db.Sheet", new v(d));
    i(new x(d));
    a("java.lang.String[]", new x(d));
    a("String[]", new x(d));
    i(new z(d));
    i(new B(d));
    a("com.flagleader.xml.TreeValue", new B(d));
    i(new C(d));
    i(new D(d));
    a("com.flagleader.xml.Node", new D(d));
    a("sheetfields", new y(d));
    a("sheetfuncs", new y(d));
    a("sheetwheres", new y(d));
    a("sheetandfields", new v(d));
    a("sheetandwheres", new v(d));
    a("sheetdynamic", new v(d));
    a("sheetfentan", new v(d));
    a("resultandfields", new h("com.flagleader.db.IResult"));
    a("resultandwheres", new h("com.flagleader.db.IResult"));
    a("resultdynamic", new h("com.flagleader.db.IResult"));
    a("resultfentan", new h("com.flagleader.db.IResult"));
  }

  public static void i(com.flagleader.repository.lang.g paramg)
  {
    e.put(paramg.K(), paramg);
  }

  public static void a(String paramString, com.flagleader.repository.lang.g paramg)
  {
    e.put(paramString, paramg);
  }

  public com.flagleader.repository.lang.g a(String paramString)
  {
    Object localObject = (com.flagleader.repository.lang.g)e.get(paramString);
    if (localObject == null)
    {
      if (paramString.indexOf(";") >= 0)
        localObject = new c(paramString);
      else
        localObject = new h(paramString);
      i((com.flagleader.repository.lang.g)localObject);
    }
    return (com.flagleader.repository.lang.g)localObject;
  }

  public String[] a()
  {
    return a;
  }

  public String[] b()
  {
    return b;
  }

  public String[] c()
  {
    return c;
  }

  public String[] b(String paramString)
  {
    com.flagleader.repository.lang.g localg = a(paramString);
    if ((localg.k()) || (localg.h()) || (localg.g()))
      return new String[] { "int", "long", "short" };
    if ((localg.c()) || (localg.i()))
      return new String[] { "float", "double", "int", "long", "short", "decimal" };
    if ((localg.v()) || (localg.w()) || (localg.x()))
      return new String[] { "date", "time", "datetime" };
    if ((localg.m()) || (localg.y()) || (localg.s()) || (localg.o()) || (localg.q()) || (localg.p()))
      return new String[] { "string", "xml", "list", "map", "byte[]", "file", "Object", "sheet", "excel" };
    if ((localg.z()) || (localg.C()) || (localg.D()))
      return new String[] { "string", "byte[]", "file", "Object", "sheet", "excel" };
    return new String[] { localg.K(), "Object" };
  }

  public String c(String paramString)
  {
    com.flagleader.repository.lang.g localg = a(paramString);
    if (localg.e())
      return "new Boolean( {boolean})";
    if (localg.f())
      return "new Byte( {byte})";
    if (localg.d())
      return "new Character( {char})";
    if (localg.g())
      return "new Short( {short})";
    if (localg.k())
      return "new Integer( {int})";
    if (localg.h())
      return "new Long( {long})";
    if (localg.c())
      return "new Float( {float})";
    if (localg.i())
      return "new Double( {double})";
    if (localg.j())
      return "new java.math.BigDecimal( {string})";
    if (localg.v())
      return "new java.sql.Date(( {date}).getTime())";
    if (localg.w())
      return "new java.sql.Time(( {date}).getTime())";
    if (localg.x())
      return "new java.sql.Timestamp(( {date}).getTime())";
    if (localg.m())
      return " {string}";
    return " {" + paramString + "}";
  }

  public String a(String paramString1, String paramString2)
  {
    com.flagleader.repository.lang.g localg = a(paramString1);
    if (localg.e())
      return "new Boolean( {" + paramString2 + "})";
    if (localg.f())
      return "new Byte( {" + paramString2 + "})";
    if (localg.d())
      return "new Character( {" + paramString2 + "})";
    if (localg.g())
      return "new Short( {" + paramString2 + "})";
    if (localg.k())
      return "new Integer( {" + paramString2 + "})";
    if (localg.h())
      return "new Long( {" + paramString2 + "})";
    if (localg.c())
      return "new Float( {" + paramString2 + "})";
    if (localg.i())
      return "new Double( {" + paramString2 + "})";
    if (localg.j())
      return "new java.math.BigDecimal( {" + paramString2 + "})";
    if (localg.v())
      return "new java.sql.Date(( {" + paramString2 + "}).getTime())";
    if (localg.w())
      return "new java.sql.Time(( {" + paramString2 + "}).getTime())";
    if (localg.x())
      return "new java.sql.Timestamp(( {" + paramString2 + "}).getTime())";
    if (localg.m())
      return " {" + paramString2 + "}";
    return " {" + paramString2 + "}";
  }

  public Object d(String paramString)
  {
    com.flagleader.repository.lang.g localg = a(paramString);
    if (localg.e())
      return new Boolean(true);
    if (localg.f())
      return new Byte("0");
    if (localg.d())
      return new Character('0');
    if (localg.g())
      return Short.valueOf("0");
    if (localg.k())
      return Integer.valueOf("0");
    if (localg.h())
      return Long.valueOf("0");
    if (localg.c())
      return Float.valueOf("0");
    if (localg.i())
      return Double.valueOf("0");
    if (localg.j())
      return BigDecimal.valueOf(0L);
    if (localg.v())
      return new java.sql.Date(new java.util.Date().getTime());
    if (localg.w())
      return new Time(new java.util.Date().getTime());
    if (localg.x())
      return new Timestamp(new java.util.Date().getTime());
    if (localg.m())
      return "";
    if (localg.z())
      return new byte[0];
    if (localg.s())
    {
      if (localg.J().b())
        return new Integer(0);
      if (localg.J().j())
        return new BigDecimal(0);
      return "";
    }
    return "''";
  }

  public String a(com.flagleader.repository.lang.g paramg)
  {
    if (paramg.e())
      return "Boolean";
    if (paramg.f())
      return "Byte";
    if (paramg.d())
      return "Character";
    if (paramg.g())
      return "Short";
    if (paramg.h())
      return "Long";
    if (paramg.k())
      return "Integer";
    if (paramg.c())
      return "Float";
    if (paramg.i())
      return "Double";
    if (paramg.y())
      return "Text";
    if (paramg.m())
      return "String";
    if (paramg.v())
      return "Date";
    if (paramg.w())
      return "Time";
    if (paramg.x())
      return "Timestamp";
    if (paramg.s())
      return "ListObject";
    if (paramg.o())
      return "MapObject";
    if (paramg.z())
      return "Bytes";
    if (paramg.q())
      return "File";
    if (paramg.j())
      return "BigDecimal";
    if (paramg.A())
      return "Xml";
    if (paramg.B())
      return "Tree";
    if (paramg.D())
      return "SheetObject";
    if (paramg.C())
      return "ExcelObject";
    if (paramg.p())
      return "ClassObject";
    if (paramg.H())
      return "StringArray";
    return "Object";
  }

  public String b(com.flagleader.repository.lang.g paramg)
  {
    if ((paramg.m()) || (paramg.y()))
      return "java.lang.String";
    if ((paramg.v()) || (paramg.w()) || (paramg.x()))
      return "java.util.Date";
    if ((paramg.s()) && (paramg.K().startsWith("list")))
      return "java.util.List";
    if ((paramg.o()) && (paramg.K().startsWith("map")))
      return "java.util.Map";
    if (paramg.C())
      return "com.flagleader.excel.IExcelBook";
    if (paramg.D())
      return "com.flagleader.db.Sheet";
    if (paramg.z())
      return "byte[]";
    if (paramg.q())
      return "java.io.File";
    if (paramg.j())
      return "java.math.BigDecimal";
    if (paramg.A())
      return "com.flagleader.xml.Node";
    if (paramg.B())
      return "com.flagleader.xml.TreeValue";
    if (paramg.n())
      return b(paramg.J()) + "[]";
    if (paramg.F())
      return "Object";
    return paramg.K();
  }

  public String c(com.flagleader.repository.lang.g paramg)
  {
    if ((paramg.n()) && (paramg.K().indexOf("[") > 0))
    {
      String str = paramg.K().substring(0, paramg.K().indexOf("["));
      return b(a(str)) + paramg.K().substring(paramg.K().indexOf("["));
    }
    return paramg.K();
  }

  public String d(com.flagleader.repository.lang.g paramg)
  {
    if (paramg.e())
      return "Boolean";
    if (paramg.f())
      return "Byte";
    if (paramg.d())
      return "Character";
    if (paramg.g())
      return "Short";
    if (paramg.h())
      return "Long";
    if (paramg.k())
      return "Integer";
    if (paramg.c())
      return "Float";
    if (paramg.i())
      return "Double";
    return b(paramg);
  }

  public String a(com.flagleader.repository.lang.g paramg1, com.flagleader.repository.lang.g paramg2)
  {
    if (paramg1.F())
    {
      if (paramg2.m())
        return "com.flagleader.util.LangUtil.getString(";
      if (paramg2.g())
        return "com.flagleader.util.LangUtil.getShort(";
      if (paramg2.k())
        return "com.flagleader.util.LangUtil.getInt(";
      if (paramg2.h())
        return "com.flagleader.util.LangUtil.getLong(";
      if (paramg2.c())
        return "com.flagleader.util.LangUtil.getFloat(";
      if (paramg2.i())
        return "com.flagleader.util.LangUtil.getDouble(";
      if (paramg2.e())
        return "com.flagleader.util.LangUtil.getBoolean(";
      if (paramg2.v())
        return "com.flagleader.util.LangUtil.getDate(";
      if (paramg2.w())
        return "com.flagleader.util.LangUtil.getTime(";
      if (paramg2.x())
        return "com.flagleader.util.LangUtil.getDateTime(";
      if (paramg2.d())
        return "com.flagleader.util.LangUtil.getChar(";
      if (paramg2.z())
        return "com.flagleader.util.LangUtil.getBinary(";
      if (paramg2.f())
        return "com.flagleader.util.LangUtil.getByte(";
      if (paramg2.u())
        return "com.flagleader.util.LangUtil.getList(";
      if (paramg2.s())
        return "com.flagleader.util.LangUtil.getList(";
      if (paramg2.o())
        return "com.flagleader.util.LangUtil.getMap(";
      if (paramg2.A())
        return "com.flagleader.util.LangUtil.getXml(";
      if (paramg2.B())
        return "com.flagleader.util.LangUtil.getTree(";
      if (paramg2.j())
        return "com.flagleader.util.LangUtil.getDecimal(";
    }
    if (paramg2.F())
    {
      if (paramg1.g())
        return "new Short(";
      if (paramg1.k())
        return "new Integer(";
      if (paramg1.h())
        return "new Long(";
      if (paramg1.c())
        return "new Float(";
      if (paramg1.i())
        return "new Double(";
      if (paramg1.e())
        return "new Boolean(";
      if (paramg1.d())
        return "new Character(";
      if (paramg1.f())
        return "new Byte(";
    }
    if (paramg2.a(paramg1))
      return "";
    if (paramg2.m())
    {
      if (paramg1.i())
        return "StringUtil.stringValue(";
      if ((paramg1.b()) || (paramg1.e()) || (paramg1.d()) || (paramg1.z()) || (paramg1.j()))
        return "String.valueOf(";
      if (paramg1.v())
        return "Property.getInstance().formatDate(";
      if (paramg1.w())
        return "Property.getInstance().formatTime(";
      if (paramg1.x())
        return "Property.getInstance().formatDatetime(";
      if (paramg1.p())
        return "String.valueOf(";
    }
    else if (paramg2.g())
    {
      if (paramg1.m())
        return "com.flagleader.util.NumberUtil.parseShort(";
      if (paramg1.j())
        return "com.flagleader.util.DecimalUtil.parseShort(";
      if (paramg1.F())
        return "com.flagleader.util.NumberUtil.parseShort(String.valueOf(";
    }
    else if (paramg2.k())
    {
      if (paramg1.m())
        return "com.flagleader.util.NumberUtil.parseInt(";
      if (paramg1.j())
        return "com.flagleader.util.DecimalUtil.parseInt(";
      if (paramg1.F())
        return "com.flagleader.util.NumberUtil.parseInt(String.valueOf(";
    }
    else if (paramg2.h())
    {
      if (paramg1.m())
        return "com.flagleader.util.NumberUtil.parseLong(";
      if (paramg1.j())
        return "com.flagleader.util.DecimalUtil.parseLong(";
      if (paramg1.F())
        return "com.flagleader.util.NumberUtil.parseLong(String.valueOf(";
    }
    else if (paramg2.c())
    {
      if (paramg1.m())
        return "com.flagleader.util.NumberUtil.parseFloat(";
      if (paramg1.j())
        return "com.flagleader.util.DecimalUtil.parseFloat(";
      if (paramg1.F())
        return "com.flagleader.util.NumberUtil.parseFloat(String.valueOf(";
    }
    else if (paramg2.i())
    {
      if (paramg1.m())
        return "com.flagleader.util.NumberUtil.parseDouble(";
      if (paramg1.j())
        return "com.flagleader.util.DecimalUtil.parseDouble(";
      if (paramg1.F())
        return "com.flagleader.util.NumberUtil.parseDouble(String.valueOf(";
    }
    else if (paramg2.e())
    {
      if (paramg1.m())
        return "com.flagleader.util.NumberUtil.parseBoolean(";
      if (paramg1.j())
        return "DecimalUtil.parseBoolean(";
      if (paramg1.F())
        return "com.flagleader.util.NumberUtil.parseBoolean(String.valueOf(";
    }
    else if (paramg2.j())
    {
      if (paramg1.m())
        return "com.flagleader.util.LangUtil.getDecimal(";
      if (paramg1.F())
        return "com.flagleader.util.LangUtil.getDecimal(String.valueOf(";
      if (paramg1.b())
        return "new java.math.BigDecimal((double)";
    }
    else if (paramg2.v())
    {
      if (paramg1.m())
        return "DateUtil.formatDate(";
    }
    else if (paramg2.w())
    {
      if (paramg1.m())
        return "DateUtil.formatTime(";
    }
    else if ((paramg2.x()) && (paramg1.m()))
    {
      return "DateUtil.formatDatetime(";
    }
    return "";
  }

  public String b(com.flagleader.repository.lang.g paramg1, com.flagleader.repository.lang.g paramg2)
  {
    if (paramg1.F())
    {
      if (paramg2.m())
        return ")";
      if (paramg2.g())
        return ")";
      if (paramg2.k())
        return ")";
      if (paramg2.h())
        return ")";
      if (paramg2.c())
        return ")";
      if (paramg2.i())
        return ")";
      if (paramg2.e())
        return ")";
      if (paramg2.v())
        return ")";
      if (paramg2.w())
        return ")";
      if (paramg2.x())
        return ")";
      if (paramg2.d())
        return ")";
      if (paramg2.z())
        return ")";
      if (paramg2.f())
        return ")";
      if (paramg2.u())
        return ",\"" + paramg2.K() + "\")";
      if (paramg2.s())
        return ",\"" + paramg2.K() + "\")";
      if (paramg2.o())
        return ")";
      if (paramg2.A())
        return ")";
      if (paramg2.B())
        return ")";
      if (paramg2.j())
        return ")";
    }
    if (paramg2.F())
    {
      if ((paramg1.b()) || (paramg1.j()))
        return ")";
      if (paramg1.e())
        return ")";
      if (paramg1.d())
        return ")";
      if (paramg1.f())
        return ")";
    }
    if (paramg2.a(paramg1))
      return "";
    if (paramg2.m())
      return ")";
    if (paramg2.g())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.j())
        return ")";
      if (paramg1.F())
        return "))";
    }
    else if (paramg2.k())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.j())
        return ")";
      if (paramg1.F())
        return "))";
    }
    else if (paramg2.h())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.j())
        return ")";
      if (paramg1.F())
        return "))";
    }
    else if (paramg2.c())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.j())
        return ")";
      if (paramg1.F())
        return "))";
    }
    else if (paramg2.i())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.j())
        return ")";
      if (paramg1.F())
        return "))";
    }
    else if (paramg2.e())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.j())
        return ")";
      if (paramg1.F())
        return "))";
    }
    else if (paramg2.j())
    {
      if (paramg1.m())
        return ")";
      if (paramg1.F())
        return "))";
      if (paramg1.b())
        return ")";
    }
    else if (paramg2.v())
    {
      if (paramg1.m())
        return ")";
    }
    else if (paramg2.w())
    {
      if (paramg1.m())
        return ")";
    }
    else if ((paramg2.x()) && (paramg1.m()))
    {
      return ")";
    }
    return "";
  }

  public String e(com.flagleader.repository.lang.g paramg)
  {
    if (paramg.e())
      return "Boolean.valueOf(String.valueOf(";
    if (paramg.f())
      return "Byte.valueOf(String.valueOf(";
    if (paramg.d())
      return "String.valueOf(";
    if (paramg.g())
      return "Short.valueOf(String.valueOf(";
    if (paramg.h())
      return "Long.valueOf(String.valueOf(";
    if (paramg.k())
      return "Integer.valueOf(String.valueOf(";
    if (paramg.c())
      return "Float.valueOf(String.valueOf(";
    if (paramg.i())
      return "Double.valueOf(String.valueOf(";
    if (paramg.m())
      return "String.valueOf(";
    if ((paramg.v()) || (paramg.w()) || (paramg.x()))
      return "((java.util.Date)";
    if (paramg.s())
      return "((java.util.List)";
    if (paramg.o())
      return "((java.util.Map)";
    if (paramg.z())
      return "((byte[])";
    if (paramg.q())
      return "((java.io.File)";
    if (paramg.D())
      return "((com.flagleader.db.Sheet)";
    if (paramg.C())
      return "((com.flagleader.excel.IExcelBook)";
    if (paramg.j())
      return "((java.math.BigDecimal)";
    if (paramg.A())
      return "((com.flagleader.xml.Node)";
    if (paramg.B())
      return "((com.flagleader.xml.TreeValue)";
    if ((paramg.p()) && (!paramg.K().equalsIgnoreCase("Object")))
      return "((" + paramg.K() + ")";
    return "";
  }

  public String f(com.flagleader.repository.lang.g paramg)
  {
    if (paramg.e())
      return ")).booleanValue()";
    if (paramg.f())
      return ")).byteValue()";
    if (paramg.d())
      return ").charAt(0)";
    if (paramg.g())
      return ")).shortValue()";
    if (paramg.h())
      return ")).longValue()";
    if (paramg.k())
      return ")).intValue()";
    if (paramg.c())
      return ")).floatValue()";
    if (paramg.i())
      return ")).doubleValue()";
    if (paramg.m())
      return ")";
    if ((paramg.v()) || (paramg.w()) || (paramg.x()))
      return ")";
    if (paramg.s())
      return ")";
    if (paramg.o())
      return ")";
    if (paramg.z())
      return ")";
    if (paramg.q())
      return ")";
    if (paramg.D())
      return ")";
    if (paramg.C())
      return ")";
    if (paramg.j())
      return ")";
    if (paramg.A())
      return ")";
    if (paramg.B())
      return ")";
    if ((paramg.p()) && (!paramg.K().equalsIgnoreCase("Object")))
      return ")";
    return "";
  }

  public String g(com.flagleader.repository.lang.g paramg)
  {
    if (paramg.e())
      return "new Boolean(";
    if (paramg.f())
      return "new Byte(";
    if (paramg.d())
      return "new Character(";
    if (paramg.g())
      return "new Short(";
    if (paramg.h())
      return "new Long(";
    if (paramg.k())
      return "new Integer(";
    if (paramg.c())
      return "new Float(";
    if (paramg.i())
      return "new Double(";
    return "";
  }

  public String h(com.flagleader.repository.lang.g paramg)
  {
    if (paramg.e())
      return ")";
    if (paramg.f())
      return ")";
    if (paramg.d())
      return ")";
    if (paramg.g())
      return ")";
    if (paramg.h())
      return ")";
    if (paramg.k())
      return ")";
    if (paramg.c())
      return ")";
    if (paramg.i())
      return ")";
    return "";
  }

  public static i d()
  {
    return d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.i
 * JD-Core Version:    0.6.0
 */