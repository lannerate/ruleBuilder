package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.widget.editor.i.e;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.repository.db.DBModel;
import com.flagleader.util.ListIterator;
import java.util.Iterator;
import org.eclipse.swt.custom.StyledText;

class b extends e
{
  b(a parama)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(a.a(this.a).getDBTableFields(com.flagleader.repository.db.a.b.a(a.b(this.a).a().getText(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(a.a(this.a).getDBTableNames());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.b
 * JD-Core Version:    0.6.0
 */