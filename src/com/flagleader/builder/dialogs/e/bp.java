package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bp extends SelectionAdapter
{
  bp(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = be.h(this.a).getSelectionIndex();
    if (i >= 0)
    {
      List localList = be.a(this.a).getCanSelectFields();
      be.a(this.a).setSourcrField((IBusinessObject)localList.get(i), 1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bp
 * JD-Core Version:    0.6.0
 */