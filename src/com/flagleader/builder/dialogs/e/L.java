package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class L extends SelectionAdapter
{
  L(C paramC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.a.getSelectionIndex() != 2)
    {
      C.a(this.a).resetFieldMappings(C.e(this.a));
      C.a(this.a, C.e(this.a));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.L
 * JD-Core Version:    0.6.0
 */