package com.flagleader.repository.db.a;

import java.util.ArrayList;
import java.util.List;

public class d
{
  private f a = null;
  private int b = 0;
  private f c = null;
  private List d = new ArrayList();
  private List e = new ArrayList();
  private f f = null;

  public d(f paramf1, f paramf2, f paramf3)
  {
    this.a = paramf1;
    this.c = paramf2;
    this.f = paramf3;
  }

  public f a()
  {
    return this.a;
  }

  public void a(f paramf)
  {
    this.a = paramf;
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

  public f d()
  {
    return this.c;
  }

  public void b(f paramf)
  {
    this.c = paramf;
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
 * Qualified Name:     com.flagleader.repository.db.a.d
 * JD-Core Version:    0.6.0
 */