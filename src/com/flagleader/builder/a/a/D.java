package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.f;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import org.eclipse.swt.widgets.TableItem;

class D
  implements f
{
  D(C paramC, TableItem paramTableItem)
  {
  }

  public String a()
  {
    return this.b.getText(6);
  }

  public boolean a(String paramString)
  {
    FieldModel localFieldModel = (FieldModel)this.b.getData();
    if (!localFieldModel.getDisplayName().equals(paramString))
    {
      localFieldModel.setDisplayName(paramString);
      B.c(C.a(this.a)).changeFieldDisplayName(localFieldModel);
      B.c(C.a(this.a)).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.D
 * JD-Core Version:    0.6.0
 */