package com.flagleader.builder.widget.editor.c;

import com.flagleader.a.B;
import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.T;
import com.flagleader.a.ak;
import com.flagleader.a.b.g;
import com.flagleader.a.c.n;
import com.flagleader.a.y;
import com.flagleader.util.collection.IIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a
{
  private static a c = new a();
  public g a = new g();
  public com.flagleader.repository.d.a b = new com.flagleader.repository.d.a();
  private HashMap d = new HashMap();

  public static a a()
  {
    return c;
  }

  public String a(String paramString1, String paramString2)
  {
    Class localClass = this.b.loadClass(paramString1);
    if (paramString2.indexOf("(") > 0)
      paramString2 = paramString2.substring(0, paramString2.indexOf("("));
    if (localClass == null)
      throw new ClassNotFoundException();
    this.a.a(localClass);
    B localB = this.a.d(localClass.getName());
    T localT = n.b(localB.E(), new b(this));
    while (localT.hasNext())
    {
      M localM = (M)localT.next();
      if (!localM.N().equals(paramString2))
        continue;
      if ((localM instanceof P))
        return ((P)localM).n().K();
      if ((localM instanceof y))
        return ((y)localM).e().K();
    }
    return "";
  }

  public List a(String paramString)
  {
    Object localObject = (List)this.d.get(paramString);
    if (localObject != null)
      return localObject;
    Class localClass = this.b.loadClass(paramString);
    if (localClass == null)
      throw new ClassNotFoundException();
    this.a.a(localClass);
    B localB = this.a.d(localClass.getName());
    T localT = n.b(localB.E(), new b(this));
    localObject = new ArrayList();
    while (localT.hasNext())
    {
      M localM = (M)localT.next();
      ((List)localObject).add(localM.G());
    }
    this.d.put(paramString, localObject);
    return (List)localObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.c.a
 * JD-Core Version:    0.6.0
 */