package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bl extends SelectionAdapter
{
  bl(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (be.j(this.a).getSelectionIndex() <= 1)
    {
      be.a(this.a).resetFieldMappings(be.j(this.a).getSelectionIndex() == 0);
      be.a(this.a, be.j(this.a).getSelectionIndex() == 0);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bl
 * JD-Core Version:    0.6.0
 */