package com.flagleader.builder.widget.a;

import java.util.Hashtable;

public class E
{
  protected Hashtable a = null;
  protected Hashtable b = null;
  protected StringBuffer c = new StringBuffer();
  protected String d;
  protected int e;
  protected int f;
  protected int g;
  protected boolean h = false;
  protected String i = "";
  private String[] k = { "function", "var", "break", "document", "write", "FrPost", "delete", "typeof", "continue", "void", "do", "instanceof", "else", "new", "alert", "getElementById", "prompt", "confirm", "false", "in", "switch", "eval", "for", "if", "return", "while", "case", "catch", "this", "throw", "debugger", "finally", "null", "toString", "valueOf", "exec", "concat", "length", "true", "with", "default", "value", "history", "substr", "split", "isNaN", "indexOf" };
  private String[] l = { "+", "-", "*", "/", "%", "=", "!", "<", ">", "&", "|", "^", "?", ":", ";", ",", "~", "[", "]", "(", ")", ".", "{", "}" };

  public boolean a(char paramChar)
  {
    return this.b.containsKey(String.valueOf(paramChar));
  }

  public E(D paramD)
  {
    b();
  }

  public final int a()
  {
    return this.e - this.g;
  }

  void b()
  {
    this.a = new Hashtable();
    Integer localInteger = new Integer(2);
    for (int m = 0; m < this.k.length; m++)
      this.a.put(this.k[m], localInteger);
    this.b = new Hashtable();
    for (m = 0; m < this.l.length; m++)
      this.b.put(this.l[m], this.l[m]);
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

  public final int c()
  {
    return this.g;
  }

  public int d()
  {
    this.g = this.e;
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
    int n = (char)m;
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
      this.c.setLength(0);
      do
      {
        this.c.append((char)m);
        m = e();
      }
      while (Character.isJavaIdentifierPart((char)m));
      a(m);
      if (b(this.c.toString()))
        return 10;
      Integer localInteger = (Integer)this.a.get(this.c.toString());
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
    if (this.e <= this.f)
      return this.d.charAt(this.e++);
    return -1;
  }

  public void c(String paramString)
  {
    this.d = paramString;
    this.e = 0;
    this.f = (this.d.length() - 1);
  }

  protected void a(int paramInt)
  {
    if (paramInt != -1)
      this.e -= 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.E
 * JD-Core Version:    0.6.0
 */