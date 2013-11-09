package com.flagleader.builder.widget.a;

import java.util.Hashtable;

public class b
{
  protected Hashtable a = null;
  protected StringBuffer b = new StringBuffer();
  protected String c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g = false;

  public b(a parama)
  {
    b();
  }

  private boolean b(char paramChar)
  {
    for (int i = 0; i < a.t.length; i++)
      for (int j = 0; j < a.t[i].length(); j++)
        if (a.t[i].charAt(j) == paramChar)
          return true;
    return false;
  }

  public final int a()
  {
    return this.d - this.f;
  }

  public boolean a(char paramChar)
  {
    return a.u.indexOf(paramChar) >= 0;
  }

  public boolean a(String paramString)
  {
    return this.h.f.equals(paramString);
  }

  void b()
  {
    this.a = new Hashtable();
    Integer localInteger = new Integer(2);
    for (int i = 0; i < a.t.length; i++)
      this.a.put(a.t[i], localInteger);
  }

  public void a(Object paramObject)
  {
    this.a.put(paramObject, new Integer(8));
  }

  public final int c()
  {
    return this.f;
  }

  public int d()
  {
    this.f = this.d;
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
    if (!a((char)i))
    {
      this.b.setLength(0);
      do
      {
        this.b.append((char)i);
        if (a(this.b.toString()))
          return 10;
        i = e();
      }
      while ((!a((char)i)) && (!Character.isWhitespace((char)i)) && (i != -1));
      a(i);
      if (a(this.b.toString()))
        return 10;
      Integer localInteger = (Integer)this.a.get(this.b.toString());
      if (localInteger != null)
        return localInteger.intValue();
      return 0;
    }
    if (a((char)i))
      return 9;
    return 6;
  }

  protected int e()
  {
    if (this.d <= this.e)
      return this.c.charAt(this.d++);
    return -1;
  }

  public void b(String paramString)
  {
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
 * Qualified Name:     com.flagleader.builder.widget.a.b
 * JD-Core Version:    0.6.0
 */