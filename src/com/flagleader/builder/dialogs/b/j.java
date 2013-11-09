package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.widget.editor.i.e;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.a.b;
import com.flagleader.util.ListIterator;
import java.util.Iterator;
import org.eclipse.swt.custom.StyledText;

class j extends e
{
  j(i parami)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(i.a(this.a).getDBTableFields(b.a(i.b(this.a).a().getText(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(i.a(this.a).getDBTableNames());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.j
 * JD-Core Version:    0.6.0
 */