package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bm extends SelectionAdapter
{
  bm(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = be.e(this.a).getSelectionIndex();
    if (i >= 0)
    {
      be.a(this.a).setSourceSheet((IBusinessObject)be.d(this.a).get(i), false);
      be.b(this.a, be.a(this.a).getCanSelectSourceFields(false));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bm
 * JD-Core Version:    0.6.0
 */