package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bn extends SelectionAdapter
{
  bn(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = be.f(this.a).getSelectionIndex();
    if (i >= 0)
    {
      List localList = be.a(this.a).getCanSelectSourceFields(true);
      be.a(this.a).setSourcrField((IBusinessObject)localList.get(i), 0);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bn
 * JD-Core Version:    0.6.0
 */