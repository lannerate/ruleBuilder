package com.flagleader.builder.widget.a;

import java.util.Hashtable;

public class W
{
  protected Hashtable a = null;
  protected StringBuffer b = new StringBuffer();
  protected String c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g = false;
  protected int h = 0;
  private String[] j = { "boolean", "break", "byte", "case", "catch", "char", "include", "call", "field", "continue", "default", "do", "double", "else", "false", "final", "finally", "float", "for", "elements", "if", "import", "instanceof", "int", "long", "native", "new", "null", "exportModel", "variable", "package", "return", "short", "super", "switch", "variables", "errorVariables", "inputVariables", "outputVariables", "println", "synchronized", "this", "throw", "true", "try", "volatile", "while", "print", "{", "}", "element", "getVariable", "hasError", "hasSuccess", "getDisVariable", "hasOutput", "hasInput", "successVariables", "variableName" };
  private String[] k = { "getJavaType", "getElementName", "getElementType", "getChildFields", "getAdvanceProperties", "getPropertyValue", "getProperty", "getKeysPre", "isEmptyProp", "getDisplayName", "getVariableName", "getValueType", "getLen", "isUnNull", "getInputType", "getResultType", "getListPos", "getDefaultValue", "getStatType", "getInputValueType", "getShowValue", "getNullType", "getValueFrom", "getTitle", "isPropValue", "isPropValueNoCase", "equalsIgnoreCase", "getJavaTypeName", "getInputFieldCount", "isListList", "isList", "isNumber", "isBoolean", "isChar", "isString", "isDate", "isDateTime", "isTime", "isShort", "isInteger", "isLong", "isFloat", "isDouble" };

  public W(V paramV)
  {
    b();
  }

  public final int a()
  {
    return this.d - this.f;
  }

  public boolean a(String paramString)
  {
    return this.i.e.equals(paramString);
  }

  void b()
  {
    this.a = new Hashtable();
    Integer localInteger = new Integer(2);
    for (int m = 0; m < this.j.length; m++)
      this.a.put(this.j[m], localInteger);
    localInteger = new Integer(11);
    for (m = 0; m < this.k.length; m++)
      this.a.put(this.k[m], localInteger);
  }

  public final int c()
  {
    return this.f;
  }

  public int d()
  {
    this.f = this.d;
    int n = 0;
    while (!this.i.a(this.h + this.d, this.h + this.d))
    {
      n = 1;
      m = e();
      if (m == -1)
        return -1;
    }
    if (n != 0)
      return 9;
    int m = e();
    switch (m)
    {
    case -1:
      return -1;
    case 60:
      m = e();
      if (m == 63)
        return 8;
      a(m);
      return 6;
    case 63:
      m = e();
      if (m == 62)
        return 8;
      a(m);
      return 6;
    case 47:
      m = e();
      if (m == 47)
      {
        do
          m = e();
        while ((m != -1) && (m != 12));
        a(m);
        return 3;
      }
      a(m);
      return 6;
    case 39:
      while (true)
      {
        m = e();
        switch (m)
        {
        case 39:
          return 5;
        case -1:
          a(m);
          return 5;
        case 92:
          m = e();
        }
      }
    case 34:
      while (true)
      {
        m = e();
        switch (m)
        {
        case 34:
          return 5;
        case -1:
          a(m);
          return 5;
        case 92:
          m = e();
        }
      }
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
    case 57:
      do
        m = e();
      while (Character.isDigit((char)m));
      a(m);
      return 7;
    case 123:
    case 125:
      return 8;
    }
    if (Character.isWhitespace((char)m))
    {
      do
        m = e();
      while (Character.isWhitespace((char)m));
      a(m);
      return 1;
    }
    if (Character.isJavaIdentifierStart((char)m))
    {
      this.b.setLength(0);
      do
      {
        this.b.append((char)m);
        m = e();
      }
      while (Character.isJavaIdentifierPart((char)m));
      a(m);
      if (a(this.b.toString()))
        return 10;
      Integer localInteger = (Integer)this.a.get(this.b.toString());
      if (localInteger != null)
        return localInteger.intValue();
      return 0;
    }
    return 6;
  }

  protected int e()
  {
    if (this.d <= this.e)
      return this.c.charAt(this.d++);
    return -1;
  }

  public void a(String paramString, int paramInt)
  {
    this.h = paramInt;
    this.c = paramString;
    this.d = 0;
    this.e = (this.c.length() - 1);
  }

  protected void a(int paramInt)
  {
    if (paramInt != -1)
      this.d -= 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.W
 * JD-Core Version:    0.6.0
 */