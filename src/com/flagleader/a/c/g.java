package com.flagleader.a.c;

import com.flagleader.a.ae;
import com.flagleader.util.collection.IStringIterator;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class g
  implements ae, Serializable, Cloneable
{
  private transient Hashtable a = null;

  public static Hashtable a(g paramg)
  {
    return paramg.a;
  }

  public Object a(String paramString)
  {
    if (this.a != null)
    {
      Object localObject = this.a.get(paramString);
      if ((localObject instanceof i))
        return ((i)localObject).a;
      return localObject;
    }
    return null;
  }

  public boolean b(String paramString)
  {
    if (this.a != null)
      return this.a.get(paramString) instanceof i;
    return false;
  }

  public IStringIterator a()
  {
    return new h(this);
  }

  private void a(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    for (String str = (String)paramObjectInputStream.readObject(); str != null; str = (String)paramObjectInputStream.readObject())
    {
      boolean bool = paramObjectInputStream.readBoolean();
      Object localObject = paramObjectInputStream.readObject();
      if (bool)
      {
        if ((localObject instanceof String))
          a(str, (String)localObject);
        else
          a(str, (Cloneable)localObject);
      }
      else
        a(str, localObject);
    }
  }

  public Object clone()
  {
    g localg = (g)super.clone();
    localg.a = ((Hashtable)this.a.clone());
    return localg;
  }

  public void c(String paramString)
  {
    if (this.a != null)
      this.a.remove(paramString);
  }

  public void a(String paramString, ae paramae)
  {
    a(paramString, new i(paramae));
  }

  public void a(String paramString1, String paramString2)
  {
    a(paramString1, new i(paramString2));
  }

  public void a(String paramString, Object paramObject)
  {
    if (this.a == null)
      this.a = new Hashtable();
    this.a.put(paramString, paramObject);
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    if (this.a != null)
    {
      Enumeration localEnumeration = this.a.keys();
      while (localEnumeration.hasMoreElements())
      {
        String str = (String)localEnumeration.nextElement();
        Object localObject = a(str);
        if ((!(localObject instanceof Serializable)) && (localObject != null))
          continue;
        paramObjectOutputStream.writeObject(str);
        paramObjectOutputStream.writeBoolean(b(str));
        paramObjectOutputStream.writeObject(localObject);
      }
    }
    paramObjectOutputStream.writeObject(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.g
 * JD-Core Version:    0.6.0
 */