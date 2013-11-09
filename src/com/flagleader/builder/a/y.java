package com.flagleader.builder.a;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class y
  implements Listener
{
  y(w paramw, IModifierEditen paramIModifierEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (w.a(this.a).canCopy())
    {
      w.a(this.a).copy();
      return;
    }
    IElement localIElement = this.b.copyElement();
    if ((localIElement != null) && ((localIElement instanceof ConditionToken)))
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localIElement }, new Transfer[] { d.a() });
    else if ((localIElement != null) && ((localIElement instanceof StatementContainerToken)))
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localIElement }, new Transfer[] { d.a() });
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.y
 * JD-Core Version:    0.6.0
 */