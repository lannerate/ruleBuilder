package com.flagleader.builder.a.b;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class g
  implements Listener
{
  g(e parame, IVariableObject paramIVariableObject, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (this.b.isLoged())
      this.b.setLoged(false);
    else
      this.b.setLoged(true);
    this.a.K().setModified(true);
    this.c.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.g
 * JD-Core Version:    0.6.0
 */