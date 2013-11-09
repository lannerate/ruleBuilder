package com.flagleader.builder.widget.a;

import java.util.Hashtable;

public class s
{
  protected Hashtable a = null;
  protected StringBuffer b = new StringBuffer();
  protected String c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g = false;
  protected int h = 0;
  private String[] j = { "boolean", "break", "byte", "case", "catch", "char", "exception", "continue", "default", "do", "double", "else", "false", "final", "finally", "float", "for", "if", "import", "instanceof", "int", "long", "native", "new", "null", "pageContext", "application", "package", "return", "short", "super", "switch", "request", "response", "session", "out", "config", "synchronized", "this", "throw", "true", "try", "volatile", "while", "=", "page", "{", "}" };

  public s(r paramr)
  {
    b();
  }

  public final int a()
  {
    return this.d - this.f;
  }

  public void a(Object paramObject)
  {
    this.a.put(paramObject, new Integer(11));
  }

  void b()
  {
    this.a = new Hashtable();
    Integer localInteger = new Integer(2);
    for (int k = 0; k < this.j.length; k++)
      this.a.put(this.j[k], localInteger);
  }

  public final int c()
  {
    return this.f;
  }

  public boolean a(String paramString)
  {
    return this.i.e.equals(paramString);
  }

  public int d()
  {
    this.f = this.d;
    int m = 0;
    while (!this.i.a(this.h + this.d, this.h + this.d))
    {
      m = 1;
      k = e();
      if (k == -1)
        return -1;
    }
    if (m != 0)
      return 9;
    int k = e();
    switch (k)
    {
    case -1:
      return -1;
    case 60:
      k = e();
      if (k == 37)
        return 8;
      a(k);
      return 6;
    case 37:
      k = e();
      if (k == 62)
        return 8;
      a(k);
      return 6;
    case 47:
      k = e();
      if (k == 47)
      {
        do
          k = e();
        while ((k != -1) && (k != 12));
        a(k);
        return 3;
      }
      a(k);
      return 6;
    case 39:
      while (true)
      {
        k = e();
        switch (k)
        {
        case 39:
          return 5;
        case -1:
          a(k);
          return 5;
        case 92:
          k = e();
        }
      }
    case 34:
      while (true)
      {
        k = e();
        switch (k)
        {
        case 34:
          return 5;
        case -1:
          a(k);
          return 5;
        case 92:
          k = e();
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
        k = e();
      while (Character.isDigit((char)k));
      a(k);
      return 7;
    case 123:
    case 125:
      return 8;
    }
    if (Character.isWhitespace((char)k))
    {
      do
        k = e();
      while (Character.isWhitespace((char)k));
      a(k);
      return 1;
    }
    if (Character.isJavaIdentifierStart((char)k))
    {
      this.b.setLength(0);
      do
      {
        this.b.append((char)k);
        k = e();
      }
      while (Character.isJavaIdentifierPart((char)k));
      a(k);
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
 * Qualified Name:     com.flagleader.builder.widget.a.s
 * JD-Core Version:    0.6.0
 */