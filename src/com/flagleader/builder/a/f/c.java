package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.DecisionMultiRule;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class c
  implements Listener
{
  c(b paramb, int paramInt)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(d.a());
    IMultiConditionToken localIMultiConditionToken = a.b(b.a(this.a)).getConditions(this.b);
    List localList = localIMultiConditionToken.getConditionList();
    if (localList.size() == 0)
      localIMultiConditionToken.paste((IElement)localObject);
    else if ((localObject instanceof IBusinessObject))
      for (int i = 0; i < localList.size(); i++)
      {
        IConditionToken localIConditionToken1 = (IConditionToken)localList.get(i);
        IValueToken localIValueToken1 = localIConditionToken1.getFirstValue();
        if ((localIValueToken1 instanceof MemberToken))
          ((MemberToken)localIValueToken1).setMemberElement((IBusinessObject)localObject);
        Iterator localIterator = localIConditionToken1.getNextTests();
        while (localIterator.hasNext())
        {
          IConditionToken localIConditionToken2 = (IConditionToken)localIterator.next();
          IValueToken localIValueToken2 = localIConditionToken2.getFirstValue();
          if (!(localIValueToken2 instanceof MemberToken))
            continue;
          ((MemberToken)localIValueToken2).setMemberElement((IBusinessObject)localObject);
        }
      }
    a.b(b.a(this.a)).setModified(true);
    b.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.c
 * JD-Core Version:    0.6.0
 */