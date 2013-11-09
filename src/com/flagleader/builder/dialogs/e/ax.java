package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class ax extends SelectionAdapter
{
  ax(as paramas)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.a.getSelectionIndex() != 2)
    {
      as.a(this.a).resetFieldMappings(as.e(this.a));
      as.a(this.a, as.e(this.a));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ax
 * JD-Core Version:    0.6.0
 */