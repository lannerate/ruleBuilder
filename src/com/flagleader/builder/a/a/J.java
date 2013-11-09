package com.flagleader.builder.a.a;

import com.flagleader.builder.widget.editor.i.e;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.a.b;
import com.flagleader.util.ListIterator;
import java.util.Iterator;
import org.eclipse.swt.custom.StyledText;

class J extends e
{
  J(I paramI)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(I.a(this.a).getDBModel().getDBTableFields(b.a(I.b(this.a).a().getText(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(I.a(this.a).getDBModel().getDBTableNames());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.J
 * JD-Core Version:    0.6.0
 */