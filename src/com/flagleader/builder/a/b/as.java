package com.flagleader.builder.a.b;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.tree.CustomFunction;
import org.eclipse.swt.widgets.Composite;

public class as extends aP
  implements IElementViewer
{
  public as(CustomFunction paramCustomFunction, Composite paramComposite, bu parambu)
  {
    super(paramCustomFunction, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new as((CustomFunction)this.c, paramComposite, this.a);
  }

  private CustomFunction e()
  {
    return (CustomFunction)this.c;
  }

  protected p b(Composite paramComposite)
  {
    this.e = s.a(1, new at(this), paramComposite, 68162, new au(this, e().getFunctionMember().getFunction()));
    return this.e;
  }

  protected void a(String paramString)
  {
    if (!e().getFunctionMember().getFunction().equals(paramString))
    {
      e().getFunctionMember().setFunction(paramString);
      e().setModified(true);
      e().updateTree();
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.e.a(e().getFunctionMember().getFunction());
    super.update();
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.as
 * JD-Core Version:    0.6.0
 */