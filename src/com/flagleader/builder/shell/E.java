package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class E extends SelectionAdapter
{
  E(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    ClassInfoEditor.e(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.E
 * JD-Core Version:    0.6.0
 */