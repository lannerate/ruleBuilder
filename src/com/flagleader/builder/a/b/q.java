package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.a.c;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.SubFunction;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class q
  implements Listener
{
  q(e parame, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    c localc = new c(e.e(this.a).getShell(), this.b);
    if (localc.open() == 0)
    {
      SubFunction localSubFunction = new SubFunction("add(" + localc.a() + "," + localc.c() + ")", "boolean", "", ".add(" + localc.a() + "," + this.a.I().g(this.a.I().a(localc.c())) + "{" + "arg" + (this.b.getParams().size() + 1) + "}" + this.a.I().h(this.a.I().a(localc.c())) + ")", this.b.getDisplayName() + "." + localc.b() + "{" + "arg" + (this.b.getParams().size() + 1) + "}", e.a(this.a, this.b.getParams(), localc.c()));
      localSubFunction.setVisible(true);
      this.b.addChildElement(localSubFunction);
      this.a.K().setModified(true);
      this.b.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.q
 * JD-Core Version:    0.6.0
 */