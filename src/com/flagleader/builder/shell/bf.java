package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.p;
import java.net.URL;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TreeItem;

class bf extends MouseAdapter
{
  bf(aQ paramaQ)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    TreeItem localTreeItem = this.a.f();
    if ((localTreeItem != null) && (!localTreeItem.isDisposed()) && (localTreeItem.getData("path") != null))
    {
      if ((localTreeItem.getData("path") instanceof URL))
        aQ.a(this.a, (URL)localTreeItem.getData("path"));
      else
        aQ.b(this.a, localTreeItem.getData("path").toString());
      if ((aQ.b(this.a) != null) && (aQ.b(this.a).a() != null))
        this.a.d(aQ.b(this.a).a().getText());
      this.a.d();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bf
 * JD-Core Version:    0.6.0
 */