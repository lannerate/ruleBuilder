package com.flagleader.builder.actions;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class ar extends SelectionAdapter
{
  ar(aq paramaq, CTabFolder paramCTabFolder)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b == null) || (this.b.getSelection() == null) || (this.b.getSelection().getControl() == null))
      return;
    if (this.b.getSelection().getText().equalsIgnoreCase(ResourceTools.getMessage("tomcat.log")))
      aq.b(this.a);
    if (this.b.getSelection().getText().equalsIgnoreCase(ResourceTools.getMessage("application.log")))
      aq.c(this.a);
    if (this.b.getSelection().getText().equalsIgnoreCase(ResourceTools.getMessage("engine.log")))
      aq.d(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ar
 * JD-Core Version:    0.6.0
 */