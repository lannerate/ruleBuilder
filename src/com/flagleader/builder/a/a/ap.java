package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.f;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import org.eclipse.swt.widgets.TableItem;

class ap
  implements f
{
  ap(ao paramao, TableItem paramTableItem)
  {
  }

  public String a()
  {
    return this.b.getText(9);
  }

  public boolean a(String paramString)
  {
    FieldModel localFieldModel = (FieldModel)this.b.getData();
    if (!localFieldModel.getDisplayName().equals(paramString))
    {
      localFieldModel.setDisplayName(paramString);
      an.c(ao.a(this.a)).changeFieldDisplayName(localFieldModel);
      an.c(ao.a(this.a)).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ap
 * JD-Core Version:    0.6.0
 */