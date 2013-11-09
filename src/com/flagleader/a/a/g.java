package com.flagleader.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class g
  implements h, Serializable
{
  private transient Object[] a;
  private transient int b;

  public void a(int paramInt, Object paramObject)
  {
    c(this.b + 1);
    System.arraycopy(this.a, paramInt, this.a, paramInt + 1, this.b - paramInt);
    this.a[paramInt] = paramObject;
    this.b += 1;
  }

  public void a()
  {
    this.b = 0;
  }

  private void c(int paramInt)
  {
    int i = this.a == null ? 0 : this.a.length;
    if (paramInt > i)
    {
      Object[] arrayOfObject = this.a;
      this.a = new Object[paramInt];
      if (arrayOfObject != null)
        System.arraycopy(arrayOfObject, 0, this.a, 0, this.b);
    }
  }

  public Object a(int paramInt)
  {
    return this.a[paramInt];
  }

  private void a(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.b = paramObjectInputStream.readInt();
    this.a = (this.b <= 0 ? null : new Object[this.b]);
    for (int i = 0; i < this.b; i++)
      this.a[i] = paramObjectInputStream.readObject();
  }

  public void b(int paramInt)
  {
    int i = this.b - paramInt - 1;
    if (i > 0)
      System.arraycopy(this.a, paramInt + 1, this.a, paramInt, i);
    this.b -= 1;
    this.a[this.b] = null;
  }

  public void b(int paramInt, Object paramObject)
  {
    this.a[paramInt] = paramObject;
  }

  public int b()
  {
    return this.b;
  }

  public void c()
  {
    if ((this.a != null) && (this.a.length > this.b))
      if (this.b > 0)
      {
        int i = this.b;
        Object[] arrayOfObject = this.a;
        this.a = new Object[i];
        if (arrayOfObject != null)
          System.arraycopy(arrayOfObject, 0, this.a, 0, this.b);
      }
      else
      {
        this.a = null;
      }
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(this.b);
    for (int i = 0; i < this.b; i++)
      paramObjectOutputStream.writeObject(this.a[i]);
  }

  public g()
  {
    this.a = null;
    this.b = 0;
  }

  public g(int paramInt)
  {
    this.a = (paramInt <= 0 ? null : new Object[paramInt]);
    this.b = 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.g
 * JD-Core Version:    0.6.0
 */