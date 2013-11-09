package com.flagleader.repository;

import com.flagleader.util.TempID;
import java.util.ArrayList;

public class l
{
  private String a = null;
  private String b = null;
  private ArrayList c = null;
  private k d = null;
  private IElement e = null;

  public l(String paramString, k paramk, IElement paramIElement)
  {
    this.b = paramString;
    this.d = paramk;
    this.e = paramIElement;
  }

  public k a()
  {
    return this.d;
  }

  public String b()
  {
    return this.b;
  }

  public void a(k paramk)
  {
    this.d = paramk;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(l paraml)
  {
    if (this.c == null)
      this.c = new ArrayList();
    this.c.add(paraml);
  }

  public boolean c()
  {
    return (this.c != null) && (this.c.size() > 0);
  }

  public l[] d()
  {
    if ((this.c == null) || (this.c.size() == 0))
      return new l[0];
    l[] arrayOfl = new l[this.c.size()];
    for (int i = 0; i < this.c.size(); i++)
      arrayOfl[i] = ((l)this.c.get(i));
    return arrayOfl;
  }

  public IElement e()
  {
    return this.e;
  }

  public void a(IElement paramIElement)
  {
    this.e = paramIElement;
  }

  public String f()
  {
    if (this.a == null)
      this.a = ("T" + TempID.newShortTempID());
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.l
 * JD-Core Version:    0.6.0
 */