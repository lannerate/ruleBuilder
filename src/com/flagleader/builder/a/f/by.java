package com.flagleader.builder.a.f;

import com.flagleader.builder.dialogs.e.V;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class by
  implements Listener
{
  by(bx parambx)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    V localV = new V(bu.d(bx.a(this.a)), bu.c(bx.a(this.a)).getPoolValues(), bu.c(bx.a(this.a)).getEnvionment());
    if (localV.open() == 0)
    {
      List localList = localV.a();
      for (int i = 0; i < localList.size(); i++)
        bu.c(bx.a(this.a)).addPoolValue((IBusinessObject)localList.get(i));
      bx.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.by
 * JD-Core Version:    0.6.0
 */