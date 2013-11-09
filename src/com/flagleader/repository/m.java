package com.flagleader.repository;

import com.flagleader.repository.lang.a;
import com.flagleader.repository.lang.b;
import com.flagleader.repository.lang.c;
import com.flagleader.repository.lang.d;
import java.util.List;

public class m
{
  private static m e = new m();
  public final String a = "flagleader";
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private String j = "java";
  public static final int b = 1;
  public static final int c = 2;
  private List k = null;
  private b l = b.a(this.j);
  private h m = n.a();
  public static final char d = '&';

  public static m a()
  {
    return e;
  }

  public int b()
  {
    return this.g;
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public int c()
  {
    return this.h;
  }

  public void b(int paramInt)
  {
    this.h = paramInt;
  }

  public int d()
  {
    return this.f;
  }

  public void c(int paramInt)
  {
    this.f = paramInt;
  }

  public int e()
  {
    return this.i;
  }

  public void d(int paramInt)
  {
    this.i = paramInt;
  }

  public void a(List paramList)
  {
    this.k = paramList;
  }

  public boolean a(String paramString)
  {
    if (this.i == 0)
      return true;
    if (this.k != null)
      for (int n = 0; n < this.k.size(); n++)
        if (((List)this.k.get(n)).get(2).equals(paramString))
          return true;
    return false;
  }

  public void b(String paramString)
  {
    if (this.j.equalsIgnoreCase(paramString))
      return;
    this.j = paramString;
    this.l = b.a(paramString);
  }

  public a f()
  {
    return this.l.c();
  }

  public com.flagleader.repository.lang.h g()
  {
    return this.l.b();
  }

  public d h()
  {
    return this.l.d();
  }

  public c i()
  {
    return this.l.e();
  }

  public h j()
  {
    return this.m;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.m
 * JD-Core Version:    0.6.0
 */