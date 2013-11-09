package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.g;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.TableItem;

class v
  implements g
{
  final ParameterModel a;

  v(r paramr, TableItem paramTableItem)
  {
    this.a = ((ParameterModel)paramTableItem.getData());
  }

  public String a()
  {
    return this.c.getText(1);
  }

  public void a(String paramString)
  {
    for (int i = 0; i < o.r.length; i++)
    {
      if ((!o.r[i].equals(paramString)) || (this.a.getModetype() == o.q[i]))
        continue;
      this.a.setModetype(o.q[i]);
      o.b(r.a(this.b)).changeParaMode(this.a);
      o.b(r.a(this.b)).setModified(true);
    }
  }

  public String[] b()
  {
    return o.r;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.v
 * JD-Core Version:    0.6.0
 */