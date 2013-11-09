package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class at extends SelectionAdapter
{
  at(as paramas)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = as.c(this.a).getSelectionIndex();
    if (i >= 0)
      as.a(this.a).setSourceSheet((IBusinessObject)as.d(this.a).get(i));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.at
 * JD-Core Version:    0.6.0
 */