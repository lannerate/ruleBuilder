package com.flagleader.a.b;

import com.flagleader.a.P;
import com.flagleader.util.collection.IIterator;
import java.util.Hashtable;
import java.util.Vector;

final class v
  implements IIterator
{
  private Hashtable a = new Hashtable();
  private IIterator b;
  private P c = null;

  final void a()
  {
    while ((this.c == null) && (this.b.hasNext()))
    {
      P localP1 = (P)this.b.next();
      Object localObject = this.a.get(localP1.L());
      if (localObject == null)
      {
        this.a.put(localP1.L(), localP1);
        this.c = localP1;
      }
      else
      {
        Vector localVector;
        if ((localObject instanceof P))
        {
          if (h.a(localP1.g(), ((P)localObject).g()))
            continue;
          localVector = new Vector();
          localVector.addElement(localObject);
          localVector.addElement(localP1);
          this.a.put(localP1.L(), localVector);
          this.c = localP1;
        }
        else
        {
          localVector = (Vector)localObject;
          int i = localVector.size();
          int j = 0;
          for (int k = 0; k < i; k++)
          {
            P localP2 = (P)localVector.elementAt(k);
            if (!h.a(localP1.g(), localP2.g()))
              continue;
            j = 1;
            break;
          }
          if (j != 0)
            continue;
          localVector.addElement(localP1);
          this.c = localP1;
        }
      }
    }
  }

  public boolean hasNext()
  {
    a();
    return this.c != null;
  }

  public Object next()
  {
    a();
    P localP = this.c;
    this.c = null;
    return localP;
  }

  public v(IIterator paramIIterator)
  {
    this.b = paramIIterator;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.v
 * JD-Core Version:    0.6.0
 */