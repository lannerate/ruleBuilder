package com.flagleader.builder.e.i;

import java.util.ArrayList;
import java.util.List;

public class b
{
  private j a = null;
  private int b = 0;
  private j c = null;
  private List d = new ArrayList();
  private List e = new ArrayList();
  private j f = null;

  public b(j paramj1, j paramj2, j paramj3)
  {
    this.a = paramj1;
    this.c = paramj2;
    this.f = paramj3;
  }

  public j a()
  {
    return this.a;
  }

  public void a(j paramj)
  {
    this.a = paramj;
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
      if (this.a.equals(this.f))
        str = str + this.c.f() + " on ";
      else
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

  public j d()
  {
    return this.c;
  }

  public void b(j paramj)
  {
    this.c = paramj;
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
 * Qualified Name:     com.flagleader.builder.e.i.b
 * JD-Core Version:    0.6.0
 */