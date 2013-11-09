package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderConfig;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class K extends SelectionAdapter
{
  K(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (z.j(this.a).getSelection())
      BuilderConfig.getInstance().setFirstLogin(true);
    else
      BuilderConfig.getInstance().setFirstLogin(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.K
 * JD-Core Version:    0.6.0
 */