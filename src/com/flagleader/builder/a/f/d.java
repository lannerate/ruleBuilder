package com.flagleader.builder.a.f;

import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.DecisionMultiRule;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class d
  implements Listener
{
  d(b paramb, int paramInt)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.d.a());
    if ((localObject instanceof IVariableObject))
    {
      a.b(b.a(this.a)).setDecisionElement(this.b - a.b(b.a(this.a)).getConditionNum(), (IVariableObject)localObject);
      a.b(b.a(this.a)).updateViewer();
    }
    a.b(b.a(this.a)).setModified(true);
    b.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.d
 * JD-Core Version:    0.6.0
 */