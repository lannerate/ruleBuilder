package com.flagleader.builder.a;

import com.flagleader.repository.rlm.editen.ITextEditen;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class t
  implements Listener
{
  t(o paramo, ITextEditen paramITextEditen, String paramString)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    this.b.setText("");
    new Clipboard(Display.getCurrent()).setContents(new Object[] { this.c }, new Transfer[] { TextTransfer.getInstance() });
    this.b.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.t
 * JD-Core Version:    0.6.0
 */