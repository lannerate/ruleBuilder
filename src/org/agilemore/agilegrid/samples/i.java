package org.agilemore.agilegrid.samples;

import java.util.ArrayList;
import java.util.List;

public class i
{
  List a = new ArrayList(5);

  public i()
  {
  }

  public i(i parami)
  {
    j localj = null;
    for (int i = 0; i < parami.a(); i++)
    {
      localj = parami.a(i);
      this.a.add(new j(localj));
    }
  }

  public void a(j paramj)
  {
    this.a.add(paramj);
  }

  public void b(j paramj)
  {
    this.a.remove(paramj);
  }

  public j a(int paramInt)
  {
    return (j)this.a.get(paramInt);
  }

  public int a()
  {
    return this.a.size();
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    j localj = null;
    int i = 1;
    for (int j = 0; j < this.a.size(); j++)
    {
      localj = (j)this.a.get(j);
      if (!localj.b().booleanValue())
        continue;
      if (i != 0)
      {
        localStringBuffer.append(localj.a());
        i = 0;
      }
      else
      {
        localStringBuffer.append(", ");
        localStringBuffer.append(localj.a());
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.i
 * JD-Core Version:    0.6.0
 */