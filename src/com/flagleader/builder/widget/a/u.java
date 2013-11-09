package com.flagleader.builder.widget.a;

import java.util.HashMap;

public class u
{
  protected StringBuffer a = new StringBuffer();
  protected String b;
  protected int c;
  protected int d;
  protected int e;
  protected boolean f = false;

  public u(t paramt)
  {
    b();
  }

  public final int a()
  {
    return this.c - this.e;
  }

  public boolean a(char paramChar)
  {
    return t.c.indexOf(paramChar) >= 0;
  }

  public boolean a(String paramString)
  {
    return this.g.f.equals(paramString);
  }

  void b()
  {
  }

  public void a(Object paramObject)
  {
    t.b.put(paramObject, new Integer(8));
  }

  public final int c()
  {
    return this.e;
  }

  public int d()
  {
    this.e = this.c;
    int i;
    switch (i = e())
    {
    case -1:
      return -1;
    case 47:
      i = e();
      if (i == 47)
      {
        do
          i = e();
        while ((i != -1) && (i != 11));
        a(i);
        return 3;
      }
      a(i);
      return 6;
    case 39:
      while (true)
      {
        i = e();
        switch (i)
        {
        case 39:
          return 5;
        case -1:
          a(i);
          return 5;
        case 92:
          i = e();
        }
      }
    case 34:
      while (true)
      {
        i = e();
        switch (i)
        {
        case 34:
          return 5;
        case -1:
          a(i);
          return 5;
        case 92:
          i = e();
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
        i = e();
      while (Character.isDigit((char)i));
      a(i);
      return 7;
    }
    if (Character.isWhitespace((char)i))
    {
      do
        i = e();
      while (Character.isWhitespace((char)i));
      a(i);
      return 1;
    }
    if (Character.isJavaIdentifierStart((char)i))
    {
      this.a.setLength(0);
      do
      {
        this.a.append((char)i);
        i = e();
      }
      while (Character.isJavaIdentifierPart((char)i));
      a(i);
      if (a(this.a.toString()))
        return 10;
      Integer localInteger = (Integer)t.b.get(this.a.toString());
      if (localInteger != null)
        return localInteger.intValue();
      return 0;
    }
    return 6;
  }

  protected int e()
  {
    if (this.c <= this.d)
      return this.b.charAt(this.c++);
    return -1;
  }

  public void b(String paramString)
  {
    this.b = paramString;
    this.c = 0;
    this.d = (this.b.length() - 1);
  }

  protected void a(int paramInt)
  {
    if (paramInt != -1)
      this.c -= 1;
  }

  public String f()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.u
 * JD-Core Version:    0.6.0
 */