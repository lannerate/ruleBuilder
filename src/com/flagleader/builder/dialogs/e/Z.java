package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class Z extends SelectionAdapter
{
  Z(Y paramY)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = Y.c(this.a).getSelectionIndex();
    if (i >= 0)
      Y.a(this.a).setSourceSheet((IBusinessObject)Y.d(this.a).get(i));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.Z
 * JD-Core Version:    0.6.0
 */