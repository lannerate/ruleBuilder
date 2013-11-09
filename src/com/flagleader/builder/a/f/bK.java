package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aL;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bq;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.a.v;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.ITreeNode;
import java.util.HashMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class bK extends aL
  implements bq, IElementViewer
{
  private BuilderManager g;
  private HashMap q = new HashMap();

  public bK(IRuleSet paramIRuleSet, Composite paramComposite, bu parambu)
  {
    super(paramIRuleSet, paramComposite, parambu);
    this.g = parambu.i();
  }

  protected aS e(Composite paramComposite)
  {
    return new bK((IRuleSet)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new bP(this));
    super.h();
  }

  private IRuleSet e()
  {
    return (IRuleSet)this.c;
  }

  protected af b(Composite paramComposite)
  {
    this.e = new v(a(), paramComposite, 68162);
    StyledText localStyledText = this.e.m();
    localStyledText.setEditable(false);
    Color localColor = Display.getDefault().getSystemColor(29);
    localStyledText.setBackground(localColor);
    localStyledText.setForeground(Display.getDefault().getSystemColor(9));
    localStyledText.addMouseMoveListener(new bL(this, localStyledText));
    localStyledText.addMouseListener(new bM(this, localStyledText));
    return this.e;
  }

  private void a(boolean paramBoolean)
  {
    bN localbN = new bN(this, paramBoolean);
    a(localbN, true);
    localbN.start();
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    a(false);
    super.update();
  }

  private void c(String paramString)
  {
    if (!this.e.m().isDisposed())
      this.e.m().getDisplay().asyncExec(new bO(this, paramString));
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getMaxModifyTime()) || (this.d < e().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "jav";
  }

  protected void a(String paramString)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bK
 * JD-Core Version:    0.6.0
 */