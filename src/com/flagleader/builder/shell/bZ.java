package com.flagleader.builder.shell;

import com.flagleader.repository.export.Tag;
import com.flagleader.repository.export.TagType;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class bZ extends SelectionAdapter
{
  bZ(bX parambX)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.a.h() != null) && ((this.a.h().getData() instanceof TagType)))
      bX.h(this.a);
    else if ((this.a.h() != null) && ((this.a.h().getData() instanceof Tag)))
      bX.i(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bZ
 * JD-Core Version:    0.6.0
 */