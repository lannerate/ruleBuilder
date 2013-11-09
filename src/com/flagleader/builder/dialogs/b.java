package com.flagleader.builder.dialogs;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class b extends SelectionAdapter
{
  b(AboutLicenseDialog paramAboutLicenseDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    l locall = new l(null);
    locall.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b
 * JD-Core Version:    0.6.0
 */