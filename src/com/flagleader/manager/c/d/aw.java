package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aw
  implements e
{
  private List b = null;

  public int a()
  {
    for (int i = 0; i < this.b.size(); i++)
      if ((this.a.h().getWhileSheet() != null) && (((IWhileObject)this.b.get(i)).equals(this.a.h().getWhileSheet())))
        return i;
    return -1;
  }

  public String[] b()
  {
    String[] arrayOfString = new String[this.b.size()];
    for (int i = 0; i < this.b.size(); i++)
      arrayOfString[i] = ((IWhileObject)this.b.get(i)).getUniqueName();
    return arrayOfString;
  }

  public boolean a(int paramInt)
  {
    if ((this.b != null) && (this.b.get(paramInt) != null) && ((this.b.get(paramInt) instanceof IWhileObject)))
    {
      this.a.h().setSheetTable((IWhileObject)this.b.get(paramInt));
      this.a.h().updateViewer();
      this.a.h().setModified(true);
      return true;
    }
    return false;
  }

  public aw(ao paramao)
  {
    if (this.b == null)
      this.b = new ArrayList();
    else
      this.b.clear();
    Iterator localIterator = paramao.h().getEnvionment().getAcceptElements(new ax(this));
    while (localIterator.hasNext())
      this.b.add(localIterator.next());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aw
 * JD-Core Version:    0.6.0
 */