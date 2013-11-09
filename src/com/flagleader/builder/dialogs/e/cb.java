package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class cb extends SelectionAdapter
{
  cb(bS parambS)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (bS.e(this.a).getSelectionIndex() >= 0)
      this.a.f();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.cb
 * JD-Core Version:    0.6.0
 */