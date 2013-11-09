package com.flagleader.builder.shell;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class cU
  implements Listener
{
  cU(cT paramcT, TableItem paramTableItem, int paramInt)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    String str = this.b.getText(this.c);
    if (this.b.getData(String.valueOf(this.c)) != null)
      str = (String)this.b.getData(String.valueOf(this.c));
    if (str.length() > 0)
      new Clipboard(RuleExecuteViewer.q(cT.a(this.a)).getDisplay()).setContents(new Object[] { str }, new Transfer[] { TextTransfer.getInstance() });
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cU
 * JD-Core Version:    0.6.0
 */