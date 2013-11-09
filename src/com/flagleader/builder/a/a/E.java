package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.g;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.lang.h;
import org.eclipse.swt.widgets.TableItem;

class E
  implements g
{
  final FieldModel a;

  E(C paramC, TableItem paramTableItem)
  {
    this.a = ((FieldModel)paramTableItem.getData());
  }

  public String a()
  {
    return this.c.getText(3);
  }

  public void a(String paramString)
  {
    if (!this.a.getValueType().equals(paramString))
    {
      this.a.setValueType(paramString);
      B.c(C.a(this.b)).changeFieldType(this.a);
      B.c(C.a(this.b)).setModified(true);
    }
  }

  public String[] b()
  {
    return B.c(C.a(this.b)).getTypeManager().b(this.a.getDefaultType());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.E
 * JD-Core Version:    0.6.0
 */