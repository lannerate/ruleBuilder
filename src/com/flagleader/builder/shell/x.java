package com.flagleader.builder.shell;

import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class x
  implements TraverseListener
{
  x(ClassInfoEditor paramClassInfoEditor, TableItem paramTableItem, Text paramText, int paramInt, TableEditor paramTableEditor)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      ClassInfoEditor.a(this.a, this.b, this.c, this.d, this.e);
    if (paramTraverseEvent.detail == 2)
      ClassInfoEditor.a(this.a, this.c, this.e);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.x
 * JD-Core Version:    0.6.0
 */