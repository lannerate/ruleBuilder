package com.flagleader.manager.dialog.d;

import com.flagleader.manager.dialog.b;
import com.flagleader.manager.dialog.d;
import java.util.ArrayList;
import java.util.List;

public class a extends b
{
  private List b = null;
  private List c = null;

  public a(d paramd, List paramList)
  {
    super(paramd);
    this.b = paramList;
  }

  public List a()
  {
    return this.c;
  }

  public List b()
  {
    ArrayList localArrayList = new ArrayList(this.b.size() - this.c.size());
    localArrayList.addAll(this.b);
    localArrayList.removeAll(this.c);
    return localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.d.a
 * JD-Core Version:    0.6.0
 */