package com.flagleader.builder.widget.a;

import java.util.Hashtable;

public class av
{
  protected Hashtable a = null;
  protected StringBuffer b = new StringBuffer();
  protected String c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g = false;
  protected Hashtable h = null;
  protected String i = "";
  private String[] k = { "insert", "select", "into", "from", "as", "where", "and", "or", "(", ")", "on", ";", "delete", "update", "max", "count", "concat", "like", "is", "null", "order", "by", "||", "set", "group", "=", "values", "inner", "join", "left", "right", "union" };
  private String[] l = { "+", "-", "*", "/", "%", "=", "!", "<", ">", "&", "|", "^", "?", ":", ";", ",", "~", "[", "]", "(", ")", ".", "{", "}" };

  public boolean a(char paramChar)
  {
    return this.h.containsKey(String.valueOf(paramChar));
  }

  public av(au paramau)
  {
    b();
  }

  public final int a()
  {
    return this.d - this.f;
  }

  public void a(Object paramObject)
  {
    this.a.put(paramObject, new Integer(8));
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public boolean b(String paramString)
  {
    return this.i.equals(paramString);
  }

  void b()
  {
    this.a = new Hashtable();
    Integer localInteger = new Integer(2);
    for (int m = 0; m < this.k.length; m++)
      this.a.put(this.k[m], localInteger);
    this.h = new Hashtable();
    for (m = 0; m < this.l.length; m++)
      this.h.put(this.l[m], this.l[m]);
  }

  public final int c()
  {
    return this.f;
  }

  public int d()
  {
    this.f = this.d;
    int m;
    switch (m = e())
    {
    case -1:
      return -1;
    case 47:
      m = e();
      if (m == 47)
      {
        do
          m = e();
        while ((m != -1) && (m != 11));
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
      if (b(this.b.toString()))
        return 10;
      Integer localInteger = (Integer)this.a.get(this.b.toString());
      if (localInteger != null)
        return localInteger.intValue();
      return 0;
    }
    if (a((char)m))
      return 9;
    return 6;
  }

  protected int e()
  {
    if (this.d <= this.e)
      return this.c.charAt(this.d++);
    return -1;
  }

  public void c(String paramString)
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
 * Qualified Name:     com.flagleader.builder.widget.a.av
 * JD-Core Version:    0.6.0
 */