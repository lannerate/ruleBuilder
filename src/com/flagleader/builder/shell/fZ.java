package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class fZ extends SelectionAdapter
{
  fZ(fE paramfE)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.b.isFocusControl())
      this.a.b.paste();
    else if (fE.b(this.a).isFocusControl())
      fE.b(this.a).paste();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fZ
 * JD-Core Version:    0.6.0
 */