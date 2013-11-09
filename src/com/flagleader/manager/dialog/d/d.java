package com.flagleader.manager.dialog.d;

import com.flagleader.manager.dialog.b;
import java.util.ArrayList;
import java.util.List;

public class d extends b
{
  private List b = new ArrayList();
  private List c = new ArrayList();

  public d(com.flagleader.manager.dialog.d paramd, List paramList)
  {
    super(paramd);
    this.b = paramList;
  }

  public List b()
  {
    return this.c;
  }

  public List c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.b);
    localArrayList.removeAll(this.c);
    return localArrayList;
  }

  public List d()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.d.d
 * JD-Core Version:    0.6.0
 */