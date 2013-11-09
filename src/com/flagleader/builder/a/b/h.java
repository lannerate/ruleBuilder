package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.b.G;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class h
  implements Listener
{
  h(e parame)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    G localG = new G(this.a.K().getEnvionment());
    if (localG.open() == 0)
    {
      SheetTable localSheetTable = localG.a();
      IElement[] arrayOfIElement;
      int i;
      if (localSheetTable != null)
      {
        arrayOfIElement = e.b(this.a);
        if (arrayOfIElement.length > 0)
        {
          this.a.K().initUndoable();
          for (i = 0; i < arrayOfIElement.length; i++)
          {
            if ((arrayOfIElement[i] == null) || ((!(arrayOfIElement[i] instanceof TempVariable)) && (!(arrayOfIElement[i] instanceof MappingVariable)) && (!(arrayOfIElement[i] instanceof SheetFieldModel))))
              continue;
            localSheetTable.moveVariable((IVariableObject)arrayOfIElement[i]);
          }
          this.a.K().setModified(true);
          this.a.K().takeSnapshot();
          this.a.K().updateViewer();
        }
      }
      else if (localG.b() == 0)
      {
        arrayOfIElement = e.b(this.a);
        if (arrayOfIElement.length > 0)
        {
          this.a.K().initUndoable();
          for (i = 0; i < arrayOfIElement.length; i++)
          {
            if ((arrayOfIElement[i] == null) || ((!(arrayOfIElement[i] instanceof TempVariable)) && (!(arrayOfIElement[i] instanceof MappingVariable)) && (!(arrayOfIElement[i] instanceof SheetFieldModel))))
              continue;
            this.a.K().getEnvionment().getValueLibrary().moveVariable((IVariableObject)arrayOfIElement[i]);
          }
          this.a.K().setModified(true);
          this.a.K().takeSnapshot();
          this.a.K().updateViewer();
        }
      }
      else if (localG.b() == 1)
      {
        arrayOfIElement = e.b(this.a);
        if (arrayOfIElement.length > 0)
        {
          this.a.K().initUndoable();
          for (i = 0; i < arrayOfIElement.length; i++)
          {
            if ((arrayOfIElement[i] == null) || ((!(arrayOfIElement[i] instanceof TempVariable)) && (!(arrayOfIElement[i] instanceof MappingVariable)) && (!(arrayOfIElement[i] instanceof SheetFieldModel))))
              continue;
            this.a.K().getEnvionment().getTempVariableLibrary().moveVariable((IVariableObject)arrayOfIElement[i]);
          }
          this.a.K().setModified(true);
          this.a.K().takeSnapshot();
          this.a.K().updateViewer();
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.h
 * JD-Core Version:    0.6.0
 */