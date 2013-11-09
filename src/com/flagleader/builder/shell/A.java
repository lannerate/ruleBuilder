package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class A extends SelectionAdapter
{
  A(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    p localp = ClassInfoEditor.c(this.a);
    if ((localp != null) && (localp.f()))
      localp.c();
    this.a.d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.A
 * JD-Core Version:    0.6.0
 */