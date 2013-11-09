package com.flagleader.builder.a.f;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ExpressionRule;
import org.eclipse.swt.widgets.Composite;

public class aT extends aP
  implements IElementViewer
{
  public aT(ExpressionRule paramExpressionRule, Composite paramComposite, bu parambu)
  {
    super(paramExpressionRule, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aT((ExpressionRule)this.c, paramComposite, this.a);
  }

  private ExpressionRule e()
  {
    return (ExpressionRule)this.c;
  }

  protected p b(Composite paramComposite)
  {
    this.e = s.a(8, new aU(this), paramComposite, 68162, new aV(this, e().getExpression()));
    return this.e;
  }

  protected void a(String paramString)
  {
    if (!e().getExpression().equals(paramString))
    {
      e().setExpression(paramString);
      e().changeText();
      e().updateTree();
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.e.a(e().getExpression());
    super.update();
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aT
 * JD-Core Version:    0.6.0
 */