package org.agilemore.agilegrid;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public abstract class c
  implements ar
{
  protected PropertyChangeSupport b = new PropertyChangeSupport(this);

  public Object b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }

  public abstract Object a(int paramInt1, int paramInt2);

  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = b(paramInt1, paramInt2);
    if ((localObject != paramObject) || ((localObject != null) && (!localObject.equals(paramObject))))
    {
      a(paramInt1, paramInt2, paramObject);
      a("content", paramInt1, paramInt2, localObject, paramObject);
    }
  }

  public abstract void a(int paramInt1, int paramInt2, Object paramObject);

  public void a(PropertyChangeListener paramPropertyChangeListener)
  {
    this.b.addPropertyChangeListener(paramPropertyChangeListener);
  }

  public void a(String paramString, PropertyChangeListener paramPropertyChangeListener)
  {
    this.b.addPropertyChangeListener(paramString, paramPropertyChangeListener);
  }

  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.fireIndexedPropertyChange(paramString, paramInt, paramBoolean1, paramBoolean2);
  }

  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.fireIndexedPropertyChange(paramString, paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt, Object paramObject1, Object paramObject2)
  {
    this.b.fireIndexedPropertyChange(paramString, paramInt, paramObject1, paramObject2);
  }

  public void a(PropertyChangeEvent paramPropertyChangeEvent)
  {
    this.b.firePropertyChange(paramPropertyChangeEvent);
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.firePropertyChange(paramString, paramBoolean1, paramBoolean2);
  }

  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.b.firePropertyChange(paramString, paramInt1, paramInt2);
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
    this.b.firePropertyChange(paramString, paramObject1, paramObject2);
  }

  public void b(String paramString, int paramInt, Object paramObject1, Object paramObject2)
  {
    Integer localInteger = new Integer(paramInt);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(localInteger, paramObject1);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(localInteger, paramObject2);
    this.b.firePropertyChange(paramString, localHashMap1, localHashMap2);
  }

  public void a(String paramString, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2)
  {
    G localG = new G(null, paramInt1, paramInt2);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(localG, paramObject1);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(localG, paramObject2);
    this.b.firePropertyChange(paramString, localHashMap1, localHashMap2);
  }

  public PropertyChangeListener[] a()
  {
    return this.b.getPropertyChangeListeners();
  }

  public PropertyChangeListener[] a(String paramString)
  {
    return this.b.getPropertyChangeListeners(paramString);
  }

  public boolean b(String paramString)
  {
    return this.b.hasListeners(paramString);
  }

  public void b(PropertyChangeListener paramPropertyChangeListener)
  {
    this.b.removePropertyChangeListener(paramPropertyChangeListener);
  }

  public void b(String paramString, PropertyChangeListener paramPropertyChangeListener)
  {
    this.b.removePropertyChangeListener(paramString, paramPropertyChangeListener);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.c
 * JD-Core Version:    0.6.0
 */