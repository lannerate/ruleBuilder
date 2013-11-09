package com.flagleader.builder.e.h;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;

class h extends FocusAdapter
{
  h(f paramf, CCombo paramCCombo, TableItem paramTableItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (this.b.getSelectionIndex() >= 0)
    {
      Object localObject = this.c.getData();
      f.c(this.a).put(f.d(this.a).get(this.b.getSelectionIndex()), localObject);
      this.a.a.put(localObject, f.d(this.a).get(this.b.getSelectionIndex()));
      this.c.setText(3, f.a(this.a, f.d(this.a).get(this.b.getSelectionIndex())));
    }
    this.b.dispose();
    f.e(this.a).setEditor(null, null, -1);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.h.h
 * JD-Core Version:    0.6.0
 */