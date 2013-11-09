package com.flagleader.repository.f;

import java.util.ArrayList;
import java.util.List;

public class o
  implements b, d
{
  private String g;
  private String h;
  private int i = 0;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  private List j = null;

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public o()
  {
  }

  public String a()
  {
    return this.g;
  }

  public String c()
  {
    return this.h;
  }

  public void b(String paramString)
  {
    this.h = paramString;
  }

  public int d()
  {
    return this.i;
  }

  public void a(int paramInt)
  {
    this.i = paramInt;
  }

  public boolean e()
  {
    return (this.i == 0) || ((this.i & 0x2) > 0) || ((this.i & 0x4) > 0);
  }

  public boolean f()
  {
    return (this.i == 0) || ((this.i & 0x4) > 0);
  }

  public boolean g()
  {
    return (this.i == 0) || ((this.i & 0x8) > 0) || ((this.i & 0x4) > 0);
  }

  public boolean h()
  {
    return (this.i == 0) || ((this.i & 0x10) > 0) || ((this.i & 0x4) > 0);
  }

  public boolean i()
  {
    return (this.i == 0) || ((this.i & 0x20) > 0);
  }

  public List j()
  {
    return this.j;
  }

  public void a(List paramList)
  {
    this.j = paramList;
  }

  public o(String paramString1, String paramString2)
  {
    this.g = paramString1;
    this.h = paramString2;
  }

  public void c(String paramString)
  {
    if (this.j == null)
      this.j = new ArrayList();
    this.j.add(paramString);
  }

  public int b()
  {
    return 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.o
 * JD-Core Version:    0.6.0
 */