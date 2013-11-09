package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.br;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.b.I;
import com.flagleader.db.IResult;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.TableFunction;
import java.sql.Connection;
import java.util.List;
import org.eclipse.swt.widgets.Composite;

public class A extends a
  implements br, IElementViewer
{
  private Object[] q = null;

  public A(SelectTable paramSelectTable, Composite paramComposite, bu parambu)
  {
    super(paramSelectTable, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new A((SelectTable)this.c, paramComposite, this.a);
  }

  protected IResult i()
  {
    Connection localConnection = null;
    localConnection = e().getDBModel().getConnection();
    return k().getResultTable(localConnection, this.q);
  }

  protected SelectTable k()
  {
    return (SelectTable)this.c;
  }

  protected boolean g()
  {
    if (k().getTableFunction("selectWhere").getAllParams().size() > 0)
    {
      I localI = new I(k());
      if (localI.open() == 0)
        this.q = localI.a();
      else
        return false;
    }
    return super.g();
  }

  public String getCompositeUuid()
  {
    return k().getEditUuid() + "data";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.A
 * JD-Core Version:    0.6.0
 */