package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.b.G;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class t
  implements Listener
{
  t(e parame, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    G localG = new G(this.a.K().getEnvionment());
    if (localG.open() == 0)
    {
      SheetTable localSheetTable = localG.a();
      if (localSheetTable != null)
      {
        this.a.K().initUndoable();
        if (localSheetTable.moveVariable((IVariableObject)this.b))
        {
          this.a.K().setModified(true);
          this.a.K().takeSnapshot();
          this.a.update();
        }
      }
      else if (localG.b() == 0)
      {
        this.a.K().initUndoable();
        this.a.K().getEnvionment().getValueLibrary().moveVariable((IVariableObject)this.b);
        this.a.K().setModified(true);
        this.a.K().takeSnapshot();
        this.a.update();
      }
      else if (localG.b() == 1)
      {
        this.a.K().initUndoable();
        this.a.K().getEnvionment().getTempVariableLibrary().moveVariable((IVariableObject)this.b);
        this.a.K().setModified(true);
        this.a.K().setModified(true);
        this.a.update();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.t
 * JD-Core Version:    0.6.0
 */