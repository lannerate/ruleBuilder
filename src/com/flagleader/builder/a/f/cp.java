package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class cp
  implements Listener
{
  cp(cm paramcm, IMultiLineEditen paramIMultiLineEditen, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    this.b.paste(((IElement)this.c).deepClone());
    cm.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cp
 * JD-Core Version:    0.6.0
 */