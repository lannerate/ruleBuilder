package com.flagleader.builder.a.a;

import com.flagleader.builder.widget.editor.i.e;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.a.b;
import com.flagleader.util.ListIterator;
import java.util.Iterator;
import org.eclipse.swt.custom.StyledText;

class i extends e
{
  i(h paramh)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(this.a.e().getDBModel().getDBTableFields(b.a(h.a(this.a).a().getText(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(this.a.e().getDBModel().getDBTableNames());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.i
 * JD-Core Version:    0.6.0
 */