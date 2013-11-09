package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.g;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import org.eclipse.swt.widgets.TableItem;

class ar
  implements g
{
  final FieldModel a;

  ar(ao paramao, TableItem paramTableItem)
  {
    this.a = ((FieldModel)paramTableItem.getData());
  }

  public String a()
  {
    return this.c.getText(6);
  }

  public void a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("true")) && (!this.a.isPrimaryKey()))
    {
      this.a.setPrimaryKey(true);
      an.c(ao.a(this.b)).setModified(true);
    }
    if ((paramString.equalsIgnoreCase("false")) && (this.a.isPrimaryKey()))
    {
      this.a.setPrimaryKey(false);
      an.c(ao.a(this.b)).setModified(true);
    }
  }

  public String[] b()
  {
    return new String[] { "true", "false" };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ar
 * JD-Core Version:    0.6.0
 */