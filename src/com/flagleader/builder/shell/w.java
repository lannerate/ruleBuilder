package com.flagleader.builder.shell;

import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class w extends FocusAdapter
{
  w(ClassInfoEditor paramClassInfoEditor, TableItem paramTableItem, Text paramText, int paramInt, TableEditor paramTableEditor)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    ClassInfoEditor.a(this.a, this.b, this.c, this.d, this.e);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.w
 * JD-Core Version:    0.6.0
 */