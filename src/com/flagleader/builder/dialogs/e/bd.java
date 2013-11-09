package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bd extends SelectionAdapter
{
  bd(bc parambc)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = bc.a(this.a).getSelectionIndex();
    if ((i >= 0) && (!((IBusinessObject)bc.b(this.a).get(i)).getJavaType().equals(bc.c(this.a))))
    {
      bc.a(this.a, ((IBusinessObject)bc.b(this.a).get(i)).getJavaType());
      bc.d(this.a).setItems(aK.a(bc.e(this.a)).getTypeFunctions(bc.c(this.a)));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bd
 * JD-Core Version:    0.6.0
 */