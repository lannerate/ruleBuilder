package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bo extends SelectionAdapter
{
  bo(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = be.g(this.a).getSelectionIndex();
    if (i >= 0)
    {
      List localList = be.a(this.a).getCanSelectSourceFields(false);
      be.a(this.a).setSourcrField((IBusinessObject)localList.get(i), 2);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bo
 * JD-Core Version:    0.6.0
 */