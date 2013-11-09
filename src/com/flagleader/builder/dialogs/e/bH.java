package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFunctionEditen;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bH extends SelectionAdapter
{
  bH(bE parambE)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    bE.j(this.a).resetFieldMappings();
    bE.a(this.a, bE.e(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bH
 * JD-Core Version:    0.6.0
 */