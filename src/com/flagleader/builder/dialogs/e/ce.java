package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class ce extends SelectionAdapter
{
  ce(cd paramcd)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = cd.a(this.a).getSelectionIndex();
    if ((i >= 0) && (!bS.b(cd.d(this.a))[i].getJavaType().equals(cd.b(this.a))))
    {
      cd.a(this.a, bS.b(cd.d(this.a))[i].getJavaType());
      cd.c(this.a).setItems(bS.c(cd.d(this.a)).getTypeFunctions(cd.b(this.a)));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ce
 * JD-Core Version:    0.6.0
 */