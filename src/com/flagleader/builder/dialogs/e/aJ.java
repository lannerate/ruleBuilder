package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class aJ extends SelectionAdapter
{
  aJ(aI paramaI)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = aI.a(this.a).getSelectionIndex();
    if ((i >= 0) && (!((IBusinessObject)aI.b(this.a).get(i)).getJavaType().equals(aI.c(this.a))))
    {
      aI.a(this.a, ((IBusinessObject)aI.b(this.a).get(i)).getJavaType());
      aI.d(this.a).setItems(as.a(aI.e(this.a)).getTypeFunctions(aI.c(this.a)));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aJ
 * JD-Core Version:    0.6.0
 */