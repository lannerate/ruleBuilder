package org.agilemore.agilegrid;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public abstract class d
  implements au
{
  protected e b;
  aq c;
  protected PropertyChangeSupport d;

  public d(e parame)
  {
    this.b = parame;
    this.d = new PropertyChangeSupport(this);
  }

  public abstract int f(int paramInt);

  public abstract int b(int paramInt);

  public abstract int e(int paramInt);

  public abstract int c(int paramInt);

  public void b(int paramInt1, int paramInt2)
  {
    int i = f(paramInt1);
    if (paramInt2 == i)
      return;
    c(paramInt1, paramInt2);
    b("columnWidth", paramInt1, i, paramInt2);
  }

  protected abstract void c(int paramInt1, int paramInt2);

  public void d(int paramInt1, int paramInt2)
  {
    int i = e(paramInt1);
    if (paramInt2 == i)
      return;
    e(paramInt1, paramInt2);
    b("rowHeight", paramInt1, i, paramInt2);
  }

  protected abstract void e(int paramInt1, int paramInt2);

  public boolean f(int paramInt1, int paramInt2)
  {
    return (paramInt2 < h()) || (paramInt1 < i());
  }

  public G a(int paramInt1, int paramInt2)
  {
    return new G(this.b, paramInt1, paramInt2);
  }

  public aq f()
  {
    return this.c;
  }

  public void a(aq paramaq)
  {
    this.c = paramaq;
  }

  public void g(int paramInt)
  {
    int i = b();
    if (paramInt == i)
      return;
    h(paramInt);
    a("columnCount", i, paramInt);
  }

  protected abstract void h(int paramInt);

  public void i(int paramInt)
  {
    int i = h();
    if (paramInt == i)
      return;
    j(paramInt);
    a("fixedColumnCount", i, paramInt);
  }

  protected abstract void j(int paramInt);

  public void k(int paramInt)
  {
    int i = i();
    if (paramInt == i)
      return;
    l(paramInt);
    a("fixedRowCount", i, paramInt);
  }

  protected abstract void l(int paramInt);

  public void a(int paramInt, String paramString)
  {
    String str = d(paramInt);
    if ((str != paramString) || ((str != null) && (!str.equals(paramString))))
    {
      b(paramInt, paramString);
      b("leftHeaderLabel", paramInt, str, paramString);
    }
  }

  protected abstract void b(int paramInt, String paramString);

  public void a(boolean paramBoolean)
  {
    boolean bool = j();
    if (paramBoolean == bool)
      return;
    b(paramBoolean);
    a("leftHeaderVisible", bool, paramBoolean);
  }

  protected abstract void b(boolean paramBoolean);

  public void m(int paramInt)
  {
    int i = c();
    if (paramInt == i)
      return;
    n(paramInt);
    a("leftHeaderWidth", i, paramInt);
  }

  protected abstract void n(int paramInt);

  public void o(int paramInt)
  {
    int i = a();
    if (paramInt == i)
      return;
    p(paramInt);
    a("rowCount", i, paramInt);
  }

  protected abstract void p(int paramInt);

  public void q(int paramInt)
  {
    int i = d();
    if (paramInt == i)
      return;
    r(paramInt);
    a("rowHeightMinimum", i, paramInt);
  }

  protected abstract void r(int paramInt);

  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = v(paramInt);
    if (paramBoolean == bool)
      return;
    b(paramInt, paramBoolean);
    b("rowResizable", paramInt, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean));
  }

  protected abstract void b(int paramInt, boolean paramBoolean);

  public void a(int paramInt1, int paramInt2, String paramString)
  {
    String str = g(paramInt1, paramInt2);
    if ((paramString != str) || ((str != null) && (!str.equals(paramString))))
    {
      b(paramInt1, paramInt2, paramString);
      a("tooltip", paramInt1, paramInt2, str, paramString);
    }
  }

  protected abstract void b(int paramInt1, int paramInt2, String paramString);

  public void s(int paramInt)
  {
    int i = e();
    if (paramInt == i)
      return;
    t(paramInt);
    a("topHeaderHeight", i, paramInt);
  }

  protected abstract void t(int paramInt);

  public void c(int paramInt, String paramString)
  {
    String str = a(paramInt);
    if ((str != paramString) || ((str != null) && (!str.equals(paramString))))
    {
      d(paramInt, paramString);
      b("topHeaderLabel", paramInt, str, paramString);
    }
  }

  protected abstract void d(int paramInt, String paramString);

  public void c(boolean paramBoolean)
  {
    boolean bool = k();
    if (bool == paramBoolean)
      return;
    d(paramBoolean);
    a("topHeaderVisible", bool, paramBoolean);
  }

  protected abstract void d(boolean paramBoolean);

  public void a(PropertyChangeListener paramPropertyChangeListener)
  {
    this.d.addPropertyChangeListener(paramPropertyChangeListener);
  }

  public void a(String paramString, PropertyChangeListener paramPropertyChangeListener)
  {
    this.d.addPropertyChangeListener(paramString, paramPropertyChangeListener);
  }

  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d.fireIndexedPropertyChange(paramString, paramInt, paramBoolean1, paramBoolean2);
  }

  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.fireIndexedPropertyChange(paramString, paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt, Object paramObject1, Object paramObject2)
  {
    this.d.fireIndexedPropertyChange(paramString, paramInt, paramObject1, paramObject2);
  }

  public void a(PropertyChangeEvent paramPropertyChangeEvent)
  {
    this.d.firePropertyChange(paramPropertyChangeEvent);
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d.firePropertyChange(paramString, paramBoolean1, paramBoolean2);
  }

  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.d.firePropertyChange(paramString, paramInt1, paramInt2);
  }

  public void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt3)
      return;
    b(paramString, paramInt1, new Integer(paramInt2), new Integer(paramInt3));
  }

  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 == paramInt4)
      return;
    a(paramString, paramInt1, paramInt2, new Integer(paramInt3), new Integer(paramInt4));
  }

  public void a(String paramString, Object paramObject1, Object paramObject2)
  {
    this.d.firePropertyChange(paramString, paramObject1, paramObject2);
  }

  public void b(String paramString, int paramInt, Object paramObject1, Object paramObject2)
  {
    Integer localInteger = new Integer(paramInt);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(localInteger, paramObject1);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(localInteger, paramObject2);
    this.d.firePropertyChange(paramString, localHashMap1, localHashMap2);
  }

  public void a(String paramString, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2)
  {
    G localG = new G(this.b, paramInt1, paramInt2);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(localG, paramObject1);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(localG, paramObject2);
    this.d.firePropertyChange(paramString, localHashMap1, localHashMap2);
  }

  public PropertyChangeListener[] g()
  {
    return this.d.getPropertyChangeListeners();
  }

  public PropertyChangeListener[] a(String paramString)
  {
    return this.d.getPropertyChangeListeners(paramString);
  }

  public boolean b(String paramString)
  {
    return this.d.hasListeners(paramString);
  }

  public void b(PropertyChangeListener paramPropertyChangeListener)
  {
    this.d.removePropertyChangeListener(paramPropertyChangeListener);
  }

  public void b(String paramString, PropertyChangeListener paramPropertyChangeListener)
  {
    this.d.removePropertyChangeListener(paramString, paramPropertyChangeListener);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.d
 * JD-Core Version:    0.6.0
 */