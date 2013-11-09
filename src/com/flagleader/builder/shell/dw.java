package com.flagleader.builder.shell;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

class dw
  implements Acceptor
{
  dw(ds paramds)
  {
  }

  public boolean accept(Object paramObject)
  {
    for (int i = 2; i < ds.c(this.a).getColumnCount(); i++)
      if (ds.c(this.a).getColumn(i).getText().equalsIgnoreCase(((IBusinessObject)paramObject).getDisplayName()))
        return true;
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dw
 * JD-Core Version:    0.6.0
 */