package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.a.a;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.SubVariable;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class r
  implements Listener
{
  r(e parame, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    a locala = new a(e.e(this.a).getShell(), this.b);
    if (locala.open() == 0)
    {
      SubVariable localSubVariable = new SubVariable("[" + locala.a() + "]", this.b.getJavaType().J().K(), "[" + locala.a() + "]", this.b.getDisplayName() + "." + locala.b(), this.b.getParams());
      localSubVariable.setVisible(true);
      this.b.addChildElement(localSubVariable);
      this.a.K().setModified(true);
      this.b.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.r
 * JD-Core Version:    0.6.0
 */