package com.flagleader.repository.rom;

import com.flagleader.repository.lang.g;

public class e
{
  public static String[] a = { "string", "int", "double", "boolean", "void", "long", "short", "float", "Object", "byte", "char", "date", "time", "datetime", "decimal", "text", "byte[]", "list", "list<list>", "list<string>", "list<int>", "list<double>", "map", "xml" };
  public static String[] b = { "void", "string", "int", "double", "boolean", "long", "short", "float", "date", "time", "datetime", "byte[]" };
  public static String[] c = { "string", "int", "double", "boolean", "long", "short", "float", "Object", "byte", "char", "date", "time", "datetime", "decimal", "byte[]", "list", "map", "xml" };

  public static String[] a()
  {
    return a;
  }

  public static String[] b()
  {
    return b;
  }

  public static String[] c()
  {
    return c;
  }

  public static String a(g paramg)
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
    if (paramg.q())
      return "File";
    if (paramg.z())
      return "Bytes";
    if (paramg.j())
      return "BigDecimal";
    if (paramg.A())
      return "Xml";
    if (paramg.B())
      return "Tree";
    if (paramg.p())
      return "ClassObject";
    return "Object";
  }

  public static String b(g paramg)
  {
    if ((paramg.m()) || (paramg.y()))
      return "java.lang.String";
    if ((paramg.v()) || (paramg.w()) || (paramg.x()))
      return "java.util.Date";
    if ((paramg.s()) && (paramg.K().startsWith("list")))
      return "java.util.List";
    if ((paramg.o()) && (paramg.K().startsWith("map")))
      return "java.util.Map";
    if (paramg.q())
      return "java.io.File";
    if (paramg.z())
      return "byte[]";
    if (paramg.j())
      return "java.math.BigDecimal";
    if (paramg.A())
      return "com.flagleader.xml.Node";
    if (paramg.B())
      return "com.flagleader.xml.TreeValue";
    if ((paramg.n()) && (paramg.I() > 0))
      return b(paramg.J()) + "[]";
    return paramg.K();
  }

  public static String c(g paramg)
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

  public static String a(g paramg1, g paramg2)
  {
    if (paramg2.a(paramg1))
      return "";
    if (paramg2.m())
    {
      if ((paramg1.b()) || (paramg1.j()) || (paramg1.e()) || (paramg1.d()) || (paramg1.z()))
        return "String.valueOf(";
      if (paramg1.v())
        return "new java.text.SimpleDateFormat(Property.getInstance().getDateFormat()).format(";
      if (paramg1.w())
        return "new java.text.SimpleDateFormat(Property.getInstance().getTimeFormat()).format(";
      if (paramg1.x())
        return "new java.text.SimpleDateFormat(Property.getInstance().getDatetimeFormat()).format(";
      if (paramg1.p())
        return "String.valueOf(";
    }
    else if (paramg2.g())
    {
      if (paramg1.m())
        return "Short.parseShort(";
      if (paramg1.F())
        return "Short.parseShort(String.valueOf(";
    }
    else if (paramg2.k())
    {
      if (paramg1.m())
        return "Integer.parseInt(";
      if (paramg1.F())
        return "Integer.parseInt(String.valueOf(";
    }
    else if (paramg2.h())
    {
      if (paramg1.m())
        return "Long.parseLong(";
      if (paramg1.F())
        return "Long.parseLong(String.valueOf(";
    }
    else if (paramg2.c())
    {
      if (paramg1.m())
        return "Float.parseFloat(";
      if (paramg1.F())
        return "Float.parseFloat(String.valueOf(";
    }
    else if (paramg2.i())
    {
      if (paramg1.m())
        return "Double.parseDouble(";
      if (paramg1.F())
        return "Double.parseDouble(String.valueOf(";
    }
    else if (paramg2.e())
    {
      if (paramg1.m())
        return "Boolean.getBoolean(";
      if (paramg1.F())
        return "Boolean.getBoolean(String.valueOf(";
    }
    else if (paramg2.v())
    {
      if (paramg1.m())
        return "new java.text.SimpleDateFormat(Property.getInstance().getDateFormat()).parse(";
    }
    else if (paramg2.w())
    {
      if (paramg1.m())
        return "new java.text.SimpleDateFormat(Property.getInstance().getTimeFormat()).parse(";
    }
    else if ((paramg2.x()) && (paramg1.m()))
    {
      return "new java.text.SimpleDateFormat(Property.getInstance().getDatetimeFormat()).parse(";
    }
    return "";
  }

  public static String b(g paramg1, g paramg2)
  {
    if (paramg2.a(paramg1))
      return "";
    if (paramg2.m())
      return ")";
    if ((paramg2.g()) || (paramg2.k()) || (paramg2.h()) || (paramg2.c()) || (paramg2.i()) || (paramg2.e()))
    {
      if (paramg1.m())
        return ")";
      if (paramg1.F())
        return "))";
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

  public static String d(g paramg)
  {
    if (paramg.e())
      return "Boolean.valueOf(String.valueOf(";
    if (paramg.f())
      return "Byte.valueOf(String.valueOf(";
    if (paramg.d())
      return "(String.valueOf(";
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
    if (paramg.q())
      return "((java.io.File)";
    if (paramg.z())
      return "((byte[])";
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

  public static String e(g paramg)
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
    if (paramg.q())
      return ")";
    if (paramg.z())
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

  public static String f(g paramg)
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

  public static String g(g paramg)
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.e
 * JD-Core Version:    0.6.0
 */