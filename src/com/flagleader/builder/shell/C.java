package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class C extends SelectionAdapter
{
  C(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    p localp = ClassInfoEditor.c(this.a);
    if (localp != null)
      localp.A();
    else if (ClassInfoEditor.d(this.a).isFocusControl())
      this.a.d.A();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.C
 * JD-Core Version:    0.6.0
 */