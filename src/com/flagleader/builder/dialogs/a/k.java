package com.flagleader.builder.dialogs.a;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class k extends SelectionAdapter
{
  k(i parami)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.a.a != null) && (this.a.a.getSelection() != null) && (this.a.a.getSelection().length > 0))
      i.a(this.a, this.a.a.getSelection()[0].getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.k
 * JD-Core Version:    0.6.0
 */