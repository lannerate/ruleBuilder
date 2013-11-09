package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.g;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.TableItem;

class u
  implements g
{
  final ParameterModel a;

  u(r paramr, TableItem paramTableItem)
  {
    this.a = ((ParameterModel)paramTableItem.getData());
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
      o.b(r.a(this.b)).changeParaType(this.a);
      o.b(r.a(this.b)).setModified(true);
    }
  }

  public String[] b()
  {
    for (int i = 0; i < o.s.length; i++)
      if (o.s[i] == this.a.getIType())
        return o.v[i];
    return new String[0];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.u
 * JD-Core Version:    0.6.0
 */