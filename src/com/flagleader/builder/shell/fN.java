package com.flagleader.builder.shell;

import com.flagleader.builder.widget.editor.i.e;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.a.b;
import com.flagleader.util.ListIterator;
import java.util.Iterator;
import org.eclipse.swt.custom.StyledText;

class fN extends e
{
  fN(fE paramfE)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(fE.f(this.a).getDBTableFields(b.a(fE.a(this.a).a().getText(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(fE.f(this.a).getDBTableNames());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fN
 * JD-Core Version:    0.6.0
 */