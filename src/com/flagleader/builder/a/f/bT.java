package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.tree.RuleSet;
import java.util.Iterator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class bT
  implements Listener
{
  bT(bS parambS, IMultiLineEditen paramIMultiLineEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ElementContainer localElementContainer = new ElementContainer();
    Iterator localIterator = this.b.getMultiLine();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof ILineEditen))
        continue;
      localElementContainer.addChildElement(((ILineEditen)localObject).cutElement());
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
    bQ.c(bS.a(this.a)).setModified(true);
    bS.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bT
 * JD-Core Version:    0.6.0
 */