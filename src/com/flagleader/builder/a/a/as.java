package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.g;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import org.eclipse.swt.widgets.TableItem;

class as
  implements g
{
  final FieldModel a;

  as(ao paramao, TableItem paramTableItem)
  {
    this.a = ((FieldModel)paramTableItem.getData());
  }

  public String a()
  {
    return this.c.getText(8);
  }

  public void a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("true")) && (!this.a.isReadOnly()))
    {
      this.a.setReadOnly(true);
      an.c(ao.a(this.b)).setModified(true);
    }
    if ((paramString.equalsIgnoreCase("false")) && (this.a.isReadOnly()))
    {
      this.a.setReadOnly(false);
      an.c(ao.a(this.b)).setModified(true);
    }
  }

  public String[] b()
  {
    return new String[] { "true", "false" };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.as
 * JD-Core Version:    0.6.0
 */