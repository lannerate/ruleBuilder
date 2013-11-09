package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bf extends SelectionAdapter
{
  bf(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = be.c(this.a).getSelectionIndex();
    if (i >= 0)
    {
      be.a(this.a).setSourceSheet((IBusinessObject)be.d(this.a).get(i), true);
      be.a(this.a, be.a(this.a).getCanSelectSourceFields(true));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bf
 * JD-Core Version:    0.6.0
 */