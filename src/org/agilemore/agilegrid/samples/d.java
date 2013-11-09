package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.aa;

class d extends aa
{
  d(a parama)
  {
  }

  public Object a(int paramInt1, int paramInt2)
  {
    i locali = (i)this.a.m();
    j localj = locali.a(paramInt1);
    switch (paramInt2)
    {
    case 0:
      return localj.b();
    case 1:
      return localj.a();
    case 2:
      return localj.c();
    }
    return super.a(paramInt1, paramInt2);
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    i locali = (i)this.a.m();
    j localj = locali.a(paramInt1);
    switch (paramInt2)
    {
    case 0:
      localj.a((Boolean)paramObject);
      break;
    case 1:
      localj.a(paramObject.toString());
      break;
    case 2:
      localj.b(paramObject.toString());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.d
 * JD-Core Version:    0.6.0
 */