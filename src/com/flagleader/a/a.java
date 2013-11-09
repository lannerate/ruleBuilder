package com.flagleader.a;

import com.flagleader.a.c.g;
import com.flagleader.util.collection.DynamicStringIterator;
import com.flagleader.util.collection.IStringIterator;
import com.flagleader.util.exception.UnsupportOperationException;

public abstract class a
  implements ae
{
  private ae a = null;

  public Object a(String paramString)
  {
    if (this.a != null)
      return this.a.a(paramString);
    return null;
  }

  public boolean b(String paramString)
  {
    if (this.a != null)
      return this.a.b(paramString);
    return false;
  }

  public IStringIterator a()
  {
    return this.a == null ? new DynamicStringIterator() : this.a.a();
  }

  public void a(String paramString, ae paramae)
  {
    if (d_())
    {
      if (paramae == null)
        paramae = new g();
      c().a(paramae, paramString, paramae);
    }
    else
    {
      throw new UnsupportOperationException();
    }
  }

  public void a(String paramString1, String paramString2)
  {
    if (d_())
    {
      if (this.a == null)
        this.a = new g();
      this.a.a(paramString1, paramString2);
    }
    else
    {
      throw new UnsupportOperationException();
    }
  }

  public void a(String paramString, Object paramObject)
  {
    if (this.a == null)
      this.a = new g();
    this.a.a(paramString, paramObject);
  }

  public boolean d_()
  {
    return false;
  }

  public void c(String paramString)
  {
    if (this.a != null)
      this.a.c(paramString);
  }

  public abstract aj c();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a
 * JD-Core Version:    0.6.0
 */