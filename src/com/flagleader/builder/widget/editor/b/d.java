package com.flagleader.builder.widget.editor.b;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class d extends SelectionAdapter
{
  d(b paramb, Button paramButton1, Button paramButton2)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.b.getSelection())
    {
      this.c.setSelection(false);
      this.c.setEnabled(false);
    }
    else
    {
      this.c.setEnabled(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b.d
 * JD-Core Version:    0.6.0
 */