package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import java.util.Iterator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class r
  implements Listener
{
  r(q paramq, Object paramObject)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b instanceof IConditionToken))
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { ((IConditionToken)this.b).getComparedValue().deepClone() }, new Transfer[] { d.a() });
      ((IConditionToken)this.b).getComparedValue().dispose();
    }
    else if ((this.b instanceof DecisionElementValue))
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { ((DecisionElementValue)this.b).getAssignValue().deepClone() }, new Transfer[] { d.a() });
      ((DecisionElementValue)this.b).dispose();
    }
    else if ((this.b instanceof DecisionRelateAction))
    {
      ElementContainer localElementContainer = new ElementContainer();
      Iterator localIterator = ((DecisionRelateAction)this.b).getThenActions().getMultiLine();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof ILineEditen))
          continue;
        localElementContainer.addChildElement(((ILineEditen)localObject).cutElement());
      }
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
    }
    o.a(q.a(this.a)).setModified(true);
    q.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.r
 * JD-Core Version:    0.6.0
 */