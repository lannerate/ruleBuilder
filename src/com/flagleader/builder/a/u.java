package com.flagleader.builder.a;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class u
  implements Listener
{
  u(o paramo, String paramString)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    new Clipboard(Display.getCurrent()).setContents(new Object[] { this.b }, new Transfer[] { TextTransfer.getInstance() });
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.u
 * JD-Core Version:    0.6.0
 */