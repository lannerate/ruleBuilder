package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.DecisionMultiRule;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

public class j extends com.flagleader.builder.a.c.a
{
  public j(a parama)
  {
  }

  public void a()
  {
    a.b(this.a).setValueNum(a.b(this.a).getValueNum() + 1);
    Object localObject1 = new Clipboard(Display.getCurrent()).getContents(d.a());
    Object localObject2 = localObject1;
    if ((localObject2 != null) && (a.b(this.a).canPasteValueElement(a.b(this.a).getValueNum(), localObject2)))
      a.b(this.a).pasteValueElement(a.b(this.a).getValueNum(), ((IElement)localObject2).deepClone());
    a.b(this.a).setModified(true);
    a.b(this.a).updateViewer();
  }

  public boolean b()
  {
    return !a.d(this.a);
  }

  public String c()
  {
    return "AddValue";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.j
 * JD-Core Version:    0.6.0
 */