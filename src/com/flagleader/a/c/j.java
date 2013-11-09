package com.flagleader.a.c;

import com.flagleader.a.E;
import com.flagleader.util.collection.DynamicList;
import com.flagleader.util.collection.IIterator;
import com.flagleader.util.collection.IList;
import java.util.Vector;

public class j
{
  public static IList a(IIterator paramIIterator, E paramE)
  {
    DynamicList localDynamicList = new DynamicList();
    while (paramIIterator.hasNext())
      localDynamicList.add(paramIIterator.next());
    a(localDynamicList, paramE);
    return localDynamicList;
  }

  public static void a(IList paramIList, E paramE)
  {
    int i = paramIList.size();
    int j = i / 2;
    while (j > 0)
    {
      for (int k = j; k < i; k++)
      {
        int m = k - j;
        Object localObject = paramIList.get(k);
        while (m >= 0)
        {
          int n = paramE.a(paramIList.get(m), localObject);
          if (n <= 0)
            break;
          paramIList.set(m + j, paramIList.get(m));
          paramIList.set(m, localObject);
          m -= j;
        }
      }
      j /= 2;
    }
  }

  public static Vector a(IIterator paramIIterator)
  {
    Vector localVector = new Vector();
    if (paramIIterator != null)
      while (paramIIterator.hasNext())
        localVector.addElement(paramIIterator.next());
    return localVector;
  }

  public static Vector a(IList paramIList)
  {
    if (paramIList != null)
    {
      Vector localVector = new Vector(paramIList.size());
      for (int i = 0; i < paramIList.size(); i++)
        localVector.addElement(paramIList.get(i));
      return localVector;
    }
    return new Vector();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.j
 * JD-Core Version:    0.6.0
 */