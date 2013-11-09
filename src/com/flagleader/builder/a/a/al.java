package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.br;
import com.flagleader.builder.a.bu;
import com.flagleader.db.IResult;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableModel;
import com.flagleader.sql.RuleTable;
import java.sql.Connection;
import org.eclipse.swt.widgets.Composite;

public class al extends a
  implements br, IElementViewer
{
  public al(TableModel paramTableModel, Composite paramComposite, bu parambu)
  {
    super(paramTableModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new al((TableModel)this.c, paramComposite, this.a);
  }

  protected IResult i()
  {
    Connection localConnection = null;
    localConnection = e().getDBModel().getConnection();
    RuleTable localRuleTable = ((TableModel)e()).getResultTable(localConnection);
    return localRuleTable;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.al
 * JD-Core Version:    0.6.0
 */