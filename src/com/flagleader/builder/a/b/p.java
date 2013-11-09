package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.a.c;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.SubFunction;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class p
  implements Listener
{
  p(e parame, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    c localc = new c(e.e(this.a).getShell(), this.b);
    if (localc.open() == 0)
    {
      SubFunction localSubFunction = new SubFunction("get(" + localc.a() + ")", localc.c(), this.a.I().e(this.a.I().a(localc.c())), ".get(" + localc.a() + ")" + this.a.I().f(this.a.I().a(localc.c())), this.b.getDisplayName() + "." + localc.b(), this.b.getParams());
      localSubFunction.setVisible(true);
      this.b.addChildElement(localSubFunction);
      this.a.K().setModified(true);
      this.b.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.p
 * JD-Core Version:    0.6.0
 */