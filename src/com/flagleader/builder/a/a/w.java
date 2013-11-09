package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.g;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.TableItem;

class w
  implements g
{
  final ParameterModel a;

  w(r paramr, TableItem paramTableItem)
  {
    this.a = ((ParameterModel)paramTableItem.getData());
  }

  public String a()
  {
    return this.c.getText(2);
  }

  public void a(String paramString)
  {
    for (int i = 0; i < o.t.length; i++)
    {
      if ((!o.t[i].equals(paramString)) || (this.a.getIType() == o.s[i]))
        continue;
      this.a.setIType(o.s[i]);
      o.b(r.a(this.b)).changeParaType(this.a);
      o.b(r.a(this.b)).setModified(true);
    }
  }

  public String[] b()
  {
    return o.t;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.w
 * JD-Core Version:    0.6.0
 */