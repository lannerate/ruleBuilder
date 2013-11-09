package com.flagleader.builder.a;

import com.flagleader.repository.rlm.editen.ITextEditen;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class v
  implements Listener
{
  v(o paramo, ITextEditen paramITextEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(TextTransfer.getInstance());
    if ((localObject != null) && (this.b.checkValue(localObject.toString())))
    {
      this.b.setText(localObject.toString());
      this.b.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.v
 * JD-Core Version:    0.6.0
 */