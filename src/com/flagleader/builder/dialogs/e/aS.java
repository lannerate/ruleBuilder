package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class aS extends SelectionAdapter
{
  aS(aK paramaK)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = aK.f(this.a).getSelectionIndex();
    if (i >= 0)
      aK.a(this.a).setSheetValue((IBusinessObject)this.a.a.get(i));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aS
 * JD-Core Version:    0.6.0
 */