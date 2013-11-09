package com.flagleader.manager.dialog.d;

import com.flagleader.manager.dialog.a;
import com.flagleader.repository.tree.IOpenNode;
import java.util.List;

public class b extends a
{
  protected IOpenNode b = null;

  public b(IOpenNode paramIOpenNode)
  {
    this.b = paramIOpenNode;
  }

  public void a()
  {
    List localList = ((c)b()).c();
    for (int i = 0; i < localList.size(); i++)
      try
      {
        if (((c)b()).a())
          this.b.clearBackup((List)localList.get(i));
        else
          this.b.backup((List)localList.get(i));
      }
      catch (Exception localException)
      {
      }
  }

  public void c()
  {
    List localList1 = ((c)b()).b();
    for (int i = 0; i < localList1.size(); i++)
      this.b.recoverAutoSavePack((List)localList1.get(i));
    List localList2 = ((c)b()).c();
    for (int j = 0; j < localList2.size(); j++)
      try
      {
        if (((c)b()).a())
          this.b.clearBackup((List)localList2.get(j));
        else
          this.b.backup((List)localList2.get(j));
      }
      catch (Exception localException)
      {
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.d.b
 * JD-Core Version:    0.6.0
 */