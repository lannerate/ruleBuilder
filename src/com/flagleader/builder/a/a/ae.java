package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.f;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetMap;
import org.eclipse.swt.widgets.TableItem;

class ae
  implements f
{
  ae(ac paramac, TableItem paramTableItem)
  {
  }

  public String a()
  {
    return this.b.getText(1);
  }

  public boolean a(String paramString)
  {
    MapValue localMapValue = (MapValue)this.b.getData();
    if (!localMapValue.getKey().equals(paramString))
    {
      localMapValue.setKey(paramString);
      ac.a(this.a).q().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ae
 * JD-Core Version:    0.6.0
 */