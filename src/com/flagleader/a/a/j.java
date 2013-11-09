package com.flagleader.a.a;

import java.io.Serializable;
import java.util.Vector;

public final class j
  implements h, Serializable
{
  private Vector a;

  public void a(int paramInt, Object paramObject)
  {
    this.a.insertElementAt(paramObject, paramInt);
  }

  public void a()
  {
    this.a.removeAllElements();
  }

  public Object a(int paramInt)
  {
    return this.a.elementAt(paramInt);
  }

  public void b(int paramInt)
  {
    this.a.removeElementAt(paramInt);
  }

  public void b(int paramInt, Object paramObject)
  {
    this.a.setElementAt(paramObject, paramInt);
  }

  public int b()
  {
    return this.a.size();
  }

  public void c()
  {
    this.a.trimToSize();
  }

  public j()
  {
    this.a = new Vector();
  }

  public j(Vector paramVector)
  {
    this.a = paramVector;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.j
 * JD-Core Version:    0.6.0
 */