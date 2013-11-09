package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class aL extends SelectionAdapter
{
  aL(aK paramaK)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = aK.c(this.a).getSelectionIndex();
    if (i >= 0)
    {
      aK.a(this.a).setSourceSheet((IBusinessObject)aK.d(this.a).get(i));
      this.a.a = aK.a(this.a).getCanSelectSourceFields();
      String[] arrayOfString = new String[this.a.a.size()];
      for (int j = 0; j < this.a.a.size(); j++)
        arrayOfString[j] = ((IElement)this.a.a.get(j)).getDisplayName();
      aK.e(this.a).setItems(arrayOfString);
      if (aK.e(this.a).getItemCount() < 20)
        aK.e(this.a).setVisibleItemCount(aK.e(this.a).getItemCount());
      else
        aK.e(this.a).setVisibleItemCount(20);
      aK.f(this.a).setItems(arrayOfString);
      if (aK.f(this.a).getItemCount() < 20)
        aK.f(this.a).setVisibleItemCount(aK.f(this.a).getItemCount());
      else
        aK.f(this.a).setVisibleItemCount(20);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aL
 * JD-Core Version:    0.6.0
 */