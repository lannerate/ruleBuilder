package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;

public class bh extends bi
{
  public bh(bf parambf)
  {
    super(parambf);
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    MessageDialog.openError(bf.a(this.a).getShell(), "", ResourceTools.getMessage("error.dialog"));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bh
 * JD-Core Version:    0.6.0
 */