package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.BuilderManager;
import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class o
  implements Runnable
{
  o(l paraml, String paramString)
  {
  }

  public void run()
  {
    this.a.a.getShell().setCursor(this.a.a.getShell().getDisplay().getSystemCursor(3));
    l.a(this.a).removeAll();
    Iterator localIterator = l.c(this.a);
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.startsWith(this.b))
        continue;
      TableItem localTableItem = new TableItem(l.a(this.a), 0);
      localTableItem.setText(str);
    }
    this.a.a.getShell().setCursor(null);
    Display.getCurrent().timerExec(-1, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.o
 * JD-Core Version:    0.6.0
 */