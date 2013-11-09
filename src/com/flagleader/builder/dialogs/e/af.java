package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class af extends SelectionAdapter
{
  af(Y paramY)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (!Y.e(this.a))
    {
      Y.a(this.a).resetFieldMappings();
      Y.f(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.af
 * JD-Core Version:    0.6.0
 */