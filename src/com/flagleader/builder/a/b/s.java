package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class s
  implements Listener
{
  s(e parame, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    try
    {
      if ((this.b instanceof BusinessObjectClass))
      {
        BusinessObjectClass localBusinessObjectClass = (BusinessObjectClass)this.b;
        localBusinessObjectClass.reload();
        this.a.K().setModified(true);
        this.b.update();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      String str = ResourceTools.formatMessage("classNotFoundError", new String[] { localClassNotFoundException.getMessage() });
      Logger.getLogger("flagleader").log(Level.SEVERE, str);
      MessageDialog.openError(e.f(this.a).getShell(), null, str);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.s
 * JD-Core Version:    0.6.0
 */