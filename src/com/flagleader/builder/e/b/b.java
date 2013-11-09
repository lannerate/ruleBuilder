package com.flagleader.builder.e.b;

import java.util.ArrayList;
import java.util.List;

public class b
{
  private h a = null;
  private int b = 0;
  private h c = null;
  private List d = new ArrayList();
  private List e = new ArrayList();

  public b(h paramh1, h paramh2)
  {
    this.a = paramh1;
    this.c = paramh2;
  }

  public h a()
  {
    return this.a;
  }

  public void a(h paramh)
  {
    this.a = paramh;
  }

  public String b()
  {
    String str = "";
    if ((this.a != null) && (this.c != null) && (this.d.size() > 0) && (this.e.size() > 0))
    {
      if ((c() == 4) || (c() == 2))
        str = str + "\n left join ";
      else
        str = str + "\n inner join ";
      str = str + this.a.f() + " on ";
      str = str + this.a.g() + "." + this.d.get(0) + " = ";
      str = str + this.c.g() + "." + this.e.get(0);
      for (int i = 1; i < this.d.size(); i++)
      {
        str = str + " and ";
        str = str + this.a.g() + "." + this.d.get(i) + " = ";
        str = str + this.c.g() + "." + this.e.get(i);
      }
    }
    return str;
  }

  public int c()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public h d()
  {
    return this.c;
  }

  public void b(h paramh)
  {
    this.c = paramh;
  }

  public List e()
  {
    return this.e;
  }

  public List f()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.b.b
 * JD-Core Version:    0.6.0
 */