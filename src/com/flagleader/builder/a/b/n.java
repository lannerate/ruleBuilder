package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.a.r;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class n
  implements Listener
{
  n(e parame, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    r localr = new r((IFunctionObject)this.b);
    if (localr.open() == 0)
    {
      ((IFunctionObject)this.b).changeParams();
      this.a.K().setModified(true);
      this.b.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.n
 * JD-Core Version:    0.6.0
 */