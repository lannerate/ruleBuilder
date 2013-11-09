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

class x
  implements Listener
{
  x(w paramw, IModifierEditen paramIModifierEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (w.a(this.a).canCut())
    {
      w.a(this.a).cut();
      return;
    }
    IElement localIElement = this.b.cutElement();
    if ((localIElement != null) && ((localIElement instanceof ConditionToken)))
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localIElement }, new Transfer[] { d.a() });
    else if ((localIElement != null) && ((localIElement instanceof StatementContainerToken)))
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localIElement }, new Transfer[] { d.a() });
    w.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.x
 * JD-Core Version:    0.6.0
 */