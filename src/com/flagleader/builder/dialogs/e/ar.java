package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class ar extends SelectionAdapter
{
  ar(aq paramaq)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = aq.a(this.a).getSelectionIndex();
    if ((i >= 0) && (!((IBusinessObject)aq.b(this.a).get(i)).getJavaType().equals(aq.c(this.a))))
    {
      aq.a(this.a, ((IBusinessObject)aq.b(this.a).get(i)).getJavaType());
      aq.d(this.a).setItems(Y.a(aq.e(this.a)).getTypeFunctions(aq.c(this.a)));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ar
 * JD-Core Version:    0.6.0
 */