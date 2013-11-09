package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.DecisionRelateRule;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

public class I extends a
{
  public I(o paramo)
  {
  }

  public void a()
  {
    o.a(this.a).setValueNum(o.a(this.a).getValueNum() + 1);
    Object localObject1 = new Clipboard(Display.getCurrent()).getContents(d.a());
    Object localObject2 = localObject1;
    if ((localObject2 != null) && (o.a(this.a).canPasteValueElement(o.a(this.a).getValueNum(), localObject2)))
      o.a(this.a).pasteValueElement(o.a(this.a).getValueNum(), ((IElement)localObject2).deepClone());
    o.a(this.a).setModified(true);
    o.a(this.a).updateViewer();
  }

  public boolean b()
  {
    return !o.c(this.a);
  }

  public String c()
  {
    return "AddValue";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.I
 * JD-Core Version:    0.6.0
 */