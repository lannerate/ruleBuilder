package com.flagleader.repository.f;

import java.util.ArrayList;
import java.util.List;

public class i
  implements b, d
{
  private String g;
  private int h;
  private int i = 0;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  private List j = null;

  public int b()
  {
    return this.h;
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public i()
  {
  }

  public String a()
  {
    return this.g;
  }

  public int c()
  {
    return this.i;
  }

  public void b(int paramInt)
  {
    this.i = paramInt;
  }

  public boolean d()
  {
    return (this.i == 0) || ((this.i & 0x2) > 0) || ((this.i & 0x4) > 0);
  }

  public boolean e()
  {
    return (this.i == 0) || ((this.i & 0x4) > 0);
  }

  public boolean f()
  {
    return (this.i == 0) || ((this.i & 0x8) > 0) || ((this.i & 0x4) > 0);
  }

  public boolean g()
  {
    return (this.i == 0) || ((this.i & 0x10) > 0) || ((this.i & 0x4) > 0);
  }

  public boolean h()
  {
    return (this.i == 0) || ((this.i & 0x20) > 0);
  }

  public List i()
  {
    return this.j;
  }

  public void a(List paramList)
  {
    this.j = paramList;
  }

  public i(String paramString)
  {
    this.g = paramString;
  }

  public void b(String paramString)
  {
    if (this.j == null)
      this.j = new ArrayList();
    for (int k = 0; k < this.j.size(); k++)
      if (paramString.equalsIgnoreCase(String.valueOf(this.j.get(k))))
        return;
    this.j.add(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.i
 * JD-Core Version:    0.6.0
 */