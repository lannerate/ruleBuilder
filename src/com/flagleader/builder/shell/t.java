package com.flagleader.builder.shell;

import com.flagleader.repository.lang.info.InfoClass;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

class t extends FocusAdapter
{
  t(ClassInfoEditor paramClassInfoEditor, InfoClass paramInfoClass, TreeItem paramTreeItem, String paramString)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((ClassInfoEditor.j(this.a) == null) && (ClassInfoEditor.j(this.a).isDisposed()))
      return;
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.t
 * JD-Core Version:    0.6.0
 */