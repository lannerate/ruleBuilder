package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderConfig;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class B extends SelectionAdapter
{
  B(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (z.k(this.a).getSelection())
      BuilderConfig.getInstance().setLoadDefault(true);
    else
      BuilderConfig.getInstance().setLoadDefault(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.B
 * JD-Core Version:    0.6.0
 */