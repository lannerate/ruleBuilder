package com.flagleader.builder.shell;

import com.flagleader.repository.lang.info.InfoClass;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

class s
  implements TraverseListener
{
  s(ClassInfoEditor paramClassInfoEditor, InfoClass paramInfoClass, TreeItem paramTreeItem, String paramString)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((ClassInfoEditor.j(this.a) == null) && (ClassInfoEditor.j(this.a).isDisposed()))
      return;
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = ClassInfoEditor.j(this.a).getText();
      this.b.setDisplayName(str);
      if (str.length() > 0)
        this.c.setText(str + "(" + this.d + ")");
      else
        this.c.setText(this.d);
      this.b.setModified(true);
      this.a.d();
      ClassInfoEditor.j(this.a).dispose();
      ClassInfoEditor.a(this.a, null);
    }
    if (paramTraverseEvent.detail == 2)
    {
      ClassInfoEditor.j(this.a).dispose();
      ClassInfoEditor.a(this.a, null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.s
 * JD-Core Version:    0.6.0
 */