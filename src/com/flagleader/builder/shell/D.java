package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class D extends SelectionAdapter
{
  D(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    p localp = ClassInfoEditor.c(this.a);
    if (localp != null)
      localp.B();
    else if (ClassInfoEditor.d(this.a).isFocusControl())
      this.a.d.B();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.D
 * JD-Core Version:    0.6.0
 */